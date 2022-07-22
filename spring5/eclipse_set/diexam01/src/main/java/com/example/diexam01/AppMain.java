package com.example.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String[] args) {
//		Engine engine=new Engine();
//		Car car=new Car();
//		car.setEngine(engine);
//		car.run();
		ApplicationContext ac=
				new AnnotationConfigApplicationContext(
						ApplicationConfig2.class);
		Car car=(Car)ac.getBean("car");
		car.run();
	}

}
