package lee.bytestreamex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ReadMain2 {

	public static void main(String[] args) {

		try {
			InputStream is = new FileInputStream("D:\\temp\\test2.dat");
			
//			byte[] data = new byte[3];
//			
//			int num = is.read(data, 0, 2); /* 읽은 데이터 개수 변환 */
//			System.out.println("(1) num" + num); /* 2 */
//			System.out.println(Arrays.toString(data)); /* [10,20,0] */
//			
//			num = is.read(data,0,2);
//			System.out.println("(2) num" + num); /* 2 */
//			System.out.println(Arrays.toString(data)); /* [30,40,0] */
//
//			num = is.read(data,0,2);
//			System.out.println("(3) num" + num); /* 1 */
//			System.out.println(Arrays.toString(data)); /* [50,40,0] 기존에 읽어왔던 40이 그대로 남아있음*/
//			
//			num = is.read(data,0,2);
//			System.out.println("(4) num" + num); /* -1: 끝에 도달해서 읽을 데이터가 없다*/
//			System.out.println(Arrays.toString(data)); /* [50,40,0] 기존에 읽어왔던 데이터 그대로 남아있음*/
			
			byte[] data = new byte[50];
			
			while(true) {
				int num = is.read(data);
				if(num == -1) break;
				
				for(int i =0; i < num; i++) {
					
					System.out.println(data[i]); 
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
