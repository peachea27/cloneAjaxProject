package lee.ex2.preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementMain {
	/* statement쓴 다른 것들도 다 preparedstatement로 바꾸기 */
	public static void main(String[] args) {
		String id ="hr";
		String pwd ="1234"; 
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn =null;
		   
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결 성공:"+conn.toString());
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("DB에 연결하지 못했습니다.");
		}
		
		if(conn !=null) {
			beforeInsert(conn);
			
			int empNo = 104;
			String firstName ="vid";
			/*(1)쿼리문 준비(입력받은 값은 ?로 나타낸다)*/
//			String query ="select  *  from employees where employee_id = ?";
//			String query ="select  *  from employees where first_name like '%' || ? || '%' ";
			String query ="select  *  from employees where first_name like ?";
			
			/* like연산자를 이용해서 이름 검색 */
			
			/*(2)PreparedStatement 객체 준비 */
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt =conn.prepareStatement(query);
//				pstmt.setInt(1, empNo); /* 1번째 물음표에는 empNo값을 세팅 */
				pstmt.setString(1, "%"+firstName+"%"); /* 1번째 물음표에는 David 문자열을 세팅 */
				
				rs =pstmt.executeQuery();
				
				while(rs.next()) {
					/* 타입에 맞춰서 부가적인 처리를 해야할 수 있기 때문에 형식 맞추기 */
					System.out.println(rs.getInt("EMPLOYEE_ID") + " "
									+rs.getString("FIRST_NAME") + " "
									+rs.getString("LAST_NAME") + " "
									+rs.getString("EMAIL") + " "
									+rs.getString("PHONE_NUMBER") + " "
									+rs.getDate("HIRE_DATE") + " "
									+rs.getString("JOB_ID") + " "
									+rs.getFloat("SALARY") + " "
									+rs.getFloat("COMMISSION_PCT") + " "
									+rs.getInt("MANAGER_ID") + " "
									+rs.getInt("DEPARTMENT_ID") + " ");
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		try {
			rs.close();
			pstmt.close();
			conn.close();
			System.out.println("연결 끊기");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }

	}
	
	private static void beforeInsert(Connection con) {
		int deptNo =310;
		String dName="자재부";
		int managerId =104;
		int locationId =1800;
		
		if(con != null) {
			String query ="insert into departments values (?,?,?,?)";
			   
			PreparedStatement pstmt = null;
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, deptNo);
				pstmt.setString(2, dName);
				pstmt.setInt(3, managerId);				
				pstmt.setInt(4, locationId);
				
				int result = pstmt.executeUpdate();
				
				if(result == 1) {
					System.out.println("저장 성공");
				}
				/* 여기서 conn.close하면 안됨, 이 함수를 호출한 곳에서 마저 써야 한다 */
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/* <CONSOLE> */
//	연결 성공:oracle.jdbc.driver.T4CConnection@4f2410ac
//	저장 성공
//	105 David Austin DAUSTIN 590.423.4569 2005-06-25 IT_PROG 4800.0 0.0 103 60 
//	151 David Bernstein DBERNSTE 011.44.1344.345268 2005-03-24 SA_REP 9500.0 0.25 145 80 
//	165 David Lee DLEE 011.44.1346.529268 2008-02-23 SA_REP 6800.0 0.1 147 80 
//	연결 끊기

}
