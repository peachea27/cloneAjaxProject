package lee.hashmap.ex1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HashMapExMain {

	public static void main(String[] args) {
		// 같은 단어가 횟수
		String words ="Hash table based implementation of the Map interface based Map Hash Map";
		
		String wordsLower = words.toLowerCase();
		System.out.println(wordsLower);
		
		String[] arr = wordsLower.split(" ");
		System.out.println(Arrays.toString(arr));

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for ( int i = 0; i < arr.length; i++) {
			if ( !map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		System.out.println(map);
		
		//또는
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		for ( String word : arr) {
			map1.put(word, map1.getOrDefault(word, 0)+1);
		}
		System.out.println(map1);
		
		//출력
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry entry= (Map.Entry)iter.next();
			int value = (int)entry.getValue();
			System.out.println(entry.getKey()+ ": "+value);
		}
		
		//treeMap을 이용해서 정렬
		TreeMap<String, Integer>tmap = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		tmap.putAll(map);
		//treeMap도 Map처럼 쓰면 됨
		System.out.println(tmap);
		Iterator titer = map.entrySet().iterator();
		while(titer.hasNext()) {
			Map.Entry entry= (Map.Entry)titer.next();
			int value = (int)entry.getValue();
			System.out.println(entry.getKey()+ ": "+value);
		}
		
	
	}
}
