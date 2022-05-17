package chapter23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSearch {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("Box");
		list.add("Robot");
		list.add("Apple");
		Collections.sort(list);
		for(String s:list) {
			System.out.println(s);
		}
		int idx=Collections.binarySearch(list, "Robot");
		System.out.println("index: "+idx);
		System.out.println("String: "+list.get(idx));
	}

}
