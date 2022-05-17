package chapter18;

import java.util.Scanner;

public class ExceptionCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("a/b....a? ");
                int n1 = scanner.nextInt();
                System.out.print("a/b....b? ");
                int n2 = scanner.nextInt();
                System.out.println(n1 + "/" + n2 + "=" + n1 / n2);
            } catch (ArithmeticException e) {
                System.out.println("0���� ���� ���� �����ϴ�");
            }
        }
    }

}
