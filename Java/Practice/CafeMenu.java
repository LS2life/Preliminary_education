package chapter07;

import java.util.Scanner;


class Info {
    String iceA = "아이스 아메리카노";   //중요 정보없음
    String hotA = "따뜻한 아메리카노";
    String moca = "까페 모카";
    String cafu = "카푸치노";
    String green = "그린티";
    String hotCoco = "따뜻한 코코아";
    String hotMil = "따뜻한 우유";
    String choice = "를 선택하셨습니다.";
    String oder = " 잔을 주문하셨습니다.";


    public void num1() {             //다방 메뉴
        int count = 1;

        System.out.println("어서오세요. 인공지능 다방 602호 입니다.");
        System.out.println("주문하시겠어요?");
        System.out.println("      <메뉴>");
        System.out.println(count + ". " + iceA + "	3.0 ");
        System.out.println(++count + ". " + hotA + "	3.5 ");
        System.out.println(++count + ". " + moca + "	4.5 ");
        System.out.println(++count + ". " + cafu + "	4.5 ");
        System.out.println(++count + ". " + green + "		5.0 ");
        System.out.println(++count + ". " + hotCoco + "	5.0 ");
        System.out.println(++count + ". " + hotMil + "	3.5");
    }

    public int num2() {          //음료 선택
        int menu = 0;

        System.out.print("주문번호 : ");

        Scanner scen = new Scanner(System.in);
        menu = scen.nextInt();

        switch (menu) {
            case 1:
                System.out.println(iceA + choice);
                break;
            case 2:
                System.out.println(hotA + choice);
                break;
            case 3:
                System.out.println(moca + choice);
                break;
            case 4:
                System.out.println(cafu + choice);
                break;
            case 5:
                System.out.println(green + choice);
                break;
            case 6:
                System.out.println(hotCoco + choice);
                break;
            case 7:
                System.out.println(hotMil + choice);
                break;
            default:
                System.out.println("오늘은 스페셜 메뉴가 없내요.");
                System.out.println("화면의 메뉴를 선택해 주세요.");
                break;   //메뉴 외 번호 입력시 반복기능 추가 필요.
        }

        return menu;
    }

    public int count(int serv) {     //음료 수량
        int ea = 0;

        System.out.print("수량을 입력해주세요 : ");
        Scanner scen = new Scanner(System.in);
        ea = scen.nextInt();

        switch (serv) {
            case 1:
                System.out.println(iceA + "  " + ea + oder);
                break;
            case 2:
                System.out.println(hotA + "  " + ea + oder);
                break;
            case 3:
                System.out.println(moca + "  " + ea + oder);
                break;
            case 4:
                System.out.println(cafu + "  " + ea + oder);
                break;
            case 5:
                System.out.println(green + "  " + ea + oder);
                break;
            case 6:
                System.out.println(hotCoco + "  " + ea + oder);
                break;
            case 7:
                System.out.println(hotMil + "  " + ea + oder);
                break;
            default:
                break;
        }

        return ea;
    }
}

class Cafe {                                //실행 메인
    public static void main(String[] args) {
        int num3 = 0;
        int num4 = 0;
        int market = 0;
        int log = 0;

        Info serv = new Info();
        Amount coun = new Amount();

        serv.num1();                //메뉴 출력
        num3 = serv.num2();            //메뉴 선택 num3 리턴
        num4 = serv.count(num3);    //선택음료 수량 num4 리턴
        coun.pay(num3, num4);        //가격
        market = coun.cardCash();    //결제수단 입력 market 리턴
        log = coun.hold(market);            //결제수단 입력에 따라 출력


    }
}
