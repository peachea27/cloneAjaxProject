package lee.ex1.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteMain {

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
			int deptNo=310;
			PreparedStatement pstmt = null;
			String query ="delete from departments where department_id =?";
		
		try {
			
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, deptNo);
			int result = pstmt.executeUpdate();
			
			if(result==1)
			System.out.println("삭제 완료");
			
		}catch(SQLException e){
			
		}
			
			
		try {
		
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