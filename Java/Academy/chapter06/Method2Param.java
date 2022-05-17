package chapter06;

public class Method2Param {
    public static void main(String[] args) {
        double myShoeSize = 175.9;
        hiEveryone(12, 12.5);
        hiEveryone(13, myShoeSize);
        byEveryone();
    }

    public static void hiEveryone(int age, double shoeSize) {
        System.out.println("�� ���̴� " + age + "�� �Դϴ�.");
        System.out.println("���� �Ź� ������� " + shoeSize + "cm �Դϴ�.");
    }

    public static void byEveryone() {
        System.out.println("������ �˰ڽ��ϴ�.");
    }

}







