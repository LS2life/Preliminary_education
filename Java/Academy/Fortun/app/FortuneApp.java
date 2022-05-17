package app;

import controller.FortuneController;

public class FortuneApp {
	
	public static void main(String[] args) {
		
		FortuneController fortuneController=new FortuneController();
		
		//C
		fortuneController.createFortune(0,"김자바0","행운이 찾아온다.");
		fortuneController.createFortune(1,"김자바1","불행한 하루가 예상");
		fortuneController.createFortune(2,"김자바2","돈이 굴러온다.");
		fortuneController.createFortune(3,"김자바3","귀인을 만난다.");
		fortuneController.createFortune(4,"김자바4","배고픈 하루가 될것");
//		System.out.println();
		

		//R
//		fortuneController.getFortunes();
//		System.out.println();
		
		//U
//		FortuneVO fortuneVO1=new FortuneVO();
//		fortuneVO1.setId(3);
//		fortuneVO1.setName("");
//		fortuneVO1.setFortuneStr("수정한 운세");
//		fortuneController.putFortune(fortuneVO1);
		//R
//		fortuneController.getFortunes();
//		System.out.println();
		
		//D
//		FortuneVO fortuneVO2=new FortuneVO();
//		fortuneVO2.setId(4);
//		fortuneController.deleteFortune(fortuneVO2);
		//R
//		fortuneController.getFortunes();
//		System.out.println();
		
		//랜덤 10개 보기
//		for(int i=0;i<10;i++) {
//			fortuneController.getFortune();
//		}
//		System.out.println();
		
		//앱 실행
		fortuneController.runApp();
	}

}
