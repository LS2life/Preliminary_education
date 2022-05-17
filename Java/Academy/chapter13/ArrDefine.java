package chapter13;

public class ArrDefine {

    public static void main(String[] args) {
        int[] arrInt = new int[10];
        printArr(arrInt);
        int[] arrInt2 = new int[]{1, 2, 3, 4, 5};
        printArr(arrInt2);
        int[] arrInt3 = {1, 2, 3};
        printArr(arrInt3);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

    }

    public static int[] printArr(int[] arrInt) {
        for (int i = 0; i < arrInt.length; i++) {
            System.out.println(arrInt[i]);
        }
        return arrInt;
    }

}











