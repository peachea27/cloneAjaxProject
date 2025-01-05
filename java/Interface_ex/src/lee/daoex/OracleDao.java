package lee.daoex;

public class OracleDao implements DataAccessObject {

	@Override
	public void select() {

		System.out.println("Oracle DB조회");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Oracle DB저장");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Oracle DB수정");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Oracle DB삭제");
	}

}
