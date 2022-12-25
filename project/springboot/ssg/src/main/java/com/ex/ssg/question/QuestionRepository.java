package com.ex.ssg.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// 레포지토리Repository 
// 엔티티 Entity 에 의해 생성된 데이터베이스 테이블에 접근하는 메서드들(findAll, save 등)을 사용하기 위한 인터페이스
// 데이터 처리를 위해서 필요한 CRUD(Create, Read, Update, Delete)를 어떻게 처리할지 정의하는 계층.

// JpaRepository 상속시 레포지토리 엔티티 타입(Question)과 해당 엔티티의 프라이머리 키PK (Integer)을 지정해야 한다.
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
    Page<Question>findAll(Pageable pageable);
    Page<Question> findAll(Specification<Question> spec, Pageable pageable);

    // Secification 대신 직접 쿼리를 작성하여 수행하는 방법.
    // @Query("select "
    //         + "distinct q "
    //         + "from Question q " 
    //         + "left outer join SiteUser u1 on q.author=u1 "
    //         + "left outer join Answer a on a.question=q "
    //         + "left outer join SiteUser u2 on a.author=u2 "
    //         + "where "
    //         + "   q.subject like %:kw% "
    //         + "   or q.content like %:kw% "
    //         + "   or u1.username like %:kw% "
    //         + "   or a.content like %:kw% "
    //         + "   or u2.username like %:kw% ")
    // Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
