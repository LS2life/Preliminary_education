package menuView3;

import java.util.List;
import java.util.Scanner;

//수정
public class Orderbar extends Menu {
	Scanner sc = new Scanner(System.in);
	int key; // 길
	int no; // 메뉴 번호
	int amount; // 수량
	int cash; // 현금
	int calculation; // 계산

	double Point = 0;

	Point p = new Point();

	public void choice() {// 선택

		do {
			System.out.println("1.음료 2.디저트");
			key = sc.nextInt();
			if (key == 1) {
				coffee();
			}
			if (key == 2) {
				Dessert();
			}
			if (key == 0 || key > 2) {
				System.out.println("다시 선택");
			}
		} while (key == 0 || key > 2);
	}

	public void coffee() {

		System.out.println("음료");
		// 선택
		do {
			System.out.print("메뉴 선택:");
			no = sc.nextInt();

			if (no == list.size() || no > list.size()) {
				System.out.println("없는메뉴 입니다. 다시선택해주세요");

			}
		} while (no == list.size() || no > list.size());
		
		System.out.print("수량 선택:");
		amount = sc.nextInt();
		
		System.out.println("1.계산 2.추가선택");
		calculation = sc.nextInt();
		
		if (calculation == 2) { // 돌아가기
			choice();
			calculation += list.get(no).getPrice() * list.get(amount).getAmount();
		}
		// 게산
		System.out.println("1.카드 2.현금");
		cash = sc.nextInt();
		if (cash == 1) {
			System.out.println("계산되었습니다");
		}
		if (cash == 2) {
			System.out.print("금액 : ");
			cash = sc.nextInt();
			System.out.println(cash - calculation);
		}
		System.exit(0);
	}

	public void Dessert() {
		// 선택
		System.out.println("디저트");
		do {
			System.out.print("메뉴 선택:");
			no = sc.nextInt();
			if (no == list.size() || no > list.size()) {
				System.out.println("없는메뉴 입니다. 다시선택해주세요");
			}
		} while (no == list.size() || no > list.size());
		
		System.out.print("수량 선택:");
		amount = sc.nextInt();
		
		System.out.println("1.계산 2.추가선택");
		calculation = sc.nextInt();
		if (calculation == 2) { // 돌아가기
			choice();
			calculation += list.get(no).getPrice() * list.get(amount).getAmount();
		}
		System.out.println("총 금액:" + calculation);
		// 게산
		System.out.println("1.카드 2.현금");
		cash = sc.nextInt();
		if (cash == 1) {
			System.out.println("계산되었습니다");
		}
		if (cash == 2) {
			System.out.print("금액 : ");
			cash = sc.nextInt();
			System.out.println(cash - calculation);
		}
		Point = p.Point(calculation);
		System.exit(0);
	}
}