package chapter05;

public class CondOp {
    public static void main(String[] args) {
        int num1 = 150;
        int num2 = 200;
        int big;
        int diff;
        //ctrl+/ ���ÿ����ּ�ó��
//		if(num1>num2) {
//			big=num1;
//		}else {
//			big=num2;
//		}
        big = (num1 > num2) ? num1 : num2;
        System.out.println("ū ��: " + big);
        //���밪
        diff = (num1 > num2) ? (num1 - num2) : (num2 - num1);
        System.out.println("���밪: " + diff);
    }
}






