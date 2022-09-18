package com.practice.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    // Autowired가 있으면 setter method가 없어도 된다.@compo
    @Autowired
    private Engine v8;

    public Car() {
        System.out.println("Car 생성자");
    }

    public void setEngine(Engine e) {
        this.v8 = e;
    }

    public void run() {
        System.out.println("엔진을 사용하여 달림");
        v8.exec();
    } 

    public static void main(String[] args) {
        Engine engine = new Engine();
        Car c = new Car();
        c.setEngine(e);
        c.run;
    }

    
}