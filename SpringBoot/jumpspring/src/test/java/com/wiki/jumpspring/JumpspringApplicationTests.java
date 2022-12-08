package com.wiki.jumpspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wiki.jumpspring.Question.QuestionService;

// import com.wiki.jumpspring.Question.QuestionRepository;

@SpringBootTest
class JumpspringApplicationTests {

	// 객체를 주입하는 방식에는 @Autowired 외에 Setter 또는 생성자를 사용하는 방식이 있다.
	// 순환참조 문제와 같은 이유로 @Autowired 보다는 생성자를 통한 객체 주입방식이 권장된다. 
	// 하지만 테스트 코드의 경우에는 생성자를 통한 객체의 주입이 불가능하므로 테스트 코드 작성시에만 
	// @Autowired를 사용하고 실제 코드 작성시에는 생성자를 통한 객체 주입방식을 사용한다.
	@Autowired
	// private QuestionRepository questionRepository;
	private QuestionService questionService;
	
	@Test
	void testJpa() {
		// Question q1 = new Question();
        // q1.setSubject("sbb가 무엇인가요?");
        // q1.setContent("sbb에 대해서 알고 싶습니다.");
        // q1.setCreateDate(LocalDateTime.now());
        // this.questionRepository.save(q1);  // 첫번째 질문 저장

        // Question q2 = new Question();
        // q2.setSubject("스프링부트 모델 질문입니다.");
        // q2.setContent("id는 자동으로 생성되나요?");
        // q2.setCreateDate(LocalDateTime.now());
        // this.questionRepository.save(q2);  // 두번째 질문 저장

		// for(int i=1; i<=300; i++) {
			// String subject = String.format("테스트 데이터입니다:[%03d]",i);
			// String content = "내용 없음";
			// this.questionService.create(subject,content);
		// }
	}

}
