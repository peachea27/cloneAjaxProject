package lee.strstream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class strBufferReadMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
				br = new BufferedReader(
										 	new InputStreamReader(
										 			new FileInputStream("" +"./src/lee/buffertest/BufferTestMain.java")));
//			br = new BufferedReader(new FileReader("./src/lee/buffertest/BufferTestMain.java"));
				
			while(true) {
					String str = br.readLine();
					if (str == null) break;
					System.out.println(str);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}

}
