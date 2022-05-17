package random;

import java.util.Random;

public class WhoNext {
	
	public static void main(String[] args) {
		Random random=new Random();
		int popNum=3;
		int interval=3;
		String[] nameArr= {
				"권건모","금동욱","김남우","김세환","김여준",
				"김우기","도아람","손재현","양명지","여대훈",
				"이상수","전지용","조재천","최아름","피강효"
		};
		int[] choicedNum=new int[nameArr.length];
		for(int i=0;i<nameArr.length;i++) {
			int temp=random.nextInt(nameArr.length);
			choicedNum[i]=temp;
			for(int x=0;x<i;x++) {
				if(choicedNum[x]==temp) {
					i--;
					continue;
				}
				
			}
		}
		
		for(int i=0;i<popNum;i++) {
			int time=interval;
			for(int j=0;j<interval;j++) {
				System.out.println("추첨 "+time--+"초전...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(
					(i+1)+"번   "+nameArr[choicedNum[i]]);
		}
	}
}
