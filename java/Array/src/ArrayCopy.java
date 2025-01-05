import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args) {
		char[] chArr = new char[] {'a', 'b', 'c'};
		System.out.println("원본 배열: " + Arrays.toString(chArr));
		
		// 원본배열 복사 (deep copy)
		char[] copyChArr = new char[chArr.length]; // 초기화된 상태 
		
		int i = 0;
		for (char c : chArr) {
			copyChArr[i++] = c; 
		}
		
		System.out.println("copyChArr : " + Arrays.toString(copyChArr));
		
		// 원본 배열의 값을 수정
		chArr[1] = 'B';
		System.out.println("---------------------deep copy ----------------");
		System.out.println("변경 후 원본 배열 : " + Arrays.toString(chArr));
		System.out.println("변경 후 사본 배열 : " + Arrays.toString(copyChArr));
		
		copyChArr[2] = '가';
		System.out.println("사본 변경 후 원본 배열 : " + Arrays.toString(chArr));
		System.out.println("사본 변경 후 사본 배열 : " + Arrays.toString(copyChArr));
		
		System.out.println(chArr == copyChArr); // false
		System.out.println(chArr.hashCode());
		System.out.println(copyChArr.hashCode());
		
		// 얕은복사
		String[] heroes = new String[] {"아이언맨", "헐크", "캡틴아메리카노"};
		
		System.out.println("---------------------shallow copy ----------------");
		System.out.println("원본배열 :" + Arrays.toString(heroes));
		
		String[] copyHeroes = heroes;
		System.out.println("사본배열 :" + Arrays.toString(copyHeroes));
		
		heroes[2] = "캡틴아메리카";
		System.out.println("원본 변경 후 원본배열 :" + Arrays.toString(heroes));
		System.out.println("원본 변경 후 사본배열 :" + Arrays.toString(copyHeroes));
		
		// 사본 변경하면?
		copyHeroes[2] = "캡틴짱";
		System.out.println("사본 변경 후 원본배열 :" + Arrays.toString(heroes));
		System.out.println("사본 변경 후 사본배열 :" + Arrays.toString(copyHeroes));
		
		// String 
		System.out.println("---------------------------String--------------------------");
		String str1 = "대한민국";
		String str2 = "대한민국";
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		if (str1 == str2) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
		
		// *** 문자열의 값을 비교할 때는 equals() 메서드를 써야 한다. ***
		if (str1.equals(str2)) {
			System.out.println("값이 같음");
		} else {
			System.out.println("값이 다름");
		}
		
		String str3 = new String("대한민국");
		String str4 = new String("대한민국");
		System.out.println("str3 : " + str3);
		System.out.println("str4 : " + str4);
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		if (str3 == str4) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
		
		// *** 문자열의 값을 비교할 때는 equals() 메서드를 써야 한다. ***
		if (str3.equals(str4)) {
			System.out.println("값이 같음");
		} else {
			System.out.println("값이 다름");
		}
		
		// System.arraycopy() 
		
		// 깊은 복사 
		// 1) new 연산자로 복사객체를 생성 for문을 이용해서 각요소를 복사
		// 2) Arrrays.copyOf()
		// 3) System.arraycopy()
		
		// 2) 
		int[] arr = {0, 1, 2, 3, 4};
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("arr2 : " + Arrays.toString(arr2));
		int[] arr3 = Arrays.copyOf(arr, 10);
		System.out.println("arr3 : " + Arrays.toString(arr3));
		arr[3] = 30;
		System.out.println("수정 후 arr : " + Arrays.toString(arr));
		System.out.println("수정 후 arr2 : " + Arrays.toString(arr2));
		
		// 3) 
		char[] arr4 = {'a', 'b', 'c'};
		char[] num4 = {'0', '1', '2', '3', '4', '5'};
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(num4));
		
		char[] copyArr = new char[num4.length];
		System.out.println(Arrays.toString(copyArr));
		
		System.arraycopy(num4, 0, copyArr, 0, num4.length);
		System.out.println(Arrays.toString(copyArr));
		System.out.println(num4 == copyArr);
		
		// 정렬
		int[] arr5 = {3, 5, 1, 4, 2};
		Arrays.sort(arr5); // 오름차순으로 정렬
		System.out.println(Arrays.toString(arr5));
		
		int intA = 12;
	
		// Boxing (primitive type -> wrapper class (참조타입) )
		Integer integerA = new Integer(intA);
		System.out.println(integerA);
		
		// Unboxing (참조 타입 -> primitive type)
		int intB = integerA.intValue();
		System.out.println(intB);
		
		
		
		
		
		
		
		
		
		
	}
	
}
