package service;

import dto.CafeMenuDTO;

import java.io.FileWriter;
import java.util.Objects;
import java.util.Scanner;

public class CreateMenu extends CafeMenuIO {

	Scanner sc = new Scanner(System.in);
	CafeArrayList cal = new CafeArrayList();
	int ididx = 0;

	// 메뉴 출력
	public void menuView() {
		// 메뉴리스트 출력
		if (cal.menuList.size() != 0) {

		} else {
			for (int i = 0; i < cal.menuList.size(); i++) {
				if (Objects.equals(true, cal.menuList.get(i).getNo())) {
					System.out.println(" [ " + CafeArrayList.menuList.get(i).getNo() + ". " +
							cal.menuList.get(i).getMenu() + "(" +
							cal.menuList.get(i).getKcal() + ")" + "			" +
							cal.menuList.get(i).getPrice() + " ]");

				} else {
					System.out.println("구성된 매뉴가 없습니다.");
				}
			}
		}
	}

	// 메뉴 생성
	public int createTeaBack()  {
		CafeMenuDTO cmudto = new CafeMenuDTO();

		String menuName;
		boolean tf = true;

		do {
			System.out.println("\n메뉴판을 재구성합니다.");
			System.out.println("원하시는 메뉴를 입력해 주세요");
			System.out.print("메뉴 : ");
			menuName = sc.nextLine();
			for (int i = 0; i < CafeArrayList.menuList.size(); i++) {
				if (menuName == CafeArrayList.menuList.get(i).getMenu()) {
					tf = false;
					System.out.println("중복된 메뉴가 있습니다.\n");
					break;
				} else {
					tf = true;
				}

			}
		} while (tf == false);
		if (tf == true) {
			cmudto.setMenu(menuName);
		}

		System.out.println("해당 메뉴의 칼로리를 입력해주세요.");
		System.out.print("kcal/100ml : ");
		cmudto.setMenu(sc.nextLine());

		System.out.println("판매금액을 입력해주세요.");
		System.out.print("판매금액 : ");
		cmudto.setKcal(sc.nextInt());
		sc.nextLine();

		// 메뉴등록 완료시
		System.out.println("\n메뉴 생성이 완료 되었습니다.");
		System.out.println("회원정보 관리 화면으로 돌아갑니다.");
		System.out.println("-----------------------\n");

		// 임시 데이터 추가
		CafeArrayList.menuList.add(cmudto);

		// 덮어쓰기
		try (FileWriter menuFileWrite = new FileWriter(menuFile)) {
			// 저장할 정보들
			for (int i = 0; i < menuList.size(); i++) {
				String writeML = menuList.get(i).getNo() + "," + menuList.get(i).getMenu() + ","
						+ menuList.get(i).getKcal() + "," + menuList.get(i).getPrice() + "\n";

				// 파일로 출력
				menuFileWrite.write(writeML);
				menuFileWrite.flush();
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return -1;
	}

	// 메뉴 변경
	public int changeMenu()  {
		CafeMenuDTO cmudto = new CafeMenuDTO();

		String menuName;
		boolean tf = true;

		System.out.println("\n메뉴 구성을 변경합니다.");
		System.out.println("변경하실 메뉴를 입력해 주세요");
		System.out.print("메뉴 : ");
		menuName = sc.nextLine();

		for (int i = 0; i < CafeArrayList.menuList.size(); i++) {
			if (menuName == CafeArrayList.menuList.get(i).getMenu()) {
				cmudto.setMenu(menuName);
			}
		}

		System.out.println("해당 메뉴의 칼로리를 입력해주세요.");
		System.out.print("kcal/100ml : ");
		cmudto.setMenu(sc.nextLine());

		System.out.println("판매금액을 입력해주세요.");
		System.out.print("판매금액 : ");
		cmudto.setKcal(sc.nextInt());
		sc.nextLine();

		// 메뉴등록 완료시
		System.out.println("\n메뉴 변경이 완료 되었습니다.");
		System.out.println("회원정보 관리 화면으로 돌아갑니다.");
		System.out.println("-----------------------\n");

		// 임시 데이터 추가
		CafeArrayList.menuList.add(cmudto);

		// 덮어쓰기
		try (FileWriter menuFileWrite = new FileWriter(menuFile)) {
			// 저장할 정보들
			for (int i = 0; i < menuList.size(); i++) {
				String writeML = menuList.get(i).getNo() + "," + menuList.get(i).getMenu() + ","
						+ menuList.get(i).getKcal() + "," + menuList.get(i).getPrice() + "\n";

				// 파일로 출력
				menuFileWrite.write(writeML);
				menuFileWrite.flush();
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return -1;
	}

	// 삭제
	public void Delete() {
		int deleteMenu;

		menuView();
		System.out.print("메뉴번호를 입력하세요 : ");
		deleteMenu = sc.nextInt();
		sc.nextLine();

		if (deleteMenu == cal.menuList.get(ididx).getNo()) {
			cal.menuList.remove(ididx);

			// 덮어쓰기
			try (FileWriter menuFileWriter = new FileWriter(menuFile)) {
				// 저장할 정보들
				for (int i = 0; i < menuList.size(); i++) {
					String writeML = menuList.get(i).getNo() + "," + menuList.get(i).getMenu() + ","
							+ menuList.get(i).getKcal() + "," + menuList.get(i).getPrice() + "\n";

					// 파일로 출력
					menuFileWriter.write(writeML);
					menuFileWriter.flush();
				}
			} catch (Exception e) {
				e.getMessage();
			}

			System.out.println("삭제 되었습니다.\n");
		}
	}
}
