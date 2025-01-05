package lee.bytestreamex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteMain2 {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("D:/temp/test2.dat"); /* 파일생김 5byte */
			
			byte[] array = {10,20,30,40,50};
			
			os.write(array);
			
			os.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
