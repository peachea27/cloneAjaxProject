package lee.fileex;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class FileExMain {

	public static void main(String[] args) {
		/* "."은 현재 디렉토리의 File객체 생성 >상위: .. >상위: ../.. */
		File curDirectory = new File("."); 
		int fileCnt = 0;
		int dirCnt =0;
		int totalSize = 0; /* 파일의 총용량 */
		File[] files = curDirectory.listFiles();
//		System.out.println(Arrays.toString(files));
		
//		System.out.println(files[1].isDirectory());
//		System.out.println(files[1].getName());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
//		System.out.println(sdf.format(files[1].lastModified()));
		
		if(files != null) {
			
		for( File f : files) {
			String lastModified =sdf.format(f.lastModified());
			System.out.printf(lastModified);
				String dirOrFileSize = f.isDirectory()? "<DIR>": String.valueOf( f.length());
				
				System.out.printf("%-25s %13s %s\n",lastModified,dirOrFileSize, f.getName());
				
				/* 파일이나 디렉토리 개수와 파일의 총용량 */
				if (f.isDirectory()) {
					/* 디렉토리인 경우 */
					dirCnt++;
				}else {
					/* 파일인 경우 */
					fileCnt++;
					totalSize += f.length();
				}
				
				
			}//for문 끝
		
			DecimalFormat df = new DecimalFormat("#,###");
			System.out.println(fileCnt +"개 파일 \t"+ totalSize +"바이트");
			System.out.println(dirCnt+"개 디렉터리 \t"+ df.format( curDirectory.getUsableSpace()) +"바이트");
//			System.out.println("TotalSpace: "+ curDirectory.getTotalSpace());
//			System.out.println("UsableSpace: "+ df.format( curDirectory.getUsableSpace()) +"바이트");
//			System.out.println("FreeSpace: "+ curDirectory.getFreeSpace());
		}
	
	}//main문 끝

}