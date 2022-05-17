package chapter20;

import java.util.StringTokenizer;

public class Tokenizer {
    public static void main(String[] args) {
        String time1 = "PM:08:35";

        String[] sa1 = new String[3];
        //split()
        StringTokenizer st1 =
                new StringTokenizer(time1, ":");
        int cnt = 0;
        while (st1.hasMoreTokens()) {
//			System.out.println(st1.nextToken()+" ");
            sa1[cnt++] = st1.nextToken();
        }
        System.out.println(sa1[0]);
        System.out.println(sa1[1]);
        System.out.println(sa1[2]);
    }

}
