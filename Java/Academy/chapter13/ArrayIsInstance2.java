package chapter13;

public class ArrayIsInstance2 {

    public static void main(String[] args) {
        //���̰� 5�� int�� �迭�� ����
        int[] ar1 = new int[5];
        String[] as1 = new String[10];
        //[���ؽ���(index)]
        ar1[0] = 7;
        ar1[1] = 8;
        ar1[2] = 9;
        ar1[3] = 10;
        ar1[4] = 11;
        ar1[0] = 77;
        ar1[1] = ar1[4];
        System.out.println(ar1[0]);
        System.out.println(ar1[1]);
        System.out.println(ar1[2]);
        System.out.println(ar1[3]);
        System.out.println(ar1[4]);
        for (int i = 0; i < ar1.length; i++) {
            System.out.println(ar1[i]);
        }

    }

}











