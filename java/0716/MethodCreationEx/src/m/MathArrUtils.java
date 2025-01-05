package m;

public class MathArrUtils {


		// sum(), average(), min(), max(), sort()
		public static int sum(int[] intArr) {
			int total =0;
			for (int inum : intArr) {
				total +=inum;
			}
			return total;
		}

		public static double average(int[] intArr) {
			double avg = sum(intArr) / intArr.length; //sum함수 여기서 호출 가능 /같은 static이기 때문에
			
			return avg;
		}
		
		public static int min(int[] intArr) {
			int minValue = intArr[0];
			for (int iNum : intArr) {
				if (iNum < minValue) {
					minValue = iNum;
				}
			}
			
			return minValue;
		}
		
		public static int max(int[] intArr) {
			int maxValue = intArr[0];
			for (int iNum : intArr) {
				if(iNum> maxValue) {
					maxValue = iNum;
				}
			}
			return maxValue;
		}
		
		public static int[] sort(int[] intArr) {
			for (int i =0; i < intArr.length; i++) {
				for(int j =0; j < intArr.length-1 -i; j++) {
					if (intArr[j] > intArr[j+1]) {
						int tmp = intArr[j];
						intArr[j]=intArr[j+1];
						intArr[j+1] =tmp;
					}
				}
			}
			return intArr;
		}
	

}
