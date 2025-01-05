package lee.bytestreamex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteMain1 {

	public static void main(String[] args) {
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		try {
			
			OutputStream os = new FileOutputStream("D:\\temp\\test1.dat"); /* temp폴더 들어가면 파일 생겨있음(3byte, a,b,c) */
			
			/* 1바이트출력 */
			os.write(a);
			os.write(b);
			os.write(c);
			
//			os.flush(); /* 잔류하는걸 싹 내보내라는? 여기서 꼭 필요하진 않고 buffer할 때 씀 */
			os.close(); /* 중요한건 close를 해야한다는 것 */
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
