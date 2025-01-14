package lee.ex1.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMain {

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
			int deptNo =290;
			String dName="개발부";
			int managerId =200;
			int locationId =1700;
			
			/* (1)  실행할 쿼리문 준비*/
//			String query ="insert into departments values("+deptNo+", '"+dName+"',"+managerId+","
//								+locationId+")";
			String query ="insert into departments values(?,?,?,?)";
//			System.out.println(query);
			/* (2)Statement객체 : 쿼리문을 Connection객체가 연결하고 있는 DB서버로 전송하고 실행하는 역할을 하는 객체 */
			PreparedStatement pstmt = null;
			try {
				pstmt= conn.prepareStatement(query);
				pstmt.setInt(1,deptNo);
				pstmt.setString(2, dName);
				pstmt.setInt(3, managerId);
				pstmt.setInt(4, locationId);
				
			/* (3)쿼리문 실행, 결과 */
				int result= pstmt.executeUpdate();
				
				if(result ==1) {
					System.out.println("저장완료");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			
		try {
			/* 커밋됨, 롤백불가 */
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
