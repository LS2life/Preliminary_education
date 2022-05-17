package chapter32;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Wirte7ToFile3 {
	public static void main(String[] args) {
		//try-with-resource
		try(OutputStream out=new FileOutputStream("data.dat")){
			out.write(7);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
