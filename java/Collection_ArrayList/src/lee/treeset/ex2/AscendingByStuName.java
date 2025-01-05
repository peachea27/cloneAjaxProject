package lee.treeset.ex2;

public class AscendingByStuName implements Sortable {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
