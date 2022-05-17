package view;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import dto.FortuneVO;

public class FortuneView {
	
	private Scanner scanner=new Scanner(System.in);
	private Random random=new Random();
	
	public int getMenu() {
		System.out.println("운세 콘솔 앱입니다.");
		System.out.println("0.종료");
		System.out.println("1.운세보기");
		System.out.print("선택:");
		int choice=-1;
		try {
			choice=scanner.nextInt();
			scanner.nextLine();
		}catch(InputMismatchException e) {
			scanner.nextLine();
			System.out.println("범위내 숫자를 입력하세요.");
		}
		return choice;
	}
	
	//print All
	public void getFortunes(List<FortuneVO> fortuneList) {
		Iterator<FortuneVO> itr=fortuneList.iterator();
		while(itr.hasNext()) {
			FortuneVO fortuneVO=itr.next();
			System.out.println(fortuneVO.toString());
		}
	}
	
	//print One
	public void getFortune(List<FortuneVO> fortuneList) {
		int randomIndex=random.nextInt(fortuneList.size());
		FortuneVO fortuneVO=fortuneList.get(randomIndex);
		if(fortuneVO.getName().length()>0) {
			System.out.println(fortuneVO.toString());
		}else {
			System.out.println(fortuneVO.getEmptyName());
		}
	}
	
}
