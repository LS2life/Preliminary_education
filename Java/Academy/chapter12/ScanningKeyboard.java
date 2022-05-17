package chapter12;

import java.util.Scanner;

public class ScanningKeyboard {
    public static void main(String[] args) {
        //���� 3���� �Է� �޾Ƽ� ���ϴ� ���α׷�
        Scanner sc = new Scanner(System.in);
//		Scanner scanner=new Scanner(System.in);
        System.out.print("���� �Է�:");
        int num1 = sc.nextInt();
        System.out.print("���� �Է�:");
        int num2 = sc.nextInt();
        System.out.print("���� �Է�:");
        int num3 = sc.nextInt();
        System.out.println(num1 + "+" +
                num2 + "+" + num3 + "=" + (num1 + num2 + num3));
    }

}
