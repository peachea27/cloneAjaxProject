package lee.bytestreamex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadMain1 {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			 is = new FileInputStream("D:/temp/test1.dat");
			
//			int data = is.read(); /* 10 */
//			System.out.println(data);
//			data = is.read(); /* 20 */
//			System.out.println(data);
//			data = is.read(); /* 30 */
//			System.out.println(data);
//			data = is.read(); /* -1*/
//			System.out.println(data);
			while(true) {
				int data = is.read();
				if(data == -1) break;
				System.out.println(data);
				}
			
//			is.close(); 이런곳이 아니라 밖에서 처리해주는게 좋다
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			}catch(IOException e) {
				
			}
	}
	}

}
