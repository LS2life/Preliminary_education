package chapter31;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterEx {
	public static void main(String[] args) {
		//출력 모양 - 포맷
		ZonedDateTime date=ZonedDateTime.of(
				LocalDateTime.of(2022,04,28,14,04),
				ZoneId.of("Australia/Sydney"));
		System.out.println(date);
		//출력 포맷
		//y-년도,M-월,d-일,H-시간,m-분,s-초
		//22-4-28
		DateTimeFormatter fm1=
				DateTimeFormatter.ofPattern("yy/M/d");
		System.out.println(date.format(fm1));
		DateTimeFormatter fm2=
				DateTimeFormatter.ofPattern("yyyy/MM/d, H:m:s");
		System.out.println(date.format(fm2));
		DateTimeFormatter fm3=
				DateTimeFormatter.ofPattern("yyyy-MM-d, HH:mm:ss");
		System.out.println(date.format(fm3));
	}

}







