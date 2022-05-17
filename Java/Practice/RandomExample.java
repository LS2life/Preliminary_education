package Java.Practice;

import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random rand = new Random(42);
        //for(int i = 0; i<10;i++) {                                            // i++ 는 i를 증가시켜
        for (int i = 0; i < 10; ) {                                                 //제한까지 도달하게한다.
            System.out.println(rand.nextInt(10) + 1);
        }
    }
}
