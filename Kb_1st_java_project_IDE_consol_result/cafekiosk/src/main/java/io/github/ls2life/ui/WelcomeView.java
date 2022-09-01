package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeView {
    public Scanner sc = new Scanner(System.in);
    int choice = -1;

    public int welcomeView() {

        while (choice != 0) {
            System.out.println("카페602에 오신것을 환영합니다.");
            System.out.println("카페 회원이시면 로그인해주세요.");
            System.out.println("회원가입을 하시면 포인트 리워드 및 이벤트 혜택을 받으실 수 있습다.");
            System.out.println("1. 회원 로그인");       // 회원은 주간 월간 커피 소비량, 소비 킬로리, 리워드 포인트
            System.out.println("2. 회원 가입");        // 회원은 주간 월간 커피 소비량, 소비 킬로리, 리워드 포인트
            System.out.println("3. 비회원 주문");       // 비회원은 바로 매뉴
            System.out.println("0. 종료");

            try {
                System.out.print("메뉴 선택 : ");
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException | NullPointerException e) {
                sc.nextLine();
                System.out.println("메뉴 번호를 선택해 주세요.");
                System.out.println("--------------------");
                choice = -1;

            }
        }
        return choice;
    }
}
