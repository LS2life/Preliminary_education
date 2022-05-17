package chapter06;

public class MethodReturns {
    public static void main(String[] args) {
        int result;
        result = adder(4, 5);
//		System.out.println(square(adder(3,6)));
        System.out.println("4+5=" + result);
        System.out.println("3.5*3.5=" + square(3.5));
    }

    public static double square(double num) {
        return num * num;
    }

    public static int adder(int num1, int num2) {
        int addResult = num1 + num2;
        return addResult;
    }

    //void=����=��ȯ ���� ����
    public static void hiEveryone() {

    }

}
