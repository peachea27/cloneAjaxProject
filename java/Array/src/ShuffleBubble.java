import java.util.Arrays;

public class ShuffleBubble {

	public static void main(String[] args) {
		// 1~9까지의 수를 shuffle한다. -> 버블정렬-> 오름차순으로 정렬결과를 출력한다.
		int nine[] = new int[9];

		for (int i = 0; i < 9; i++) {
			nine[i] = i + 1;
		}
		System.out.println("배열 : " + Arrays.toString(nine));

	
		for (int i = 0; i < 100; i++) {

			int k = (int) (Math.random() * 9);// k따로 빼줘서 하나의 값으로 고정시켜주지 않으면 두번 계산돼서 이상해짐
			System.out.print(k);
			int j = nine[0];
			nine[0] = nine[k];
			nine[k] = j; 
		}
		System.out.println("셔플 : " + Arrays.toString(nine));

		// 정렬
//		for (int i = 0; i < nine.length; i++) {
//			for ( int p = i+1; p < nine.length; p++) {
//				if(nine[i]>nine[p]) {
//					int k =0;
//					k=nine[i];
//					nine[i]=nine[p];
//					nine[p]=k;
//				}
//			}
//		}
//		System.out.println("오름차순:"+Arrays.toString(nine));

///버블정렬
		for (int i = 0; i < nine.length - 1; i++){
		boolean isSort = false;
		System.out.println("i =" +i);
		   for (int j =0 ; j < nine.length -1 -i ; j++){
			   if(nine[j] > nine[j+1]) {
				   //swap
				   int tmp = nine[j];
				   nine[j]=nine[j+1];
				   nine[j+1]=tmp;
				   isSort = true;
			   }
			   System.out.println(Arrays.toString(nine) + isSort);
		   }
		//찍어가면서 해서 코드 개선하기, 아주 많은 데이터를 다루고 있다고 가정하고 신중하게

		
		//선생님과는 다른 방법으로 버블정렬
//		
//		for (int t = nine.length; t > 0; t--) {
//			for (int i = 0; i < nine.length - 1; i++) {
//				if (nine[i] > nine[i + 1]) {
//					int k = nine[i];
//					nine[i] = nine[i + 1];
//					nine[i + 1] = k;
//				}
//			}
//		}
//		System.out.println("버블:" + Arrays.toString(nine));

	}

	}
	}
