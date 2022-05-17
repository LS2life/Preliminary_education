package chapter11scannerbugpi;
//버그 잡기
import java.util.Scanner;

public class sbug {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//스페이스 바를 사용한다면 n1에서 n2로 넘어감
		//스페이스 바를 사용시 출력의 순서가 불완전함
		//엔터키를 사용시 엔터키또한 문자열로 반환되어 엔터키값을 할당할 새로운 스캐너를 생성해야함
		//next()을 사용하여 엔터키를 제거 but 한단어만을 사용할수있음-문장을 구사하지 못함
		//상황에따라 nextline+엔터키를 받아줄 nextline 혹은 next를 사용함
		System.out.println("정수 입력 ");
		int n1=sc.nextInt();
		sc.nextLine();
		System.out.println("문자 입력 ");
		String n2=sc.nextLine();
	
		System.out.println(n1+" "+n2);
		System.out.println(n1+n2);
	}
}







