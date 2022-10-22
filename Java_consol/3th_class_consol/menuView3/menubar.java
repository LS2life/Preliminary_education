package menuView3;

public class menubar extends Menu {
	public void bar() {
		CoffeemenuDTO c = new CoffeemenuDTO() ;
		//1번
		c.setNo("1");
		c.setMenu("아메리카노");
		c.setKcal(5);
		c.setAmount(1800);
		list.add(c);
		//2번
		c= new CoffeemenuDTO();
		c.setNo("2");
		c.setMenu("카라멜마끼야또");
		c.setKcal(300);
		c.setAmount(3300);
		list.add(c);
		//3번
		c= new CoffeemenuDTO();
		c.setNo("3");
		c.setMenu("카페모카");
		c.setKcal(300);
		c.setAmount(3500);
		list.add(c);
		//4번
		c= new CoffeemenuDTO();
		c.setNo("4");
		c.setMenu("자바칩프라푸치노");
		c.setKcal(340);
		c.setAmount(4800);
		list.add(c);
		//5번
		c= new CoffeemenuDTO();
		c.setNo("5");
		c.setMenu("카푸치노");
		c.setKcal(150);
		c.setAmount(3300);
		list.add(c);
		//6번
		c= new CoffeemenuDTO();
		c.setNo("6");
		c.setMenu("헤이즐넛 아메리카노");
		c.setKcal(70);
		c.setAmount(2200);
		list.add(c);
		//7번
		c= new CoffeemenuDTO();
		c.setNo("7");
		c.setMenu("딸기스무디");
		c.setKcal(180);
		c.setAmount(6000);
		list.add(c);
		//8번
		c= new CoffeemenuDTO();
		c.setNo("8");
		c.setMenu("자몽스무디");
		c.setKcal(200);
		c.setAmount(6000);
		list.add(c);
		//9번
		c= new CoffeemenuDTO();
		c.setNo("9");
		c.setMenu("복숭아 아이스티");
		c.setKcal(70);
		c.setAmount(2800);
		list.add(c);
		//10번
		c= new CoffeemenuDTO();
		c.setNo("10");
		c.setMenu("바닐라라떼");
		c.setKcal(180);
		c.setAmount(4800);
		list.add(c);
		//11번
		c= new CoffeemenuDTO();
		c.setNo("11");
		c.setMenu("아포가토");
		c.setKcal(381);
		c.setAmount(3800);
		list.add(c);
		//12번
		c= new CoffeemenuDTO();
		c.setNo("12");
		c.setMenu("에스프레소");
		c.setKcal(10);
		c.setAmount(3600);
		list.add(c);
		//13번
		c= new CoffeemenuDTO();
		c.setNo("13");
		c.setMenu("조각케이크");
		c.setKcal(775);
		c.setAmount(6000);
		list.add(c);
		//14번
		c= new CoffeemenuDTO();
		c.setNo("14");
		c.setMenu("마카롱");
		c.setKcal(58);
		c.setAmount(2000);
		list.add(c);
		//15번
		c= new CoffeemenuDTO();
		c.setNo("15");
		c.setMenu("팥빙수");
		c.setKcal(400);
		c.setAmount(10000);
		list.add(c);
	}
	
}
