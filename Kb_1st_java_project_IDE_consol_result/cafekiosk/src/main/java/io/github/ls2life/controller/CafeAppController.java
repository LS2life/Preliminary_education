package io.github.ls2life.controller;

import java.io.IOException;

import io.github.ls2life.service.CafeAppService;
import io.github.ls2life.ui.JoinLoginPassMenu;
import io.github.ls2life.ui.MenuView;
import io.github.ls2life.ui.WelcomeView;

public class CafeAppController {
    private MenuView caferepo = new MenuView();
    private CafeAppService cas = new CafeAppService();
    private WelcomeView wv = new WelcomeView();
    private JoinLoginPassMenu joinLogin = new JoinLoginPassMenu();
    public void runApp() throws IOException {
        int choice = -1;
        cas.cafeAppCNI();

        while (choice != 0) {
            choice = wv.welcomeView();

            switch (choice) {
                case 1: //로그인
                    choice = joinLogin.loginMenu();
                    break;

                case 2: //회원가입
                    choice = joinLogin.joinMenu();
                    break;

                case 3: // 비회원 주문
                    System.out.println("\n < 비회원 주문입니다. > ");
                    caferepo.guestMenu();
                    //TODO 비회원 주문 Part.손재현
                    break;
            }

            // 등급별 로그인
            switch (choice) {
                case 0:
                    break;

                case 1: // super user menu                    // super user login
                    choice = caferepo.administerMenu();
                    break;

                case 2: // sub manager menu                  // 메뉴관리 부착
                    choice = caferepo.teaAndDessertMenu();
                    break;

                case 3: // general Member Menu                 // 메뉴주문 부착
                    choice = caferepo.generalMemberMenu();
                    break;
            }

            // super user login
            switch (choice) {
                case 0:
                    break;

                case 1:  // 회원정보관리
                    choice = caferepo.infoMenu();
                    //  회원정보 검색 후 정보관리메뉴로 이동
                    break;

                case 2: // 메뉴수정
                    choice = caferepo.teaAndDessertMenu();
                    // TODO 메뉴 수정 추가.
                    break;
            }

            // 회원정보관리 메뉴
            switch (choice) {
                case 0: // 이전단계
                    break;

                case 1:// 서브메니저 변경
                    caferepo.managerChange();
                    break;
                case 2: // 회원 특기사항 메모

                    break;
                case 3: // 회원정보 삭제

                    break;
            }


            // 메뉴 관리
            switch (choice) {
                case 0:
                    break;

                case 1:  //메뉴수정1 음료

                    break;
                case 2: // 메뉴수정2 디저트

                    break;

            }
        }
        System.out.println("이용해주셔서 감사합니다.");
    }
}