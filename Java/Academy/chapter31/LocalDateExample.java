package chapter31;

import java.time.LocalDate;

public class LocalDateExample {
	public static void main(String[] args) {
		//오늘
		LocalDate today=LocalDate.now();
		System.out.println(today);
		//특정한 날
		String xmax1="2022-12-25";
		LocalDate xmas=LocalDate.of(today.getYear(), 12, 25);
		System.out.println(xmas);
		System.out.println(today.getYear());
		//이브
		LocalDate eve=xmas.minusDays(1);
		System.out.println(eve);
		//오늘부터 1일 - 100일
		LocalDate hundredDay=today.plusDays(100);
		System.out.println(hundredDay);
		
		
	}

}




