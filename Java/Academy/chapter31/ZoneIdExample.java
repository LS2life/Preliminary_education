package chapter31;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneIdExample {
	public static void main(String[] args) {
		//영국 파리
		ZoneId paris=ZoneId.of("Europe/Paris");
//		System.out.println(paris);
		
		//현재 시각
		ZonedDateTime here=ZonedDateTime.now();
		System.out.println(here);
		System.out.println(here.toLocalDateTime());
		ZonedDateTime parisTime=ZonedDateTime.of(
				here.toLocalDateTime(), ZoneId.of("Europe/Paris"));
//		System.out.println(parisTime);
		
		ZoneId zoneId = ZoneId.of("Europe/Paris"); 
		ZonedDateTime zonedDateTime = ZonedDateTime.now( zoneId );
		ZonedDateTime parisTime1=
				here.withZoneSameInstant(ZoneId.of("Europe/Paris"));
		System.out.println(parisTime1);
		
		
	}

}
