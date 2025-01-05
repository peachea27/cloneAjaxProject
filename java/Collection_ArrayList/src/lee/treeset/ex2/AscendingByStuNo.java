package lee.treeset.ex2;

public class AscendingByStuNo implements Sortable {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getStuNo().compareTo(o2.getStuNo());
	}

}
