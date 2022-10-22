package ui;

import java.util.Scanner;
import java.util.InputMismatchException;
import service.CafeAppService;

public class JoinLoginPassMenu extends CafeAppService{
    public Scanner sc = new Scanner(System.in);
    public CafeAppService cas = new CafeAppService();
    int choice  = -1;

    public int joinMenu() {
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
                cas.sameId(id);

                System.out.println("비밀번호를 입력해주세요.");
                System.out.print("password : ");
                password = sc.nextLine();

                System.out.println("이름을 입력해주세요.");
                System.out.print("성명 : ");
                name = sc.nextLine();

            } catch (InputMismatchException | NullPointerException e) {
                sc.nextLine();
                System.out.println("잘못 입력하셨습니다.\n");
            }

            while (choice == 2) {
                int bLangth = 0;
                long pLangth = 0;

                try {
                    System.out.println("주민등록번호 앞자리의 생일 6자리를 입력해주세요.");
                    System.out.print("생년월일 : ");
                    birthday = sc.nextLine();
                    sc.nextLine();

                    System.out.println("휴대전화 번호를 입력해 주세요.");
                    System.out.print("전화번호 : ");
                    phone = sc.nextLong();
                    sc.nextLine();
                    pLangth = (long) (Math.log10(phone) + 1);

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
                        if (0 == choice) {
                            choice = -1;
                        }else {
                            choice = 2;
                        }

                    } catch (InputMismatchException r) {
                        sc.nextLine();
                        System.out.println("잘못 입력하셨습니다.\n");
                    }
                }
            }
        }
        cas.create(id, password, name, birthday, phone);
        System.out.println("회원가입이 완료 되었습니다.");
        System.out.println("가입하신 ID로 로그인해주세요.\n");
        return choice;
    }

    public int loginMenu() {
        while (choice == 1) {
        System.out.println("  < 회원 로그인 >");
            try {
                System.out.print("ID : ");
                String id = sc.nextLine();
                System.out.println("Password : ");
                String password = sc.nextLine();
                choice = cas.login(id, password);

            }catch (InputMismatchException | NullPointerException e) {
                e.printStackTrace();
                System.out.println("잘못 입력하셨습니다.");
            }
        }
        return choice;
    }
}