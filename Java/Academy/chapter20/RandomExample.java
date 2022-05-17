package chapter20;

import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random rand = new Random(42);
        for (int i = 0; i < 10; i++) {
            System.out.println(rand.nextInt(10) + 1);
        }
    }

}
