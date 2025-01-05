package lee.treeset.ex2;

import java.util.Comparator;

import lee.compare.ex2.Student;

public class SortManager {

	public static Sortable getSortMethod(int num) {
		
		Sortable result = null;
		
		switch (num) {
		case 1:
			result=new AscendingByStuNo();
			break;
		case 2:
			result=new AscendingByStuName();
			break;
		case 3:
			result=new DescendingByStuScore();
			break;
	
			default:
				System.exit(0);
				break;
		}
		
		return result;
	}

	
}
