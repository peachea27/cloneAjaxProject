package lee.ex1.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectMain {

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
			System.out.println("조회할 이름 입력>>>");
			Scanner sc = new Scanner(System.in);
			String empName = sc.nextLine();
			/* (1)  실행할 쿼리문 준비*/
			String query ="select * from employees where FIRST_NAME like ?";
//			연습: 검색할 이름을 입력받아, 쿼리문에서 like 연산자를 이용해서 이름을 조회
			
			/* (2)Statement객체 : 쿼리문을 Connection객체가 연결하고 있는 DB서버로 전송하고 실행하는 역할을 하는 객체 */
//			Statement stmt =null;
			PreparedStatement pstmt =null;
			ResultSet rs =null;
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, "%"+empName+"%");
				
			/* (3)ResultSet객체 : 쿼리문이 실행된 후에 결과 테이블을 담고 있는 객체 */	
			rs = pstmt.executeQuery(); //쿼리문 실행, 결과 테이블을 ResultSet에 담는다
			System.out.println("rs:"+rs.next()); 
			
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
				if(e instanceof SQLSyntaxErrorException) {
					System.out.println("쿼리문 잘 짭시다!!!");
				}
			}
			
			
		try {
			rs.close();
			pstmt.close();
			conn.close();
			System.out.println("연결 끊기");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}

}
