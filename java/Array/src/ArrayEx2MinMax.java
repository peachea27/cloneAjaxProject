import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx2MinMax {

   public static void main(String[] args) {
//       유저에게 n개의 정수를 입력받아 배열에 저장한 후,
//       최소값, 최대값을 찾아서 출력하는 프로그램을 작성하세요. 
      
      int n = 3;
      int[] numArr = new int[n]; // [0, 0, 0]
      int minNum, maxNum;
      
      Scanner sc = new Scanner(System.in);
      
      System.out.println("숫자를 입력하세요>>>");
      for (int i = 0; i < n; i++) {
         numArr[i] = sc.nextInt();
      }
      
      System.out.println(Arrays.toString(numArr));
      
      // 최대값, 최소값 찾기
      minNum = numArr[0];
      maxNum = numArr[0];
      
      for (int i = 1; i < n; i++) {
         if (numArr[i] < minNum) {
            minNum = numArr[i];
         }
         
         if (numArr[i] > maxNum) {
            maxNum = numArr[i];
         }
      }
      
      System.out.println("최소값 : " + minNum);
      System.out.println("최대값 : " + maxNum);
      
//    거스름돈 액수를 유저에게 입력받아서 
//    몇개의 동전으로 지불할 수 있는지 구하는 프로그램을 작성하세요.
//    예를 들어 거스름돈 money = 2680원이라고 하면,
//    출력 : 500원짜리 5개, 100원짜리 1개, 50원짜리 1개, 10원짜리 3개
    
    int[] coinUnit = {500, 100, 50, 10};
    

    System.out.print("거스름돈을 입력하세요 >>>");
    int money = sc.nextInt();
    
    System.out.println("거스름돈 : " + money);
    
    // 2680원
    // 2680 / 500 = 5 .... 180 
    // 180 / 100 = 1 .....80
    // 80 / 50 = 1 .... 30
    // 30 / 10 = 3 ....0
    
    for (int i = 0; i < coinUnit.length; i++) {
       System.out.println( coinUnit[i] + "원 짜리 동전 : " + money / coinUnit[i] + "개"); 
       money %= coinUnit[i];
    }

    sc.close();
   }

}
