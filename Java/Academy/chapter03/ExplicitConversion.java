package chapter03;

public class ExplicitConversion {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "1";
        System.out.println(s1 + s2);
        //����� �� ��ȯ
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        System.out.println(i1 + i2);
    }

}
