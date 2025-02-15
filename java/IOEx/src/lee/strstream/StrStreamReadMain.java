package lee.strstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class StrStreamReadMain {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("D:\\temp\\Stringtest.txt");
			Reader reader = new InputStreamReader(is); /* 보조스트림 */
			
			/* 1글자씩 읽어오기 */
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				System.out.println((char)data); /* 아스키코드값 출력 : 문자로 찍으려면->캐스팅 */
			}
			reader.close();
			
			Reader reader1 = new FileReader("D:\\temp\\Stringtest.txt");
			/* 문자 배열로 읽어오기 */
			char[] data = new char[50];
			while(true) {
				int num = reader1.read(data);
				if(num == -1) break;
				
//				System.out.println(Arrays.toString(data));
				for ( int i = 0; i <num; i++) {
					System.out.println(data[i]);
				}
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
