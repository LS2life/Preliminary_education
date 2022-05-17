package chapter11;

public class Person {

    private int regiNum;
    private int passNum;

    public Person(int regiNum) {
        this.regiNum = regiNum;
    }

    public Person(int regiNum, int passNum) {
        this.regiNum = regiNum;
        this.passNum = passNum;
    }

    public static void main(String[] args) {
        //ģ�� A
        Person p1 = new Person(201001013, 356657545);
        p1.showPersonalInfo();
        //ģ�� B - ���� ����
        Person p2 = new Person(201001013);
        p2.showPersonalInfo();
    }

    public void showPersonalInfo() {
        System.out.println("�ֹι�ȣ: " + regiNum);
        if (passNum != 0) {
            System.out.println("���ǹ�ȣ: " + passNum);
        } else {
            System.out.println("���� ����");
        }
    }

}








