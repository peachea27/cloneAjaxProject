package lee.daoex;

public class MysqlDao implements DataAccessObject{

	@Override
	public void select() {
		System.out.println("MySQL DB조회");
		
	}

	@Override
	public void insert() {
		System.out.println("MySQL DB저장");
		
	}

	@Override
	public void update() {
		System.out.println("MySQL DB수정");
		
	}

	@Override
	public void delete() {
		System.out.println("MySQL DB삭제");
		
	}

}
