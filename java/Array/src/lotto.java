import java.lang.reflect.Array;
import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;
import java.util.Scanner;

public class lotto {

	public static void main(String[] args) {
		// ex5) 1~45 사이의 정수를 6개를 뽑아서 int배열에 넣는다
		Scanner sc = new Scanner(System.in);
		//1~45배열 생성
//		해당 배열 안에서 셔플
//		랜덤하게 섞인 배열 안에서 숫자 6개를 뽑아낸다
		int[] fortyfive = new int[45];
	
		for ( int i = 0; i < fortyfive.length; i ++) {
			fortyfive[i]=i+1;
		}
		
		System.out.println(Arrays.toString(fortyfive));
		
		//해당 배열 안에서 섞는다 (shuffle)
		int temp=0;
		
		for (int i =0; i < 6; i++) {
			//랜덤한 인덱스 번호 추출[0~44]
			int k =(int)(Math.random()*45); //double -> int 형변환
			System.out.println("k="+k);
			
			temp = fortyfive[i];
			fortyfive[i] = fortyfive[k];
			fortyfive[k]=temp;
			System.out.println(Arrays.toString(fortyfive));// 여러번 더 반복하면 더 많이 섞임
		}
		
		//랜덤하게 섞인 배열 안에서 숫자 6개를 뽑아낸다.
		for (int i = 0; i < 6; i++) {
			System.out.print("로또 번호 :" + fortyfive[i]+ " ");
		}
		
	}

}
