package ui;

import service.CafeAppService;
import java.util.Scanner;

public class AdminMenu {
    public CafeAppService cas = new CafeAppService();
    private Scanner sc = new Scanner(System.in);
    int choice = -1;
    //super user menu
    //회원 삭제, 메뉴관리, 서브관리자 지정, super user ID 변경
    public int administerMenu() {
        System.out.println("\n !-- super user menu --!  ");
        System.out.println("  < Sub Manager List >");
        cas.searchAdmin(true);
        System.out.println("1. 회원정보 관리"); //서브 메니저 있으면 목록. 없으면 없습니다.
        System.out.println("2. 서비스메뉴 관리");
        System.out.println("0. 메인메뉴로 돌아가기");
        System.out.print("선택 : ");
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
}
