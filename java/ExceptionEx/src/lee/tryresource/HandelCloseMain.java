package lee.tryresource;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HandelCloseMain {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
//			 D:\lecture\java\ExceptionEx\src\lee\tryresource\score.dat
		try {
			
			 fis = new FileInputStream("D:\\lecture\\java\\ExceptionEx\\src\\lee\\tryresource\\score.dat");
			
		} catch (FileNotFoundException e) {
////			e.printStackTrace();
			System.out.println("파일이 없습니다.");
		}finally {
			DataInputStream dis = new DataInputStream(fis);
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
			//try-with-resource
		//자동으로 close()호출을 해준다. (단, AutoClose를 구현한 것이어야 한다.
			try(FileInputStream fis2 = new FileInputStream("D:\\lecture\\java\\ExceptionEx\\src\\lee\\tryresource\\score.dat");
			DataInputStream dis2 = new DataInputStream(fis2)) {
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("파일이 없습니다.");
			}
	}

}
