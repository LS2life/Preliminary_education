import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] total = {1,1,2,2,2,8};
        int[] piece = new int[6];

        for (int i = 0; i < piece.length; i++) {
            piece[i] = sc.nextInt();
            System.out.println(total[i]-piece[i] + " ");
        }
        sc.close();
    }
}