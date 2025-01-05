package lee.hashmap.ex1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class HashMapVocaMain {
	public static Scanner sc = new Scanner(System.in);
	public static Map<String, ArrayList<String>> vocaBook = new HashMap<String, ArrayList<String>>();

	public static void main(String[] args) {
		//매뉴 출력
	
		try{
		
			outputMenu();
				
		}catch(Exception e){
			System.out.println("번호를 잘못 입력하셨습니다.");
			outputMenu();
		}finally {
		}
		}
	
	

	private static void outputMenu() {
		boolean yesno=true;
		while (yesno) {
			System.out.println("1.단어 등록");
			System.out.println("2.단어장 출력");
			System.out.println("3.검색 : 단어 -> 뜻");
			System.out.println("4.검색 : 뜻 -> 단어");
			System.out.println("5.단어 삭제");
			System.out.println("9.종료");
			
			System.out.println("번호를 입력>>>");
			
			int menu = Integer.parseInt(sc.nextLine());
		
			switch (menu) {
			case 1:
				addNewWord();
				break;
			case 2:
				outputVocaBook();
				break;
			case 3:
				searchByWord();
				break;
			case 4:
				searchByMeaning();
				break;
			case 5:
				deleteWord();
				break;
			case 6:
				WordsatOnce();
				break;
			case 9:
				sc.close();
				yesno=false;
				break;

			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
				break;
			}
			
	
		
	}
		
	}

	private static void deleteWord() {
		String str =sc.nextLine();
		if(!vocaBook.containsKey(str)) {
		System.out.println(str+"은(는) 없는 단어입니다.");
		}else {
		vocaBook.remove(str);
		System.out.println("단어를 삭제했습니다.");
	}
	}

	private static void searchByMeaning() {
		String str = sc.nextLine();
		for(Entry<String, ArrayList<String>> s: vocaBook.entrySet()) {
			if(s.getValue().contains(str)) {
				System.out.println(": "+s.getKey());
				return;
			}
		}
		System.out.println("찾으시는 단어가 없습니다.");
		
	}


	private static void searchByWord() {
		String str = sc.nextLine();
		for(Entry<String, ArrayList<String>> s: vocaBook.entrySet()) {
			if(str.equals(s.getKey())) {
				System.out.println(": "+s.getValue());
				return;
			}
		}
		System.out.println("찾으시는 단어가 없습니다.");
		
	}

	private static void outputVocaBook() {
		System.out.println("★전체 단어장 출력★");
		for (String word : vocaBook.keySet()) {
			String key = word.toString();
			ArrayList<String>value = vocaBook.get(key);
			System.out.println(key +""+value.toString());
		}
		System.out.println();
	}
		
	

	private static void addNewWord() {
		System.out.println("단어를 입력해주세요>>>");
		String key = sc.nextLine();
		ArrayList<String> arr = new ArrayList<String>();
		boolean bool=true;
		while(bool) {
		System.out.println("뜻을 입력해주세요>>>(입력종료는 공백+엔터)");
		String value = sc.nextLine();
		if(value.equals("")||value.equals("")) {
			bool=false;
			break;
		}
		arr.add(value);
		vocaBook.put(key, arr);
	}

	}
	private static void WordsatOnce() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("사과");
		al.add("뉴욕");
		al.add("미국의 회사");
		vocaBook.put("apple", al);
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("enthusiastic");
		al1.add("passionate");
		vocaBook.put("fervid", al1);
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("a willingness to take bold risks");
		al2.add("showing a lack of respect");
		vocaBook.put("audacious", al2);
	}
	}
