package chapter14;

public class BusinessMan extends Man {

    private String company;
    private String position;

    public BusinessMan(String name, String company, String position) {
        //super(); ���� Ŭ������ ������ �޼ҵ带 ȣ��
        super(name);
        this.company = company;
        this.position = position;
    }

    public void tellYourInfo() {
//		printCompany();
        tellYourName();
        System.out.println("My company is " + company);
        System.out.println("My position is " + position);
    }

    public void printCompany() {
        System.out.println("My company is " + company);
    }

}
