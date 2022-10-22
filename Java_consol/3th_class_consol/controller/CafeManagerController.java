package controller;

import menuView.MainView;
import orderMenuView.OrderView;
import service.*;

import java.io.IOException;

public class CafeManagerController {
    private MainView crp = new MainView();
    private OrderView cmb = new OrderView();
    private Join join = new Join();
    private Login anlogin = new Login();
    private CafeManagerIO cafeio = new CafeManagerIO();
    private CafeMenuIO cafeMenuIo = new CafeMenuIO();
    private CreateMenu cremenu = new CreateMenu();

    public void runApp() throws IOException {

        boolean exit = true;
        cafeio.readReader();
        cafeMenuIo.readReader();

        while (exit) {
            int choice1 = 0;
            int choice2 = 0;
            int choice3 = 0;

            choice1 = crp.firstViewManu();
            if (choice1 == 0) {
                exit = false;
            }

            switch (choice1) {
                case 0:
                    break;

                case 1: //로그인
                    choice1 = anlogin.login();
                    break;

                case 2: //회원가입
                    choice1 = join.regist();
                    break;

                case 3: // 비회원 주문
                    int num = 0;
                    int num2 = 0;
                    int pnum = 0;

                    while (choice1==3) {
                        num = cmb.gaustOrderMainMenu();
                        num2 = cmb.choiceCount();
                        choice1 = cmb.additionalOrders();
                    }
                    if (choice1 != 0) {
                        choice3 = cmb.payment();

                    }else if (choice1 ==0) {
                        exit = false;
                    }

                    switch (choice3) {
                        case 0:
                            break;
                        case 1:
                            pnum = cmb.search(num);
                            cmb.card(num2, pnum);
                            exit = false;
                            break;
                        case 2:
                            choice3 = cmb.cash();
                            if (choice3 == 1) {
                                cmb.useRewardsPoint();
                                cmb.changeCash(num2,pnum);

                            } else if (choice3 == 2) {

                            }
                            //TODO 비회원 주문 Part.손재현
                            break;
                    }

                    break;
            }
            // super user login
            switch (choice1) {
                case 0:
                    break;

                case 1:  // 회원정보관리
                    choice1 = crp.infoMenu();

                    // 회원정보관리 메뉴
                    switch (choice1) {
                        case 0: // 이전단계
                            break;

                        case 1:// 회원등급 관리
                            choice2 = crp.managerChange();

                            break;

                        case 2: // 회원정보 삭제
                            anlogin.Delete();
                            break;
                    }
                    break;

                case 2: // 메뉴수정
                    choice2 = crp.teaAndDessertMenu();

                    // TODO 메뉴 수정 추가.
                    // 메뉴 관리
                    switch (choice2) {
                        case 0:
                            break;

                        case 1:  //메뉴수정1 생성
                            cremenu.createTeaBack();

                            break;
                        case 2: // 메뉴수정2 변경
                            cremenu.changeMenu();

                            break;
                        case 3: // 메뉴수정2 삭제
                            cremenu.Delete();

                            break;

                    }
                    break;

                case 3: // 메뉴 주문
                    int num = 0;
                    int num2 = 0;
                    int pnum = 0;

                    while (choice1==3) {
                        num = cmb.gaustOrderMainMenu();
                        num2 = cmb.choiceCount();
                        choice1 = cmb.additionalOrders();
                    }

                    if (choice1 != 0) {
                        choice3 = cmb.payment();

                    }else if (choice1 ==0) {
                        exit = false;
                    }

                    switch (choice3) {
                        case 0:
                            break;
                        case 1:
                            pnum = cmb.search(num);
                            cmb.card(num2, pnum);
                            break;
                        case 2:
                            choice3 = cmb.cash();
                            if (choice3 == 1) {
                                cmb.useRewardsPoint();
                                cmb.changeCash(num2,pnum);

                            } else if (choice3 == 2) {

                            }
                            //TODO 비회원 주문 Part.손재현
                            break;
                    }

                    break;
            }
        }
        System.out.println("이용해주셔서 감사합니다.");
    }
}
