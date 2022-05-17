package chapter16;

public class ChildAdder extends ParentAdder {

    //�޼ҵ� �������̵� �ƴϰ� �޼ҵ� �����ε�
//	public double add(double a, double b) {
//		System.out.println("������ �����մϴ�.");
//		return a+b;
//	}

    //���α׷����� �Ǽ��ϴ� ��Ȳ�� ���� ���� ������̼��� ���ش�
    @Override
    public int add(int a, int b) {
        System.out.println("������ �����մϴ�.");
        return a + b;
    }
}
