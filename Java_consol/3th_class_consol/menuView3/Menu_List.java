package menuView3;

public class Menu_List extends Menu {
	CoffeemenuDTO dto = new CoffeemenuDTO();
	public void menubar() {
		// 1번
		dto.setNo(1);
		dto.setMenu("아메리카노");
		dto.setKcal(5);
		dto.setPrice(1800);
		list.add(dto);
		dto= new CoffeemenuDTO();
		// 2번
		dto.setNo(2);
		dto.setMenu("카라멜마끼야또");
		dto.setKcal(300);
		dto.setPrice(3300);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 3번
		dto.setNo(3);
		dto.setMenu("카페모카");
		dto.setKcal(300);
		dto.setPrice(3500);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 4번
		dto.setNo(4);
		dto.setMenu("자바칩프라푸치노");
		dto.setKcal(340);
		dto.setPrice(4800);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 5번
		dto.setNo(5);
		dto.setMenu("카푸치노");
		dto.setKcal(150);
		dto.setPrice(3300);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 6번
		dto.setNo(6);
		dto.setMenu("헤이즐넛 아메리카노");
		dto.setKcal(70);
		dto.setPrice(2200);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 7번
		dto.setNo(7);
		dto.setMenu("딸기스무디");
		dto.setKcal(180);
		dto.setPrice(6000);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 8번
		dto.setNo(8);
		dto.setMenu("자몽스무디");
		dto.setKcal(200);
		dto.setPrice(6000);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 9번
		dto.setNo(9);
		dto.setMenu("복숭아 아이스티");
		dto.setKcal(70);
		dto.setPrice(2800);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 10번
		dto.setNo(10);
		dto.setMenu("바닐라라떼");
		dto.setKcal(180);
		dto.setPrice(4800);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 11번
		dto.setNo(11);
		dto.setMenu("아포가토");
		dto.setKcal(381);
		dto.setPrice(3800);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 12번
		dto.setNo(12);
		dto.setMenu("에스프레소");
		dto.setKcal(10);
		dto.setPrice(3600);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 13번
		dto.setNo(13);
		dto.setMenu("조각케이크");
		dto.setKcal(775);
		dto.setPrice(6000);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 14번
		dto.setNo(14);
		dto.setMenu("마카롱");
		dto.setKcal(58);
		dto.setPrice(2000);
		list.add(dto);
		dto = new CoffeemenuDTO();
		// 15번
		dto.setNo(15);
		dto.setMenu("팥빙수");
		dto.setKcal(400);
		dto.setPrice(10000);
		list.add(dto);
		dto = new CoffeemenuDTO();
	}

}