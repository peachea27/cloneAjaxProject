package lee.hashmap.ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Vocaksy {
	public static Scanner sc = new Scanner(System.in);
	public static Map<String, ArrayList<String>> vocaBook = new HashMap<String, ArrayList<String>>();
	
	public static void main(String[] args) {
		
		addWord("apple","사과");
		addWord("apple","회사");
		addWord("apple","뉴욕");
		addWord("bat","야구방망이");
		addWord("bat","박쥐");
		addWord("watch","보다");
		addWord("watch","손목시계");
		//메뉴 출력
		outputMenu();
		
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
		
		int menu=0;//아래의 메뉴와 떨어졌으니 =0로 이니셜라이즈해줘야함, 지역변수?
		try {
//			menu=sc.nextInt();// &&InputMismatchException e && sc.nextLine(); 하면 continue없이 됨
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("잘못입력하셨습니다. 메뉴번호를 확인하고 다시 입력해 주세요.");
			continue;//메뉴 번호를 다시 입력받도록 반복문 진행.
		}
//		sc.nextLine();
		
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
	
		case 9:
			System.exit(0);
			break;

		default:
			System.out.println("번호를 잘못 입력하셨습니다.");
			break;
		}
		

	
}
	
}
private static void deleteWord() {
	System.out.println("삭제할 단어 입력>>>");
	String wordtoDelete = sc.nextLine();
	vocaBook.remove(wordtoDelete);
}
private static void searchByMeaning() {
	// 뜻 -> 단어
	System.out.println("조회할 뜻을 입력>>>");
	String meaning =sc.nextLine();
	
	System.out.println("-------" + meaning + " 뜻을 가진 단어를 검색 ------");
	
	boolean isFind = false;
	
	for(Map.Entry<String, ArrayList<String>> entry :vocaBook.entrySet()) {
		String word = entry.getKey();
		ArrayList<String>meanings =entry.getValue();
		if(meanings.contains(meaning)){
			//뜻을 찾은 경우
			isFind = true;
			System.out.println(word);
		}
		
	}
	
	if(!isFind) System.out.println("그런 뜻을 가진 단어는 없습니다......");//이렇게 간단할 땐 대괄호 안해도됨
		
	
}
private static void searchByWord() {
	// 단어->뜻
	System.out.println("조회할 단어 입력>>>");
	String wordToSearch = sc.nextLine();
	System.out.println("---------"+wordToSearch+"의 뜻을 검색합니다.");
	ArrayList<String> meanings = vocaBook.get(wordToSearch);
	if ( meanings != null) {
		System.out.println(meanings);
	}else {
		System.out.println("뜻이 없습니다.....");
	}

}
private static void outputVocaBook() {
	//단어장 출력
	Set<String>words = vocaBook.keySet();
	
//	for (String word : words) {
//		//뜻 가져오기
//		List<String>meanings =vocaBook.get(word);
//		for (String meaning : meanings) {
//			System.out.println(" "+meaning);
//		}
//		System.out.println();
//	}
	
	//Map.Entry 사용
	for (Map.Entry<String, ArrayList<String>> entry : vocaBook.entrySet()) {
		String word = entry.getKey();
		ArrayList<String> meaning = entry.getValue();
		System.out.println(word + " : "+meaning);
	}
}
private static void addNewWord() {
	System.out.println("영어단어를 입력하세요>>>");
	String newWord = sc.nextLine();
	
	while(true) {
		System.out.println("뜻을 입력하세요(모두 입력 후에는 q를 입력)");
		
		String newMeaning = sc.nextLine();
		if (newMeaning.equals("q")) {
			break;
		}else {
			addWord(newWord,newMeaning);
		}
	}
	
}
private static void addWord(String word, String meaning) {
	if(vocaBook.containsKey(word)) {
		// 단어장에 단어가 존재하는 경우
		vocaBook.get(word).add(meaning); // 뜻 배열에 새로운 뜻을 추가
	}else {
		//단어장에 단어가 없는 경우
		ArrayList<String> meanings = new ArrayList<String>();
		meanings.add(meaning);
		vocaBook.put(word, meanings);
	}
		
}


	}



