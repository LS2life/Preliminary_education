package com.ex.ssg.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ex.ssg.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
    
    private final QuestionRepository questionRepository;

    public Page<Question> getList(int page){
        List<Sort.Order> sorts= new ArrayList<>();
        sorts.add(Sort.Order.desc("cresteDate"));
        Pageable pageable = PageRequest.of(page,10);
        return this.questionRepository.findAll(pageable);
    }

    // Id 값으로 Question 데이터 조회하는 getQuestion 메소트 추가.
    // isPresent 메소드로 해당 데이터가 존재하는지 검사. id 값에 해당하는 Question 데이터가 없을 경우 오류 발생
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    // 질문 저장
    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
}
