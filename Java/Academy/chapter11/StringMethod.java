package chapter11;

public class StringMethod {
    public static void main(String[] args) {
        //���ڿ��� �Ϻ� ����
        String bornYear = "100101-3";
        int curYear = 2022;
        //�����̽� (1,2),(1)- ù��° �̻� �ι�° �̸�
        //0���� ����
        String s1 = bornYear.substring(1);
        System.out.println(s1);
        String s2 = bornYear.substring(0, 2);
        System.out.println(s2);
        int age = curYear - Integer.parseInt("20" + s2) + 1;
        System.out.println("����: " + age);
        Integer i = 0;
        //���ڿ� ���� ��
        String st1 = "Lexicographically";
        String st2 = "lexicographically";
        String st3 = new String("Lexicographically");

        //String ==�� �޸� �ּҰ� ��
        if (st1 == st3) {
            System.out.println("st1==st3");
        } else {
            System.out.println("st1!=st3");
        }
        if (st1.equals(st3)) {
            System.out.println("st1==st3");
        } else {
            System.out.println("st1!=st3");
        }
        if (st1.equals(st2)) {
            System.out.println("st1=st2");
        } else {
            System.out.println("st1!=st2");
        }
    }

}
