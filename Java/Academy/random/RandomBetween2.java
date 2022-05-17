package random;

import java.util.Random;
import java.util.Scanner;

public class RandomBetween2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("�Է�1:");
        int a = scanner.nextInt();
        System.out.println("�Է�2:");
        int z = scanner.nextInt();

        int min, max;
        if (a > z) {
            min = z;
            max = a;
        } else {
            min = a;
            max = z;
        }

        Random random = new Random();
        //�������� ���� ���� + �ּҰ�
        //5 15 15-5 10+1 1 4 6 5
        int rn;
        int[] iArr = new int[10];
        for (int i = 0; i < 10; i++) {
            rn = min;
            rn += random.nextInt(max - min + 1);
            iArr[i] = rn;
        }
        System.out.println("before sort");
        for (int i = 0; i < iArr.length; i++) {
            System.out.print(iArr[i] + " ");
        }
        //����-��������
        int temp;
        for (int i = 0; i < iArr.length; i++) {
            for (int j = 0; j < iArr.length; j++) {
                if (iArr[i] < iArr[j]) {
                    temp = iArr[i];
                    iArr[i] = iArr[j];
                    iArr[j] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("sorted");
        for (int i = 0; i < iArr.length; i++) {
            System.out.print(iArr[i] + " ");
        }
    }

}






