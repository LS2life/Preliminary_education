package task.chapter07class.nam;

public class Report0413 {
	private String name;
	private String title;
	private String classroom;
	private String target;
	private String test;
	private int people = 0;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public int Mpeople(int empty) {
		people +=empty;
		return people;
	}
	public void printout() {
		System.out.println("강사명 : "+name);
		System.out.println("강의내용 : "+title);
		System.out.println("강의실 : "+classroom);
		System.out.println("수강생: "+target);
		System.out.println("학습확인 : "+test);
	}
	public int printE() {
		System.out.println("여석 : "+people+"석");
		return people;
	}
	public void intro() {
		System.out.println("월요일 개강수업안내");
	}
	public void outro() {
		System.out.println("감사합니다.");
	}
	public static void main(String[] args) {
		Report0413 Do=new Report0413();
		Do.setName("장만호");
		Do.setTitle("형법의 이해");
		Do.setClassroom("2관 606호");
		Do.setTarget("경찰지망생");
		Do.setTest("복습테스트");
		Do.Mpeople(15);
		Do.intro();
		Do.printout();
		Do.printE();
		Do.outro();
		
		System.out.println("\n");
		Report0413 Jang=new Report0413();
		Jang.setName("박가연");
		Jang.setTitle("영어");
		Jang.setClassroom("3관 301호");
		Jang.setTarget("세무직공무원지망생");
		Jang.setTest("하프테스트");
		Jang.Mpeople(5);
		Jang.intro();
		Jang.printout();
		Jang.printE();
		Jang.outro();
		
		System.out.println("\n");
		
		Report0413 Gong=new Report0413();
		Gong.setName("문동준");
		Gong.setTitle("한국사");
		Gong.setClassroom("1관 303호");
		Gong.setTarget("공무원지망생");
		Gong.setTest("하프테스트");
		Gong.Mpeople(0);
		Gong.intro();
		Gong.printout();
		Gong.printE();
		Gong.outro();
		
		
	}

}
