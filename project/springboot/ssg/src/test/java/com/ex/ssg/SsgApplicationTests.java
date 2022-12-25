package com.ex.ssg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

// import com.ex.ssg.answer.AnswerRepository;
// import com.ex.ssg.question.QuestionRepository;
import com.ex.ssg.question.QuestionService;

@SpringBootTest
class SsgApplicationTests {

    // 객체를 주입하는 방식에는 @Autowired 외에 Setter 또는 생성자를 사용하는 방식이 있다.
	// 순환참조 문제와 같은 이유로 @Autowired 보다는 생성자를 통한 객체 주입방식이 권장된다. 
	// 하지만 테스트 코드의 경우에는 생성자를 통한 객체의 주입이 불가능하므로 테스트 코드 작성시에만 
	// @Autowired를 사용하고 실제 코드 작성시에는 생성자를 통한 객체 주입방식을 사용한다.
	// @Autowired
	// private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    // @Autowired
    // private AnswerRepository answerRepository;
    @Transactional
    @Test
    void testJpa2(){

        // 질문객체로부터 답변리스트를 구하는 테스트코드다. 오류방지를 위해 @Transactional을 사용한다
        //  Optional<Question> oq = this.questionRepository.findById(2);
        // assertTrue(oq.isPresent());
        // Question q = oq.get();

    }

	@Test
	void testJpa() {

        // 테스트 데이터 여러개 만들기
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content);
        }

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

        // findAll은 데이터를 조회할 때 사용하는 메소드다.
        // List<Question> all = this.questionRepository.findAll();
        // assertEquals(2, all.size());

        // Question q = all.get(0);
        // assertEquals("sbb가 무엇인가요?", q.getSubject());

        // Question 엔티티의 Id값으로 데이터를 조회한다.
        // Optional<Question> oq = this.questionRepository.findById(1);
        // if(oq.isPresent()) {
        //     Question q = oq.get();
        //     assertEquals("sbb가 무엇인가요?", q.getSubject());
        // }

        // Question 엔티티의 subject 값으로 데이터를 조회한다.
        // Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        // assertEquals(1, q.getId());

        // 2개의 속성을 And 조건으로 조회한다. 레포지토리에도 추가해야한다.
        // Question q = this.questionRepository.findBySubjectAndContent(
        //     "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        // assertEquals(1, q.getId());

        // 제목에 특정 문자열이 포함되어있는 데이터를 조회한다.
        // List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        // Question q = qList.get(0);
        // assertEquals("sbb가 무엇인가요?", q.getSubject());

        // 질문데이터를 수정하는 테스트 코드.
        // Optional<Question> oq = this.questionRepository.findById(1);
        // assertTrue(oq.isPresent());
        // Question q = oq.get();
        // q.setSubject("수정된 제목");
        // this.questionRepository.save(q)

        // 데이터를 삭제하는 테스트코드.
        // assertEquals(2, this.questionRepository.count());
        // Optional<Question> oq = this.questionRepository.findById(1);
        // assertTrue(oq.isPresent());
        // Question q = oq.get();
        // this.questionRepository.delete(q);
        // assertEquals(1, this.questionRepository.count());

        // 답변(Answer) 데이터를 생성하고 저장하는 테스트.
        // Optional<Question> oq = this.questionRepository.findById(2);
        // assertTrue(oq.isPresent());
        // Question q = oq.get();

        // Answer a = new Answer();
        // a.setContent("네 자동으로 생성됩니다.");
        // a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
        // a.setCreateDate(LocalDateTime.now());
        // this.answerRepository.save(a);

        // Answer에서 Id값을 이용해 데이터를 조회한다.
        // Optional<Answer> oa = this.answerRepository.findById(1);
        // assertTrue(oa.isPresent());
        // Answer a = oa.get();
        // assertEquals(2, a.getQuestion().getId());

        // List<Answer> answerList = q.getAnswerList();

        // assertEquals(1, answerList.size());
        // assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());

	}

}
