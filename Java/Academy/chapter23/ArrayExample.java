package chapter23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayExample {
	public static void main(String[] args) {
		//컬렉션 생성
		//<>-제네릭-저장할 데이터 타입
		//기본데이터 타입(x),래퍼클래스
		ArrayList<Integer> intList=new ArrayList<>();
//		ArrayList<String> strList=new ArrayList<String>();
		String[] strArr=new String[20];
		//Vector 자바 1.3이하에서 사용, 사용 안함
		//저장 길이 만큼 자동으로 공간이 늘었다 줄었다 합니다
		//자바 배열(X) 컬렉션만 쓴다
		List<String> strList1=new ArrayList<>();
		ArrayList<String> strList=new ArrayList<>();
		//저장
//		strList.add(1);
		strList.add("Toy");
		String box="Box";
		strList.add(box);
		strList.add(new String("Robot"));
		strList.add("doll");
		strList.add("Toy");
//		System.out.println(strList.size());
		
		//참조-출력
		for(int i=0;i<strList.size();i++) {
			System.out.println(strList.get(i));
		}
		
		//삭제
		strList.remove(4);
		for(int i=0;i<strList.size();i++) {
			System.out.println(strList.get(i));
		}
		
		System.out.println("foreach");
		for(String s:strList) {
			System.out.println(s);
		}
		
		System.out.println("iterator");
		//이터레이터 사용 - 반복자
		Iterator<String> itr=strList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}













