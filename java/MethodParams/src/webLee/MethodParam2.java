package webLee;

import java.util.Arrays;

public class MethodParam2 {

	public static void main(String[] args) {
		
			Data dataA = new Data(); //methodParam1과는 다르게 주소값을 넣어놓음
			System.out.println(dataA.value); //0
			dataA.value = 10;
			System.out.println("메서드 호출 전 dataA.value :"+ dataA.value); //10
			calReferenceParam(dataA);
			System.out.println("메서드 호출 후 dataA.value :"+dataA.value);//20
			
//			Data dataB = new Data();
			int[] aArr = {10}; //참조타입:주소값을 가지고 있음
			System.out.println(Arrays.toString(aArr));//[10]
			changeParam(aArr);
			System.out.println(Arrays.toString(aArr));//[100]
		
	}

	static void calReferenceParam(Data dataX) {
		dataX.value = 20;//주소를 찾아가서 그 값을 바꿔버림
	}
	
	static void changeParam(int[] x) {
		x[0] = 100;
	}
	
	
	
}
