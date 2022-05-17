package chapter31;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
	public static void main(String[] args) {
		//오늘 부터 크리스마스까지 며칠?
		//오늘
		LocalDate today=LocalDate.now();
		System.out.println(today);
		//올 해의 크리스마스
		LocalDate xmas=LocalDate.of(today.getYear(), 12, 25);
		System.out.println(xmas);
		
		//크리스마스까지 며칠?
		Period left=Period.between(today, xmas);
		System.out.println(left.getMonths()+"월"+
				left.getDays()+"일");
		
	}

}






