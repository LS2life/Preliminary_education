package chapter31;

import java.time.LocalDateTime;

public class LocalDateTimeExample {
	public static void main(String[] args) {
		//현재 날짜
		LocalDateTime dt=LocalDateTime.now();
		System.out.println(dt);
		//3일 2시간 15분
		LocalDateTime am=dt;
		am=am.plusDays(3);
		am=am.plusHours(2);
		am=am.plusMinutes(15);
		System.out.println(am);
	}

}
