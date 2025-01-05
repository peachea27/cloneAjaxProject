package ksy;

public class EmployeeMain {

	public static void main(String[] args) {
		// 어떤 부서에 2가지 형태의 사원이 근무한다고 하자.
//
//모든 사원은 사번, 이름, 소속 부서명, 급여를 가지고 있다.
//
//정규직 사원에게는 기본급을 지급하고, 
//
//알바직 사원에게는 급여 (= 근무시간 * 시급)를 지급한다.
//
//다형성과 상속관계를 이용해서 구현해보세요.
//
//IT부서에 있는 정규직 사원과 알바직 사원 리스트를 모두 출력하세요
		
		Department 아이티부서 = new Department(10, "IT");
		
//		1)Composition				
		아이티부서.addEmployee(new Permanent("24001", "강백호", 10, 2000000));//new Employee를 넣으면 추상클래스 생성이라..
//		아이티부서 = null;
//		아이티부서.outputEntireEmployees();
//		2)Aggregation
		Employee 채치수 = new Permanent("24002", "채치수", 10, 2000000);
		아이티부서.addEmployee(채치수);
//		아이티부서 = null;
//		아이티부서.outputEntireEmployees();
		System.out.println(채치수.toString());
//		1과 2의 차이? 아이티부서 = null로 부서를 없앴을 때 2는 남아있지만 1은 그렇지 않음 
		
		PartTimer 서태웅 = new PartTimer("24003", "서태웅", 10, 10, 10000);
		System.out.println(서태웅);
		
		아이티부서.outputEntireEmployees();
	}

}
