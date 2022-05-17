package chapter14;

public class Man {

    private String name;

    public Man() {
    }

    public Man(String name) {
        //�ڹ��� ��� Ŭ������ ObjectŬ������ ����ϰ� �ִ�
        super();
        this.name = name;
    }

    public void tellYourName() {
        System.out.println("My name is " + name);
    }
}





