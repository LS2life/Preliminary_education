package com.example.diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//ctl+shift+o->자동임포트
@Configuration //어노테이션
public class ApplicationConfig {
	//Java 산 커피를 마시다가 개발
	//커피콩-볶음-갈아서->커피
	//인스턴스->조립->프로그램
	//DI-의존성 주입
	@Bean
	public Car car(Engine e) {
		Car c=new Car();
		c.setEngine(e);
		return c;
	}
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
