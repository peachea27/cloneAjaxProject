package lee.hashmapex;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//저장
		map.put(1, "영우님");
		map.put(2, "다손님");
		map.put(3, "창현님");
		map.put(4, "현명님");
		map.put(5, "연화님");
		map.put(6, "진구님");
		map.put(7, "홍길동");//진구와 길동의 번호가 같으면 진구 대신 길동이 들어감
		map.put(6, "진구님");
		
		System.out.println(map);
		
		//탐색
		if(map.containsKey(7)) {
			System.out.println(map.get(7));
		}else {
			System.out.println("해당되는 값이 없습니다.");
		}
		 
		//map에 있는 모든 키
		Set<Integer> keys = map.keySet();
		
		for (Integer key : keys) {
			System.out.println(key);
		}
		
		//Map에 있는 모든 값
		Collection<String>values = map.values();
//		List<String> listvalues = map.values();//Type mismatch: cannot convert from Collection<String> to List<String>
		
		for (String value : values) {
			System.out.println(value);
		}
		
		System.out.println(map.isEmpty()); //false
		System.out.println(map.containsKey(10)); //false
		System.out.println(map.containsValue("둘리"));//false
		System.out.println(map.getOrDefault(7, "defaultValue")); //홍길동: 키에 해당하는 value반환
		System.out.println(map.getOrDefault(8, "defaultValue")); //defaultValue :키에 해당하는 value가 없으면 default반환
		System.out.println(map.putIfAbsent(8, "putIfAbsent"));//null: 8번 없으니까 null반환
		System.out.println(map.putIfAbsent(7, "putIfAbs"));
		System.out.println(map);//{1=영우님, 2=다손님, 3=창현님, 4=현명님, 5=연화님, 6=진구님, 7=홍길동, 8=putIfAbsent}//없는곳에 putifabsent들어감
		//있는곳은 있는 value반환하고 값을 update하지 않는다
		
		//수정
		map.replace(8, "replace");
		System.out.println(map);//{1=영우님, 2=다손님, 3=창현님, 4=현명님, 5=연화님, 6=진구님, 7=홍길동, 8=replace}
		
		map.replace(8, "replace","new repalce");
		System.out.println(map);//{1=영우님, 2=다손님, 3=창현님, 4=현명님, 5=연화님, 6=진구님, 7=홍길동, 8=new repalce}
		
		//삭제
		map.put(9, "value9");
		System.out.println(map);//{1=영우님, 2=다손님, 3=창현님, 4=현명님, 5=연화님, 6=진구님, 7=홍길동, 8=new repalce, 9=value9}
//		
		map.remove(9);
		System.out.println(map);//{1=영우님, 2=다손님, 3=창현님, 4=현명님, 5=연화님, 6=진구님, 7=홍길동, 8=new repalce}
//		
		map.put(10, "addToRemove");
		System.out.println(map);//{1=영우님, 2=다손님, 3=창현님, 4=현명님, 5=연화님, 6=진구님, 7=홍길동, 8=new repalce, 10=addToRemove}
		
		map.remove(10, "addToRemove");
		System.out.println(map);
		
		//맵생성 : key = 학번, value = 성적
		//5명 저장
		//총 학생 목록 출력
		//총점, 평균 출력
		
		Map<String,Integer> scoreMap = new HashMap<String, Integer>();
		scoreMap .put("20240731",100);
		scoreMap .put("20240732",90);
		scoreMap .put("20240733",10);
		scoreMap .put("20240734",70);
		scoreMap .put("20240730",50);
		
		//2)총 학생 목록 출력
		Set set = scoreMap.entrySet();
		 
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Integer> es = (Map.Entry) iter.next();
			System.out.println("학번:"+es.getKey()+", 성적 : "+es.getValue());
		}
		
		Set ks = scoreMap.keySet();
		System.out.println("학번만 출력 : "+ks);
		System.out.println("총 학생 수: "+ scoreMap.size());
		
		Collection values1 = scoreMap.values();
		System.out.println("성적만 출력: "+values1);
		System.out.println("총 학생 수: "+ scoreMap.size());
		//3)총점, 평균 출력
		int sum = 0;
		Iterator iter1 = values1.iterator();
		while(iter1.hasNext()) {
			int i = (Integer)iter1.next();
			sum += i;
		}
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (float)sum/scoreMap.size());
	}

}
