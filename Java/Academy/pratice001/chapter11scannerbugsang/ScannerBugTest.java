package chapter11scannerbugsang;

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
//		System.out.println("입력받은 정수 : "+num1+"\n" +	// Console Result
//				"입력받은 문자열 : " + str1);
//	}


	/* 출력의도>
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


//	1	
//	public static void main(String[] args) {
//       System.out.println(System.in);
//       System.out.println(args);
//
//       int nextInt = (6);
//       System.out.println(nextInt);
//       int nextLine = (2);
//       System.out.println(nextLine);
//
//
//       //String nextInt = ("자바");    //java: variable nextInt is already defined in method main(java.lang.String[])
//
//       //String nextLine = ("자바");


//	2
//	public static void main(String[] args) {
//		System.out.println(args);
//		System.out.println(System.in);
//		java.util.Scanner sc = new Scanner(System.in);
//		System.out.println(sc);

	
	
//	3
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


	
//	4
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


	
//	5
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


	
//	6
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


	
//	7
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
		
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println(num1);
		
		System.out.println("문자열 입력 : ");
		String str1 = sc.nextLine();
		System.out.println(str1);
		
		
	}
	
/*	
 * 
 * 	nextInt >
	Scans the next token of the input as an int. 
	An invocation of this method of the form nextInt() behaves in exactly the same way as theinvocation nextInt(radix), 
	where radixis the default radix of this scanner.

	입력의 다음 토큰을 int로 검색합니다.
	nextInt() 형식의 이 메서드를 호출하면 nextInt(radix) 호출과 정확히 같은 방식으로 동작합니다.
	여기서 radix는 이 스캐너의 기본 기수입니다.
	
	
	nextLine >
	Advances this scanner past the current line and returns the inputthat was skipped.
	This method returns the rest of the current line, excluding any lineseparator at the end.
	The position is set to the beginning of the nextline. 
	Since this method continues to search through the input lookingfor a line separator,
	it may buffer all of the input searching forthe line to skip if no line separators are present.
	
	이 스캐너를 현재 줄 위로 이동하고 건너뛴 입력을 반환합니다.이 메서드는 끝의 줄 <구분 기호>를 제외한 현재 줄의 나머지 부분을 반환합니다.
	위치는 <다음 줄>의 시작 부분으로 설정됩니다.
	이 메서드는 라인 구분자를 찾는 입력을 계속 검색하기 때문에 라인 구분자가 없는 경우 줄 바꿈을 검색하는 모든 입력을 버퍼링할 수 있습니다.
		

*/
	
	
	//nextLine 를 두번 사용하는 방법이 있다는 것은 알고 있지만
	
	//nextInt 후 입력자가 nextLine로 입력된다는 것을 검증 할 수 있는 방법은?
	
	
}