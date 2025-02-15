package lee.strstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class StrStreamWriteMain {

	public static void main(String[] args) {
		try {
//			OutputStream os = new FileOutputStream("D:\\temp\\Stringtest.txt");
//			Writer writer = new OutputStreamWriter(os); /* 다형성 */
			
			Writer writer = new FileWriter("D:\\temp\\Stringtest.txt");
			
			/* 1 문자씩 출력 */
			char a = 'A';
			writer.write(a);
			char b = 'B';
			writer.write(b);
			char c = 'C';
			writer.write(c);
			
			/* char[] 출력 */
			char[] arr = {'D','E'};
			writer.write(arr);
			
			/* 문자열 출력 */
			writer.write("FGH");
			
			writer.close(); /* 스트림 닫고, 메모리 해제 */
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
