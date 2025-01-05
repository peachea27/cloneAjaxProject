package weblyh;

import java.util.Arrays;

import m.MathArrUtils;
//import m.*; //m패키지의 모든 클래스를 import한다


public class MathArrUtilsMain {

	public static void main(String[] args) {
		int[] arr = {1,3,4,2,5};
		System.out.println("sum = " + MathArrUtils.sum(arr));
		System.out.println("average = " + MathArrUtils.average(arr));
		System.out.println("min = " + MathArrUtils.min(arr));
		System.out.println("max = " + MathArrUtils.max(arr));
		System.out.println("sort = " + Arrays.toString(MathArrUtils.sort(arr)));
	

	}

}
