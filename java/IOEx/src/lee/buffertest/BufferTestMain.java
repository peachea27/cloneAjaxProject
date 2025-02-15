package lee.buffertest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferTestMain {

	public static void main(String[] args) throws IOException { /* exception안일어날거니까 걍 의미없음 */
		String originalFilePath ="D:/temp/sea.jpg";
		String copyFilePath = "D:/temp/copysea.jpg";
		String copyFilePath2 = "D:/temp/copysea2.jpg";
		/* 입출력스트림 생성 */
		FileInputStream fis = new FileInputStream(originalFilePath);
		FileOutputStream fos = new FileOutputStream(copyFilePath);
		
		copy(fis, fos);

		fis.close();
		fos.close();
		
		/* 입출력스트림 생성 + 버퍼 스트림 */
		FileInputStream fis2 = new FileInputStream(originalFilePath);
		FileOutputStream fos2 = new FileOutputStream(copyFilePath2);
		
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		copy(bis,bos);
		bis.close();
		bos.close();
		
	}

	public static void copy(InputStream is, OutputStream os) throws IOException {
		/* FileInputStream,FileOutputStream => InputStream,OutputStream 으로 바꿔주면 bis bos도 적용가능 */
		long start = System.nanoTime();
		while (true) {
			int data = is.read();
			if(data == -1) break;
			os.write(data);
		}
		
		os.flush(); /* buffer에 남아있는것까지 다 흘려보냄 */
		long end = System.nanoTime();
		System.out.println((end-start)+"ns");
		/*buffer를 이용하는편이 빠르고 성능면에서 좋음*/
	}

}
