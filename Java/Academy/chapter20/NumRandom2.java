package chapter20;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumRandom2 {
    /*
    public void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;

        System.out.println("사용자가 입력한 정수 A와 B사이에 있는 난수 10개를");
        System.out.println("무작위로 출력하는 프로그램입니다.");
        while (true) {
            System.out.print("첫번 째 정수 입력 : ");
            num1 = sc.nextInt();
            System.out.print("두번 째 정수 입력 : ");
            num2 = sc.nextInt();

            if (num1 > num2) {
                System.out.println("두번 째 입력 정수는 첫번 째 입력 정수보다 커야합니다.");
                System.out.println("다시 입력해 주세요.");
                continue;
            }
            else {
                for (int i = 0; i < 10; i++) {
                    System.out.println(ran.nextInt(num1, num2));
                }
            }
            return;
        }
    }

    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;

        System.out.println("사용자가 입력한 정수 A와 B사이에 있는 난수 10개를");
        System.out.println("무작위로 출력하는 프로그램입니다.");

        System.out.print("첫번 째 정수 입력 : ");
        num1 = sc.nextInt();
        System.out.print("두번 째 정수 입력 : ");
        num2 = sc.nextInt();

        if (num1 > num2) {
            for (int i = 0; i < 10; i++) {
                System.out.println(ran.nextInt(num2, num1));
            }
        } else {
            for (int i = 0; i < 10; i++) {
                System.out.println(ran.nextInt(num1, num2));
            }
        }
    }


    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> intArr= new ArrayList<>();
        int num1;
        int num2;
        int ranVal1;
        int ranVal2;

        System.out.println("사용자가 입력한 정수 A와 B사이에 있는 난수 10개를");
        System.out.println("무작위로 출력하는 프로그램입니다.");

        System.out.print("첫번 째 정수 입력 : ");
        num1 = sc.nextInt();
        System.out.print("두번 째 정수 입력 : ");
        num2 = sc.nextInt();

        if (num1 > num2) {
            for (int i = 0; i < 10; i++) {
                ranVal1 = ran.nextInt(num2, num1);
                intArr.add(ranVal1);
                System.out.println(intArr.get(i));

                for (int j = 0; j < i; j++) {
                    ranVal2 = ran.nextInt(num2, num1);
                    intArr.add(ranVal2);

                    if (ranVal1 == ranVal2) {
                        break;
                    } else {
                        System.out.println(ranVal2);
                    }
                }
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                ranVal1 = ran.nextInt(num1, num2);
                intArr.add(ranVal1);

                for (int j = 0; j < i; j++) {
                    ranVal2 = ran.nextInt(num1, num2);
                    intArr.add(ranVal2);

                    if (ranVal1 == ranVal2) {
                        --i;
                        break;
                    }
                }
            }
            System.out.println(intArr);
        }
    }
   */


    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> intArr = new ArrayList<>();
        int num1, num2;
        int val1, val2;
        int ranVal1, ranVal2;

        System.out.println("사용자가 입력한 정수 A와 B사이에 있는 난수 10개를");
        System.out.println("무작위로 출력하는 프로그램입니다.");

        System.out.print("첫번 째 정수 입력 : ");
        num1 = sc.nextInt();
        System.out.print("두번 째 정수 입력 : ");
        num2 = sc.nextInt();

        if (num1 > num2) {
            int i;
            for (i = 0; i < 10; i++) {
                ranVal1 = num2;
                ranVal1 += ran.nextInt(num1 - num2 + 1);
                //난수 배열 저장
                intArr.add(ranVal1);
                //중복 체크
                for (int j = 0; j < i; j++) {
                    if (intArr.get(j) == ranVal1) {
                        System.out.println("같다 " + ranVal1);
                        intArr.remove(intArr.size() - 1);
                        i--;
                    } else {
                        break;
                    }
                }
            }
        }
        else {
            for (intArr.size(); intArr.size() < 10; ) {
                ranVal1 = ran.nextInt(num1, num2);      // 범위 내 난수 생
                intArr.add(ranVal1);                    // 난수를 배열에 저장.

                for (intArr.size(); intArr.size() < 10; ) {     //
                    ranVal2 = ran.nextInt(num1, num2);
                    intArr.add(ranVal2);

                    if (ranVal1 == ranVal2) { //intarr.get() ??
                        intArr.remove(intArr.size() - 1);
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(intArr);
    }
}

// String generatedString = toString

//중복 제거
//문자열 무작위 배열
//문자와 숫자 특수문자의 무작위 배열

