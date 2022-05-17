package chapter04;

public class RelationalOp {
    public static void main(String[] args) {
        System.out.println(1 > 2);
        int num1 = 1;
        int num2 = 2;
        int num3 = 2;
        System.out.println(num1 > num2);
        System.out.println(num2 > num1);
        System.out.println(num2 >= num3);
        System.out.println(num2 <= num3);
        System.out.println(num2 == num3);
        System.out.println(num2 != num3);
        System.out.println(num2 != num1);
    }

}
