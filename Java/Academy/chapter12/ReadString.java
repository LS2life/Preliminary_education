package chapter12;

import java.util.Scanner;

public class ReadString {

    private Scanner scanner = new Scanner(System.in);
    private String str1;
    private String str2;

    public static void main(String[] args) {
        ReadString readString = new ReadString();
        readString.scanString();
        readString.printString();
    }

    public void scanString() {
        System.out.print("���ڿ� �Է�: ");
        str1 = scanner.nextLine();
        System.out.print("���ڿ� �Է�: ");
        str2 = scanner.nextLine();
    }

    public void printString() {
        System.out.println("�Էµ� ���ڿ�1: " + str1);
        System.out.println("�Էµ� ���ڿ�2: " + str2);
    }

}












