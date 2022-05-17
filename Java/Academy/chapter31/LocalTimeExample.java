package chapter31;

import java.time.Duration;
import java.time.LocalTime;

public class LocalTimeExample {
	public static void main(String[] args) {
		//현재 시각
		LocalTime now=LocalTime.now();
		System.out.println(now);
		//4시간 10분 후에 약속
		LocalTime mt=now.plusHours(4);
		mt=mt.plusMinutes(10);
		System.out.println(mt);
		LocalTime mt1=now;
		mt1=mt1.plusHours(4);
		mt1=mt1.plusMinutes(10);
		
		//점심 시간
		//현재 시간
		LocalTime now1=LocalTime.now();
		System.out.println(now1);
		//점심 시간
		LocalTime lunchTime=LocalTime.of(16, 40);
		//두시간의 차 Duration
		Duration between=Duration.between(now1, lunchTime);
		System.out.println(between);
		System.out.println(between.toHours());
		System.out.println(between.toMinutes());
	}

}



