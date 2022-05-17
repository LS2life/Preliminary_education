package chapter32;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteReadFromFile {
	
	public static void main(String[] args) throws IOException {
		OutputStream out=null;
		try {
			out=new FileOutputStream("data.dat");
			out.write(7);
			System.out.println("파일 쓰기 성공");
		} catch (IOException e) {
			e.getMessage();
		}finally {
			if(out!=null) {
				out.close();
			}
		}
	}

}










