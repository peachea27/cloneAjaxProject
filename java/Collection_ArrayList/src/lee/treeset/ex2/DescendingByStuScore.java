package lee.treeset.ex2;

public class DescendingByStuScore implements Sortable {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getScore() < o2.getScore()) {
		return 1;
		}else if (o1.getScore()==o2.getScore()) {
			return 0;
		}else {
			return -1;
		}
		//OR 이런방법
//		return (Integer.compare(o1.getScore(), o2.getScore()))*-1;
	}

}
