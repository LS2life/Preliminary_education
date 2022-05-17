package random;

import java.util.Random;

public class StringRandom {
	public static void main(String[] args) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
		    int randomLimitedInt = leftLimit + (int)
		            (random.nextFloat() * (rightLimit - leftLimit + 1));
		    buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		System.out.println(generatedString);
		for (int i = 33; i < 127; i++) {
            System.out.print((char)i);
            if(i%20 == 0) System.out.println();;
        }
		int a=65;
		System.out.println("----------");
		System.out.println((char)a);
	}

}
