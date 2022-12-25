package com.ex.ssg.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ex.ssg.DataNotFoundException;
import com.ex.ssg.answer.Answer;
import com.ex.ssg.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
    
    private final QuestionRepository questionRepository;

    private Specification<Question> search(String kw) {
        return new Specification<Question>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);  // 중복을 제거 
                // SiteUser 엔티티의 객체
                Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT);
                // Answer 엔티티의 객체
                Join<Question, Answer> a = q.join("answerList", JoinType.LEFT);
                // 답변 작성자 검색을 위한 SiteUser 엔티티 객체
                Join<Answer, SiteUser> u2 = a.join("author", JoinType.LEFT);
                return cb.or(
                    // 제목
                    cb.like(q.get("subject"), "%" + kw + "%"),
                    // 내용
                    cb.like(q.get("content"), "%" + kw + "%"),
                    // 질문 작성자
                    cb.like(u1.get("username"), "%" + kw + "%"),
                    // 답변 내용
                    cb.like(a.get("content"), "%" + kw + "%"),
                    // 답변 작성자
                    cb.like(u2.get("username"), "%" + kw + "%"));
            }
        };
    }

    // public List<Question> getList() {
        // return this.questionRepository.findAll();
    // }
    public Page<Question> getList(int page, String kw){
        List<Sort.Order> sorts= new ArrayList<>();
        sorts.add(Sort.Order.desc("cresteDate"));
        Pageable pageable = PageRequest.of(page,10);
        Specification<Question> spec = search(kw);
        // QuestionRepository에서 작성한 findAllkeyword메소드를 사용하기위해 수정.
        // return this.questionRepository.findAllByKeyword(kw, pageable);
        return this.questionRepository.findAll(spec, pageable);
    }

    // Id 값으로 Question 데이터 조회하는 getQuestion 메소트 추가.
    // isPresent 메소드로 해당 데이터가 존재하는지 검사. id 값에 해당하는 Question 데이터가 없을 경우 오류 발생
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        // isPresent메소드로 해당 데이터가 존재하는지 검사.
        if (question.isPresent()) {
            return question.get();
        } else {
            // id 값에 해당하는 question 데이터가 없을 경우 메세지 발생.
            throw new DataNotFoundException("question not found");
        }
    }

    // 질문 저장
    public void create(String subject, String content, SiteUser user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }

    // 질문데이터 수정
    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    // 질문 삭제 기능
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }

    // 추천인 저 public void vote(Question question, SiteUser siteUser) {
    public void vote(Question question, SiteUser siteUser) {
        question.getVoter().add(siteUser);
        this.questionRepository.save(question);
    }
}
