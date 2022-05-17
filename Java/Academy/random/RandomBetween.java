package random;

import java.util.Scanner;
import java.util.Random;

class RandomBetween {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("�Է�1: ");
        int A = keyboard.nextInt();

        System.out.print("�Է�2: ");
        int Z = keyboard.nextInt();

        int min, max;

        if (A > Z) {
            min = Z;
            max = A;
        } else {
            min = A;
            max = Z;
        }

        Random rand = new Random();
        int rn;

        int[] iArr = new int[10];

        for (int i = 0; i < 10; i++) {
            rn = min;
            rn += rand.nextInt(max - min + 1);
            iArr[i] = rn;
            System.out.println(rn);
        }
        System.out.println("before sort");
        for (int i = 0; i < iArr.length; i++) {
            System.out.print(iArr[i] + " ");
        }
        System.out.println();
        int temp = 0;
        for (int i = 0; i < iArr.length; i++) {
            for (int j = 0; j < iArr.length; j++) {
                if (iArr[i] < iArr[j]) {
                    temp = iArr[j];
                    iArr[j] = iArr[i];
                    iArr[i] = temp;
                }
            }
        }
        System.out.println("sort");
        for (int i = 0; i < iArr.length; i++) {
            System.out.print(iArr[i] + " ");
        }
    }
}
