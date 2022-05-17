package chapter12;

import java.util.Scanner;

public class ScannerBug {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //���� �Է�
        System.out.print("���� �Է�: ");
        //ctrl+��Ŭ�� �̵�
        int num1 = scanner.nextInt();
        //��ĳ�� ���� ���� ���׸� ���� ������ �ڵ�
        scanner.nextLine();
        //����+\n
        //���ڿ� �Է�
        System.out.print("���ڿ� �Է�: ");
        String str1 = scanner.nextLine();
        //�ܼ� ���
        System.out.println("�Է¹��� ����: " + num1 + "\n" +
                "�Է¹��� ���ڿ�: " + str1);
    }

}








