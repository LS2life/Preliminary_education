package io.github.ls2life.app;

import java.io.IOException;

import io.github.ls2life.controller.CafeAppController;

/*
    설계원칙  1. 가능한 교과서 내에서 다루는 내용으로 만든다.
            2. 교과 내에 쓰인 코드를 한번 씩 사용 할 수 있도록 한다.
            3. 인코딩은 UTF-8, 모듈은 1.8로 한다.
            4. 사용 용도에 밀접하게 접근한다.
            5. 코드 시인성을 높인다.
            6. 역량의 범위 내에서 가능한 코드를 짧게 한다.
            7. 깃허브를 활용 할 수 있도록 한다.
            8. 객체지향의 장점을 살릴 수 있도록 한다.
            9. 지금 내 수준에서 실험적인 코드를 작성한다.
           10. 지금은 프로젝트를 빠르게 잘짜는 것보다 잘 이해하고 코드를 짜는게 더 중요하다.
           11. 생각한다.

    프로젝트 목적
        1. 실력 평균 향상.
        2. 코드 비교
        3. 프로젝트 결과물 외의 것에 집중할 수 있도록 한다.
        4.
 */

public class CafeManager {
    public static void main(String[] args) throws IOException {
        CafeAppController algo = new CafeAppController();
        algo.runApp();
    }
}
