package orderMenuView;

import service.CafeArrayList;
import service.CafeMenuIO;
import service.CreateMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderView extends CafeMenuIO {
    Scanner sc = new Scanner(System.in);
    CreateMenu cremenu = new CreateMenu();


    // 메뉴 주문 첫 화면
    public int orderMainMenu() {
        int choice = -1;

        while (choice == -1) {
            try {
                System.out.println("  < 메뉴 >\n");
                cremenu.menuView();
                System.out.println("1. 음료 선택");
                System.out.println("2. 로그아웃");
                System.out.println("0. 종료");
                System.out.print("선택 : ");
                choice = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException | NullPointerException e) {
                sc.nextLine();
                e.printStackTrace();
                System.out.println("잘못 누르셨습니다.");
                sc.nextLine();
            }
        }
        return choice;
    }
    public int gaustOrderMainMenu() {
        int choice = -1;

        while (choice == -1) {
            try {
                System.out.println("  < 메뉴 >\n");
                cremenu.menuView();
                System.out.print("선택 : ");
                choice = sc.nextInt();
                sc.nextLine();
                search(choice);

            } catch (InputMismatchException | NullPointerException e) {
                sc.nextLine();
                e.printStackTrace();
                System.out.println("잘못 누르셨습니다.");
                sc.nextLine();
            }
        }
        return choice;
    }

    // 음료 선택
    public int choiceTea() {
        int choice = -1;
        while (choice == -1) {
            try {
                System.out.println("메뉴번호를 선택해주세요.");
                System.out.print("선택 : ");
                choice = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                System.out.println("메뉴번호를 선택해주세요.");

            }
        }
        return choice;
    }

    // 수량 선택
    public int choiceCount() {
        int quantity = -1;

        while ( quantity == -1) {
            try {

                System.out.println("수량을 입력해주세요.");
                System.out.print("선택 : ");
                quantity = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                System.out.println("숫자를 입력해주세요.");
            }
        }
        return quantity;
    }

    // 추가주문
    public int additionalOrders() {
        int additional = -1;

        while (additional == -1) {
            try {
                System.out.println("추가주문 하시겠습니까?");
                System.out.println("1. 추가주문");
                System.out.println("2. 결제");
                System.out.println("0. 종료");
                System.out.print("선택 : ");
                additional = sc.nextInt();
                sc.nextLine();

                if (additional==1){
                    additional = 3;
                }else if (additional == 2) {
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                System.out.println("메뉴번호를 선택해주세요.");
            }
        }
        return additional;
    }

    public int search(int num) {
        // 메뉴 조회
        boolean search_menu = false;
        String menuName = null;
        int price = 0;
        while (price == 0) {
            for (int i = 0; i < CafeArrayList.getMenuList().size(); i++) {
                if (num == CafeArrayList.getMenuList().get(i).getNo()) {
                    System.out.println(" 주문하신 음료 : " + CafeArrayList.getMenuList().get(i).getMenu() + " >");
                    price = CafeArrayList.getMenuList().get(i).getPrice();
                    search_menu = true;

                }
            }
            if (search_menu == false) {
                System.out.println("해당 주문번호를 찾을 수 없습니다.\n");
            }
        }
        return price;
    }
    // 결제방법 선택
    public int payment() {
        int choice = -1;

        while (choice == -1) {
            try {
                //Todo 구매금액 및 호원은 리워드 포인트 출력
                System.out.println("1. 카드");
                System.out.println("2. 현금");
                System.out.print("선택 : ");
                choice = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                System.out.println("메뉴번호를 선택해주세요.");
            }
        }
        return choice;
    }

    // 현금 결제
    public int cash() {
        int choice = -1;

        while (choice == -1) {
            try {
                System.out.println("리워드 포인트를 사용하시겠습니까?");
                System.out.println("1. 포인트 사용");
                System.out.println("2. 현금결제");
                System.out.print("선택 : ");
                choice = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                System.out.println("메뉴번호를 선택해주세요.");
            }
        }
        return choice;
    }

    //리워드 포인트 사용
    public int useRewardsPoint() {
        int choice = -1;

        while (choice == -1) {
            try {

                System.out.println("사용하실 포인트를 입력해주세요.");
                System.out.print("포인트 : ");
                choice = sc.nextInt();
                sc.nextLine();
                //todo 포인트 반영

            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
            }
        }
        return 0;
    }
    public int searchPoint() {
        // 포인트 조회
        String id = sc.nextLine();
        boolean search_pass = true;
        int rewardPoint = 0;

        for (int i = 0; i < CafeArrayList.getMemberList().size(); i++) {
            if (id.equals(CafeArrayList.getMemberList().get(i).getId())) {
                System.out.println("\n < " + CafeArrayList.getMemberList().get(i).getId() + " >");
                System.out.println("이름 : " + CafeArrayList.getMemberList().get(i).getName());
                System.out.println("생년월일 : " + CafeArrayList.getMemberList().get(i).getBirthday());
                System.out.println("전화번호 : " + CafeArrayList.getMemberList().get(i).getPhone());
                System.out.println("포인트 : " + CafeArrayList.getMemberList().get(i).getRewardsPoint());
                rewardPoint = CafeArrayList.getMemberList().get(i).getRewardsPoint();
                search_pass = true;

            }
        }
        if (search_pass == false) {
            System.out.println("ID를 찾을 수 없습니다.\n");
        }
        return rewardPoint;
    }
    // 현금 투입 및 거스름돈 반환
    public int changeCash (int amount, int quantity) {
        int choice = -1;

        while (choice == -1) {
            try {
                System.out.println("투입구로 현금을 넣어주세요.");
                System.out.print("금액 : ");
                choice = sc.nextInt();
                sc.nextLine();
                System.out.println("잔액은 " + ((amount*quantity)-choice) + "입니다.");
                System.out.println("남은 포인트는 " + "입니다.");
                System.out.println("결제가 완료되었습니다.");
                System.out.println("이용해 주셔서 감사합니다.\n");

            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                System.out.println("금액을 투입해주세요.");
            }
        }
        return choice;
    }

    // 카드 결제
    public void card (int amount, int quantity) {

        System.out.println("  <신용카드 결제>");
        System.out.println("주문하신 음료 : " + (amount*quantity) + "원을 결제합니다.");
        System.out.println("결제 중입니다.");
        //todo 딜레이 5초
        System.out.println("결제가 완료 되었습니다.\n");

    }
}