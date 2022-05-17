package chapter05;

public class InfinityLoop {

    public static void main(String[] args) {
        int num = 1;
        while (num < 100) {
            if (num % 6 == 0 && num % 14 == 0) {
                break;
            }
            System.out.println("IL");
            num++;
        }
        System.out.println(num);
    }
}
