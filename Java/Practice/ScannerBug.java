package chapter12;

import java.util.Scanner;

public class ScannerBugTest {

//	public static void main(String[] args) {
//		Scanner scanner=new Scanner(System.in);			// Input   constructor scanner
//
//		System.out.print("정수 입력 : ");					// Input integer
//		int num1=scanner.nextInt();
//
//		System.out.print("문자열 입력 : ");				// Input spring
//		String str1=scanner.nextLine();
//
//		System.out.println("입력받은 정수 : "+num1+"\n" +	// Result
//				"입력받은 문자열 : " + str1);
//	}


	/*
		Instance 	정수 입력 : 6
					문자열 입력 : 자바
					입력받은 정수 : 6
					입력받은 문자열 : 자바

		Actual Result	정수 입력 : 6
						문자열 입력 : 입력받은 정수 : 6
						입력받은 문자열 :

		Intuitive trouble	System.in ?
							println ?
							nextInt, nextLine ?
							num1, str1 ??
	 */


//	public static void main(String[] args) {
//		System.out.println(args);
//		System.out.println(System.in);
//		java.util.Scanner sc = new Scanner(System.in);
//		System.out.println(sc);

//	1
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("정수 입력 : ");
//		int num1 = sc.nextInt();
//		System.out.println(num1);
//
//		System.out.print("문자열 입력 : ");
//		String str1 = sc.nextLine();			// Integer input pass
//		System.out.println(str1);
//	}

//	2
//	public static void main(String[] args) {	// No issue
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("문자열 입력 : ");
//		String str1 = sc.nextLine();
//		System.out.println(str1);
//
//		System.out.print("정수 입력 : ");
//		int num1 = sc.nextInt();
//		System.out.println(num1);
//	}

//	3
//	public static void main(String[] args) {			// No issue
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("문자열 입력 : ");
//		String str1 = sc.nextLine();
//		System.out.println("입력받은 문자열 : " + str1);
//
//		System.out.print("문자열 입력 2 : ");
//		String str2 = sc.nextLine();
//		System.out.println("입력받은 문자열 : " + str2);
//	}

//	4
//	public static void main(String[] args) {			//No issue
//		Scanner sc = new Scanner(System.in);
//		System.out.print("정수 입력 : ");
//		int num1 = sc.nextInt();
//		System.out.println(num1);
//
//		System.out.print("정수 입력 2 : ");
//		int num2 = sc.nextInt();
//		System.out.println(num2);
//	}

//	5
//	public static void main(String[] args) {            //No issue
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("정수 입력 : ");
//		int num1 = sc.nextInt();
//		System.out.println(num1);
//
//		System.out.print("정수 입력 2 : ");
//		int num2 = sc.nextInt();
//		System.out.println(num2);
//
//		System.out.print("문자열 입력 : ");		// Integer input pass
//		String str1 = sc.nextLine();
//		System.out.println("입력받은 문자열 : " + str1);
//	}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println();
    }
}
