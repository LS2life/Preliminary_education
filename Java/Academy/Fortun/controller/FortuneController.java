package controller;

import dto.FortuneVO;
import service.FortuneRepository;
import service.FortuneService;
import view.FortuneView;

public class FortuneController {
	
	private FortuneService fortuneService=new FortuneRepository();
	private FortuneView fortuneView=new FortuneView();
	
	//main loop
	public void runApp() {
		int choice;
		while(true) {
			choice=fortuneView.getMenu();
			switch(choice) {
				case 0:
					return;
				case 1:
					fortuneView.getFortune(fortuneService.getFortuneList());
			}
		}
	}

	//C
	public void createFortune(int id,String name,
			String fortuneStr){
		fortuneService.createFortune(id,name,fortuneStr);
	}
	
	//Read All
	public void getFortunes() {
		fortuneView.getFortunes(
				fortuneService.getFortuneList());
	}
	
	//Read One
	public void getFortune() {
		fortuneView.getFortune(
				fortuneService.getFortuneList());
	}
	
	//U
	public void putFortune(FortuneVO fortuneVO) {
		fortuneService.putFortune(fortuneVO);
	}
	
	//D
	public void deleteFortune(FortuneVO fortuneVO) {
		fortuneService.deleteFortune(fortuneVO);
	}

}
