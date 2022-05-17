package chapter11;

public class PlusOp {
    public static void main(String[] args) {
        PlusOp plusOp = new PlusOp();
        plusOp.plusOp(1, 1);
        plusOp.plusOp(1, 1.1);
        plusOp.plusOp(1, 1, 3);
    }

    //�޼ҵ� �����ε�
    //�Ű������� Ÿ�԰� ������ ���� �����ؼ� �޼ҵ��� �̸��� ���� �Ѵ�
    //1.�Ű������� ������ Ÿ�� 2. �Ű����� ����
    public void plusOp(int n1, int n2) {
        System.out.println(n1 + n2);
    }

    public void plusOp(int n1, int n2, int n3) {
        System.out.println(n1 + n2);
    }

    public void plusOp(double n1, double n2) {
        System.out.println(n1 + n2);
    }

}
