package chapter32;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderExample {
	public static void main(String[] args) {
		try(BufferedWriter bw=
			new BufferedWriter(new FileWriter("ex.txt"));){
			bw.write("안녕하세요111");
			System.out.println("파일 쓰기 성공");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedReader br=
			new BufferedReader(new FileReader("ex.txt"))){
			String str=br.readLine();
			System.out.println(str);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
