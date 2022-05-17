package chapter05;

public class SwitchBasic {
    public static void main(String[] args) {
        int n = 5;
        //break�� �߰�ȣ�� ���� ����
        switch (n) {
            case 1:
                System.out.println("Simple Java");
                break;
            case 2:
                System.out.println("Funny Java");
                break;
            case 3:
                System.out.println("Fantastic Java");
                break;
            default:
                System.out.println("The best");
        }
        System.out.println("Like Java?");
    }

}



