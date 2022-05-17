package chapter05;

public class BasicIf {

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 7;
        if (n1 < n2) {
            //�Ұ�ȣ�� ������ true�� �� ����
//			System.out.println("5<7 is true");
//			System.out.println("5<7 is true");
//			System.out.println("5<7 is true");
        }
        //if���� ���� ������ �ϳ��� ��� �߰�ȣ ���� ����
        if (n1 > n2)
//			System.out.println("5<7 is true in if");
            if (n1 > n2) {
//			System.out.println("5<7 is true in if");
            }
//		System.out.println("5<7 is true");
        //if ~ else��
        if (n1 == n2) {
            System.out.println("n1 == n2 is true");
        } else {
            //�Ұ�ȣ�� ������ false�� �� ����Ǵ� ����
            System.out.println("n1==n2 is false");
        }
    }

}





