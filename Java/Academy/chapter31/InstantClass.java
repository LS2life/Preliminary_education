package chapter31;

import java.time.Duration;
import java.time.Instant;

public class InstantClass {
	public static void main(String[] args) {
		//현재 시각
		Instant start=Instant.now();
		//UTC 표준시각
		System.out.println(start);
		//1970-01-01 00:00:00 지나온 시간을 초 단위 계산
		System.out.println(start.getEpochSecond());
		for(int i=0;i<100;i++) {
			i+=i;
		}
		Instant end=Instant.now();
		System.out.println(end.getEpochSecond());
		
		Duration between=Duration.between(start, end);
		//밀리초 1초=1000밀리초
		System.out.println("밀리 초 단위 차: "+between.toMillis());
		//0.017초
	}
	
}















