package com.ex.ssg.answer;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import com.ex.ssg.question.Question;
import com.ex.ssg.user.SiteUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//데이터를 관리하는데 사용하는 ORM(Object Relational Mapping)클레스를 엔티티라고 한다.
//JAVA 진영에서 ORM의 기술표준으로 사용하는 인터페이스의 모음을 JPA(Java Persistence API)라고한다.
@Entity
public class Answer {
    
    @Id
    // 데이터를 저장할 때 해당속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장된다.
    // strategy는 고유번호를 생성하는 옵션. 생략시 지정된 칼럼들이 모두 동일한 시퀀스로 번호를 생성하기 때문에 일정한 순서의 고유번호를 가질 수 없게 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 컬럼명에따라 세부설정용도로 사용.
   //length는 컬럼의 길이를 설정.
   // columnDefinition은 컬럼의 속성을 정의할 때 사용. 'TEXT'는 '내용'처럼 글자 수를 제한 할 수 없는 경우에 사용.
    // 테이블컬럼으로 인식하고 싶지 않은 경우에 @Transient 어노테이션을 사용.
    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    // 답변객체를 통해 질문 객체의 제목을 알고 싶다면 answer.getQuestion().getSubject()로 접근할 수 있다. 명시적표시를 해야한다.
    // 하나의 질문에 많은 답변이 달리는 것과 같은구조.
    @ManyToOne
    private Question question;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}
