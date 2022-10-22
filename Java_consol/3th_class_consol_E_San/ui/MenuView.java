package ui;


import java.util.InputMismatchException;
import java.util.Scanner;

import dto.CafeAppDTO;
import service.CafeAppService;

public class MenuView {
    public Scanner sc = new Scanner(System.in);
     public CafeAppService cav = new CafeAppService();
     public CafeAppDTO cfadto = new CafeAppDTO();
    int choice = -1;

    // Main menu
    public int firstViewManu() {
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
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("메뉴 번호를 선택해 주세요.");
                System.out.println("--------------------");
                choice = -1;
            } //TODO 문자입력시 반환, 정수열 초과시 반환.

            if (0 >= choice || choice <= 3) {
                return choice;
            }else {
                System.out.println("메뉴번호를 선택해주세요.");
                System.out.println("---------------------");
                choice = -1;
            }
            return choice;
        }
        return choice;
    }

    // 1. 로그인
    public int login() {
        System.out.println("<회원 로그인>");

        while (choice == 1) {
            try {
                System.out.print("ID : ");
                String id = sc.nextLine();
                System.out.print("Password : ");
                String password = sc.nextLine();
//                choice = cafeRepo.loginMember(id, password);

            } catch (InputMismatchException | NullPointerException e ) {
                try {
                    System.out.println("ID정보가 확인되지 않습니다.");
                    System.out.println("메인으로 돌아가시려면 0번을 입력해주세요.");
                    System.out.print("0. 메인화면 : ");
                    choice = sc.nextInt();
                    sc.nextLine();

                } catch (InputMismatchException | NullPointerException r) {
                    sc.nextLine();
                    System.out.println("잘못 입력하셨습니다.");
                }
            }
            if (choice == 0 ) {
                return choice;
            }else {
                System.out.println("잘못 입력하셨습니다.");
                choice = 1;
                break;
            }
        }
        return choice;
    }
    // 회원 가입
    public int joinMemberMenu() {
        String id = null;
        String password = null;
        String name = null;
        String birthday = null;
        long phone = 0;

        while (choice == 2) {
            try {
                System.out.println("<회원가입 메뉴입니다.>");
                System.out.println("원하시는 ID를 입력해주세요.");
                System.out.print("ID : ");
                //TODO 사용중인 id 입력시 사용불가 반환
                id = sc.nextLine();

                System.out.println("비밀번호를 입력해주세요.");
                System.out.print("password : ");
                password = sc.nextLine();

                System.out.println("이름을 입력해주세요.");
                System.out.print("성명 : ");
                name = sc.nextLine();

            } catch (InputMismatchException | NullPointerException e) {
                sc.nextLine();
                System.out.println("잘못 입력하셨습니다.");
            }

            while (choice == 2) {
                int bLangth = 0;
                long pLangth = 0;

                try {
                    System.out.println("주민등록번호 앞자리의 생일 6자리를 입력해주세요.");
                    System.out.print("생년월일 : ");
                    birthday = sc.nextLine();
                    sc.nextLine();

                    System.out.println("핸드폰 번호를 입력해 주세요.");
                    System.out.print("핸드폰 : ");
                    phone = sc.nextLong();
                    sc.nextLine();
                    pLangth = (long) (Math.log10(phone) + 1);
                    System.out.println(pLangth);

                    if (bLangth == 6 && pLangth == 11) {
                        choice = 3;
                    } else {
                        choice = 2;
                    }

                } catch (InputMismatchException e) {
                    try {
                        sc.nextLine();
                        System.out.println("생년월일을 숫자로 입력해주세요.");
                        System.out.println("메인으로 돌아가시려면 0번을 입력해주세요.");
                        System.out.print("0. 메인화면 : ");
                        choice = sc.nextInt();
                        sc.nextLine();
                        if(0==choice){
                            return choice;
                        }else {
                            choice = 2;
                        }

                    } catch (InputMismatchException r ) {
                        sc.nextLine();
                        System.out.println("잘못 입력하셨습니다.");
                    }
                }
            }
            return choice;
        }
        cav.create(id, password, name, birthday, phone);
        return choice;
    }


    //super user menu
    //회원 삭제, 메뉴관리, 서브관리자 지정, super user ID 변경
    public int administerMenu() {
        System.out.println("\n !-- super user menu --!  ");
        System.out.println("  < Sub Manager List >");
//        .();
        System.out.println("1. 회원정보 관리"); //서브 메니저 있으면 목록. 없으면 없습니다.
        System.out.println("2. 서비스메뉴 관리");
        System.out.println("0. 메인메뉴로 돌아가기");
        System.out.print("선택 : ");
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    //회원정보 최고 관리자만 접근
    public int infoMenu() {
        //회원 중 서브메니저 상단노출
        System.out.println("\n회원정보 관리>");
        System.out.println("  < Sub Manager List >");
        cav.searchAdmin(true);
//        String modifyMemberInfo = cav.search(i);
//        System.out.println("\n < " + modifyMemberInfo + " >");
        System.out.println("1. 회원등급 관리");
        System.out.println("2. 리워드 포인트 변경");
        System.out.println("3. 회원특기사항 메모");
        System.out.println("4. 회원정보 삭제");
        System.out.println("0. 이전단계로 돌아가기");
        System.out.print("선택 : ");
//        int infoNum = sc.nextInt();
//        return infoNum;
        choice = sc.nextInt();
        return choice;
    }

       // 회원 등급 변경
    public void managerChange () {
        System.out.println("\n< Manager grade Change >");
        cav.searchAdmin(true);
//        cav.Update();
    }

    // 리워드 포인트 변경`
    public void reWards () {

    }
    // 회원 특기사항 메모`
    public void memberMemo () {

    }
    // 회원 정보 삭제
    public void deleteMember () {

    }

    //Db검색
    public String searchId() {
        System.out.print("ID 검색 : ");
        String subManSerch = sc.nextLine();
        // TODO 서브매니저 db검색 및 지정 메뉴관리
        return subManSerch;
    }

    //서비스 메뉴
    public int teaAndDessertMenu() {
        // 서비스메뉴 1. 음료
        //TODO ArryList 메뉴수정가능


        return 0;
    }


    //general Member Menu
    public int generalMemberMenu() {
        // 주간월간 소비량,  , 리워드포인트 노출

        System.out.println("어서오세요. " + " 0 0 0 " +" 회원님 주문하시겠어요?");
        System.out.println("1. 음료 "); // 메뉴인터페이스 삽입
        System.out.print("2. side 메뉴"); // 메뉴인터페이스 삽입
        System.out.println("주문 : ");
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    //general Member Menu
    public int guestMenu() {
        System.out.println("어서오세요 고객님 주문하시겠어요?");
        System.out.println("1. 음료 "); // 메뉴인터페이스 삽입
        System.out.println("2. side 메뉴"); // 메뉴인터페이스 삽입
        System.out.println("주문 :"); // 메뉴인터페이스 삽입
//        System.out.print("주문 :"); // 메뉴인터페이스 삽입
//        int guestNum = sc.nextInt();
//        return guestNum;
        choice = sc.nextInt();
        return choice;
    }
}

