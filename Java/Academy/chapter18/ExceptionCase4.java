package chapter18;

import java.util.Scanner;

public class ExceptionCase4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������ ���α׷� ����");
        try {
            System.out.print("a/b....a? ");
            int n1 = scanner.nextInt();
            scanner.nextLine();
            System.out.print("a/b....b? ");
            int n2 = scanner.nextInt();
            System.out.println(n1 + "/" + n2 + "=" + n1 / n2);
        } catch (Throwable e) {
            System.out.println("���� �߸� �Է��߽��ϴ�");
        }
        System.out.println("������ ���α׷� ����");
    }

}
