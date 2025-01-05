package lee.hashmap.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Voca {
	static Map<String, String[]> voca = new HashMap<String, String[]>();

	public static void main(String[] args) {
		

		addVoca("apple","사과","뉴욕","미국의 회사");
		addVoca("communication","전달","교통");
		addVoca("section","부문","구역");
		addVoca("banana","바나나");
		
		openVoca();
		
		search("apple");
		
		remove("apple");
		
		
	
	}	
	

		private static void addVoca(String str, String str1, String str2, String str3) {
			String arr[]= {str1,str2,str3};
			voca.put(str, arr);
			
		}
		private static void addVoca(String str, String str1, String str2) {
			String arr[]= {str1,str2};
			voca.put(str, arr);
			
		}
		private static void addVoca(String str, String str1) {
			String arr[]= {str1};
			voca.put(str, arr);
			
		}




		private static void remove(String str) {
			System.out.println("★단어 삭제 : "+str);
		voca.remove(str);
		System.out.println();
		openVoca();
		
	}




		private static void search(String str) {
			System.out.println("★단어 검색 : "+str);
			for(Entry<String, String[]> s: voca.entrySet()) {
				if(str.equals(s.getKey())) {
					System.out.println(s.getKey()+Arrays.toString(s.getValue()));
				}
			}
			System.out.println();
	}

	
		public static void openVoca() {
			System.out.println("★전체 단어장 출력★");
			for (String word : voca.keySet()) {
				String key = word.toString();
				String[]value = voca.get(key);
				System.out.println(key +""+Arrays.toString(value));
			}
			System.out.println();
		}
	
	}


	


