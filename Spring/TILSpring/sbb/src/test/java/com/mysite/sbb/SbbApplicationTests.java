package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

//Junitg 기반의 스프링부트 테스트
@SpringBootTest
class SbbApplicationTests {

	@Autowired
	// 스프링 DI 기능으로 questionRepository 객체를 자동 생성
	// * DI : 스프링이 객체를 대신 생성해서 주입
	// ★ 실 코드 작성시에는 Autowired은 순환참조 문제로 지양, 생성자로 생성
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;
	
	// @Transactional // 메서드가 종료될 때 까지 DB 세션이 유지
		// 데이터 삽입시에는 꺼야함
	@Test
	// JUnit으로 실행 시 해당 메소드가 실행될 수 있게끔 하는 어노테이션
	// JUnit : 테스트코드 작성하고 실행하기 위해 사용하는 테스트 프레임워크
	void testJPA() {
	// 1) 질문 데이터 생성하기	
		// Question q1 = new Question();
		// q1.setSubject("질문 1 제목");
		// q1.setContent("질문 1 내용");
		// q1.setCreateDate(LocalDateTime.now());
		// this.questionRepository.save(q1); // 첫번째 질문 저장

		// Question q2 = new Question();
		// q2.setSubject("질문 2 제목");
		// q2.setContent("질문 2 내용");
		// q2.setCreateDate(LocalDateTime.now());
		// this.questionRepository.save(q2); // 두번째 질문 저장
		
	// 2) 데이터 조회하기
		// 2.1) 전부 활용해 데이터베이스 조회 :: findAll
		// List<Question> all = this.questionRepository.findAll();
		// assertEquals(2, all.size());
		// 	// assertEquals : 기대값과 실제값이 동일한지 조사해 같지 않으면 테스트 실패
		// Question q = all.get(0);
		// 	// all.get(index) : index의 question을 하나씩 가지고 옮
		// assertEquals("질문 1 제목", q.getSubject());
		
		// 2.2) id 값으로 데이터 조회 :: findById
		// Optional<Question> oq = this.questionRepository.findById(1);
		// 	findById의 리턴타입은 Optional임에 주의
		// if(oq.isPresent()){
		// 	null 처리의 유연성을 위해 isPresent로 null 확인 후 get으로 value 얻음
		// 	Question q = oq.get();
		// 	assertEquals("질문 1 제목", q.getSubject());
		// }

		// 2.3) subject 값으로 데이터 조회 :: findBySubject
		// findBySubject 사용을 위해 QuestionRepository 인터페이스에 메소드 선언
		// Question q = this.questionRepository.findBySubject("질문 2 제목");
		// assertEquals(8, q.getId());

		// 2.4) subject와 content 값 둘다 데이터 조회 :: findBySubjectAndContent
		// Question q = this.questionRepository.findBySubjectAndContent(
		// 	"질문 2 제목", "질문 2 내용");
		// assertEquals(8, q.getId());

		// 2.5) subject에 특정 문자열이 포함되어 있는 데이터 조회 :: findBySubjectLike
		// List<Question> qList = this.questionRepository.findBySubjectLike("%질문%");
		// %"text" : text로 끝나는 문자열, "text"% : 시작하는 문자열, "%text%" : 포함하는 문자열
		// Question q = qList.get(0);
		// assertEquals("질문 1 제목", q.getSubject());

	// 3) 데이터 수정하기 : assertTrue로 검증 -> setsubject로 수정 -> save로 저장
		// Optional<Question> oq = this.questionRepository.findById(1);
		// assertTrue(oq.isPresent()); // id 값이 있는지 test
		// Question q = oq.get();
		// q.setSubject("질문 1 제목");
		// this.questionRepository.save(q); // 변경된 데이터 저장은 save 메소드 
		
	// 4) 데이터 삭제하기 : delete 활용
		// assertEquals(8, this.questionRepository.count());
		// count() : questionRepository에 총 몇 건의 데이터가 있는지 return
		// Optional<Question> oq = this.questionRepository.findById(8);
		// assertTrue(oq.isPresent());
		// Question q = oq.get();
		// this.questionRepository.delete(q);

	// 5) 답변 데이터 생성 및 저장하기
		// Optional<Question> oq = this.questionRepository.findById(1);
		// assertTrue(oq.isPresent());
		// Question q = oq.get();

		// Answer a1 = new Answer();
		// a1.setContent("질문 1 답변");
		// a1.setQuestion(q); // 질문의 답변에 대한 Question 객체가 요구됌
		// a1.setCreateDate(LocalDateTime.now());
		// this.answerRepository.save(a1);

		// oq = this.questionRepository.findById(2);
		// assertTrue(oq.isPresent());
		// q = oq.get();

		// Answer a2 = new Answer();
		// a2.setContent("질문 1 답변");
		// a2.setQuestion(q); // 질문의 답변에 대한 Question 객체가 요구됌
		// a2.setCreateDate(LocalDateTime.now());
		// this.answerRepository.save(a2);

	// 5) 답변 데이터 조회하기
		// Optional<Answer> oa = this.answerRepository.findById(1);
		// assertTrue(oa.isPresent());
		// Answer a = oa.get();
		// assertEquals(1, a.getQuestion().getId());
		

	// 6) 답변에 연결된 질문 찾기, 질문에 달린 답변 찾기
		// 	a.getQuestion(); // 질문에 연결된 답변 찾기

		// Optional<Question> oq = this.questionRepository.findById(9);
		// assertTrue(oq.isPresent());
		// Question q = oq.get();

		// List<Answer> answerList = q.getAnswerList();
		// assertEquals(1, answerList.size());
		// assertEquals("동탄 신도시입니다.", answerList.get(0).getContent());
	}
}
