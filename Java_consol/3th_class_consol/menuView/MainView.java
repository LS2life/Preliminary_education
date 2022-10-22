package menuView;

//import service.CafeRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

import service.CreateMenu;
import service.Login;

public class MainView {
    public Scanner sc = new Scanner(System.in);
//    private CafeRepository cafeRepo = new CafeRepository();
     public Login login = new Login();
     public CreateMenu cremenu = new CreateMenu();
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

    //super user menu
    //회원 삭제, 메뉴관리, 서브관리자 지정, super user ID 변경
    public int administerMenu() {
        try {

        System.out.println("\n !-- super user menu --!  ");
        System.out.println("  < Sub Manager List >");
        login.subManagerList();
        System.out.println("1. 회원정보 관리"); //서브 메니저 있으면 목록. 없으면 없습니다.
        System.out.println("2. 서비스메뉴 관리");
        System.out.println("0. 메인메뉴로 돌아가기");
        System.out.print("선택 : ");
        choice = sc.nextInt();
        sc.nextLine();

        }catch (InputMismatchException e) {
            System.out.println("메뉴번호를 선택해주세요.");
        }
        return choice;
    }

    //회원정보 최고 관리자만 접근
    public int infoMenu() {
        //회원 중 서브메니저 상단노출
        try {
            System.out.println("\n회원정보 관리>");
            System.out.println("  < Sub Manager List >");
            login.subManagerList();
            String modifyMemberInfo = login.search();
            System.out.println("\n < " + modifyMemberInfo + " >");
            System.out.println("1. 회원등급 관리");
            System.out.println("2. 회원정보 삭제");
            System.out.println("0. 종료");
            System.out.print("선택 : ");
//        int infoNum = sc.nextInt();
//        return infoNum;
            choice = sc.nextInt();
            sc.nextLine();
        }catch (InputMismatchException e ) {
            System.out.println("메뉴번호를 선택해주세요.");
            sc.nextLine();
        }
        return choice;

    }

       // 회원 등급 변경
    public int managerChange () {
        try {

        System.out.println("\n< Manager grade Change >");
        login.subManagerList();
        choice = login.Update();
        }catch (InputMismatchException e) {
            System.out.println("ID를 다시 확인해주세요.");
        }
        return 1;
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
        System.out.println("서비스메뉴 관리");
        cremenu.menuView();
        System.out.println("1. 메뉴 추가");
        System.out.println("2. 메뉴 변경");
        System.out.println("3. 메뉴 삭제");
        System.out.println("0. 메인화면");
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
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

