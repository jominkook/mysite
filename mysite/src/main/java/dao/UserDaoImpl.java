package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import vo.UserVo;




public class UserDaoImpl implements UserDao {

	
	private Connection getConnection() throws  SQLException {
	    Connection conn = null;
	    try {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
	      conn = DriverManager.getConnection(dburl, "C##webdb", "1234");
	    } catch (ClassNotFoundException e) {
	      System.err.println("JDBC 드라이버 로드 실패!");
	    }
	    return conn;
	  }

	@Override
	public boolean insert(UserVo vo) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 int cnt = 0;	
		 try {
			 conn = getConnection();
			 String sql = "INSERT INTO USERS(NO,NAME,EMAIL,PASSWORD,GENDER)"+
					 "VALUES(SEQ_USERS_NO.NEXTVAL,?,?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, vo.getName());
			 pstmt.setString(2, vo.getEmail());
			 pstmt.setString(3, vo.getPassword());
			 pstmt.setString(4, vo.getGender());
			 cnt = pstmt.executeUpdate();
			
			
		 }catch (SQLException e) {	
		  System.err.println("ERROR:" + e.getMessage());
		 }
		 return cnt == 1;
	}


	@Override
	public void getUser(UserVo vo) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
				
		 try {
			 conn = getConnection();
			 String sql = "SELECT * FROM USERS where email=? and password=?";
			 //pstmt = conn.prepareStatement(sql);
			 pstmt = conn.prepareStatement(sql);
			 //UserVo vo = new UserVo();
			 pstmt.setString(1, vo.getEmail());
			 pstmt.setString(2, vo.getPassword());			
			 rs = pstmt.executeQuery();
			 
			 
			 if(rs.next()) {
				 if (rs.getString("email").equals(vo.getEmail()) && rs.getString("password").equals(vo.getPassword())) {
						System.out.println("로그인성공");
						 
						 int no = rs.getInt("no");
						 String name = rs.getString("name");
						 vo.setNo(no);
						 vo.setName(name);
											
				 }
				 else {
						System.out.println("실패");
				 }
				 
				 
			
				 
			 }	 	
				
									 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		
		 
	}

	@Override
	public void getlist(UserVo vo) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		
		 try {		
			 conn = getConnection();			 
			 String sql = "SELECT * FROM USERS where no=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, vo.getNo());
			 rs = pstmt.executeQuery(sql);
						
			 if(rs.next()) {
				 if (rs.getInt("no") == vo.getNo()) {					 				 
						 String name = rs.getString("name");
						 String password = rs.getString("password");
						 String gender = rs.getString("gender");
						 vo.setName(name);
						 vo.setPassword(password);
						 vo.setGender(gender);										
				 }
				 else {
						System.out.println("조회실패");
				 }
								 
			 }
				 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		
	}
	
			
							

	@Override
	public boolean update(UserVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
	    int cnt = 0;
		
	    try {
	    	conn = getConnection();
	 	    String sql = "UPDATE USERS SET " +
	 	    		"name=?, password = ?,gender=? " +
	 	    		"WHERE no=?";
	 	    pstmt = conn.prepareStatement(sql);
	 	    pstmt.setString(1, vo.getName());
	 	    pstmt.setString(2, vo.getPassword());
	 	    pstmt.setString(3, vo.getGender());
	 	    pstmt.setInt(4, vo.getNo());
	 	    cnt = pstmt.executeUpdate();
		
	    }catch (Exception e) {
	    	System.err.println("ERROR:" + e.getMessage());
	    }
	    return 1 == cnt;
	}
	
	
	
}
