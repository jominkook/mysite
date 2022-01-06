package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.BoardVo;
import vo.PageMakeVo;



public class BoardDaoImpl implements BoardDao {
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
	public List<BoardVo> getlist() {		 
		 Connection conn = null;
		 Statement pstmt = null;
		 ResultSet rs = null;
		 List<BoardVo> list = new ArrayList<BoardVo>();
		 try {
			 conn = getConnection();
			 pstmt =conn.createStatement();
			 String sql = "SELECT b.\"NO\" ,b.TITLE ,b.CONTENT,b.HIT ,b.REG_DATE ,b.USER_NO ,u.NAME \r\n"
			 		+ "FROM USERS u ,BOARD b \r\n"
			 		+ "WHERE u.no = b.USER_NO \r\n"
			 		+ "ORDER BY  b.REG_DATE DESC";
			 //pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery(sql);
						
			 while(rs.next()) {
				BoardVo vo = new BoardVo();
				
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setReg_date(rs.getString("reg_date"));
				vo.setUser_no(rs.getInt("user_no"));
				vo.setUser_name(rs.getString("name"));
				list.add(vo);
			
				 
		      }
			 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		 return list;	
	}

	@Override
	public BoardVo getBoard(int bno) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 BoardVo vo = new BoardVo();
		 
				
		 try {
			 conn = getConnection();
			 String sql = "SELECT no, title, content, hit, user_no from board where no =?";
			 	
			 pstmt = conn.prepareStatement(sql);
			 //UserVo vo = new UserVo();
			 pstmt.setInt(1,  bno);			
			 rs = pstmt.executeQuery();			
			 
			while(rs.next()) {				
				 vo.setNo(rs.getInt("no"));
				 vo.setTitle(rs.getString("title"));
				 vo.setContent(rs.getString("content"));
				 vo.setHit(rs.getInt("hit"));
				 vo.setUser_no(rs.getInt("user_no"));
				 //System.out.println("성공");
				
				
			 }	 	
			System.out.println(vo.toString());
									 
		 }catch (SQLException e) {
			 System.err.println("ERROR:" + e.getMessage());
		 }
		 return vo;
	}

	@Override
	public boolean insert(BoardVo vo) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 int cnt = 0;	
		 try {
			 conn = getConnection();
			 String sql = "INSERT INTO BOARD(NO,TITLE,CONTENT,HIT,REG_DATE,USER_NO)"
					 +"VALUES(seq_board_no.nextval,?,?,?,sysdate,?)";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, vo.getTitle());
			 pstmt.setString(2, vo.getContent());
			 pstmt.setInt(3, vo.getHit());
			 //pstmt.setString(4, vo.getReg_date());
			 pstmt.setInt(4, vo.getUser_no());
			 cnt = pstmt.executeUpdate();
			
			
		 }catch (SQLException e) {	
		  System.err.println("ERROR:" + e.getMessage());
		 }
		 return cnt == 1;
	}

	@Override
	public boolean update(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
	    int cnt = 0;
		
	    try {
	    	conn = getConnection();
	 	    String sql = "UPDATE BOARD SET \r\n" +
	 	    		"TITLE = ?,CONTENT = ? \r\n" +
	 	    		"WHERE NO =?";
	 	    pstmt = conn.prepareStatement(sql);
	 	    pstmt.setString(1, vo.getTitle());
	 	    pstmt.setString(2, vo.getContent());
	 	    pstmt.setInt(3, vo.getNo());
	 	    cnt = pstmt.executeUpdate();
		
	    }catch (Exception e) {
	    	System.err.println("ERROR:" + e.getMessage());
	    }
	    return 1 == cnt;
	}
	@Override
	public boolean delete(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int cnt = 0;
		 try {
			 conn = getConnection();
			 String sql = "delete from board \r\n"+ 
					 "where no = ?";
	
			 pstmt = conn.prepareStatement(sql); 
			 pstmt.setInt(1, no);
		     cnt  = pstmt.executeUpdate();
		    			 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		 return cnt == 1;
	
	}
	@Override
	public boolean countHit(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;		
		try {
			 conn = getConnection();
			 String sql = "UPDATE BOARD SET hit = hit+1 \r\n"
			 		+ "WHERE NO = ?";	
			 pstmt = conn.prepareStatement(sql); 
			 int hitcount = 1;
			 pstmt.setInt(hitcount++, no);
		     cnt  = pstmt.executeUpdate();
		     //System.out.println("조회수 증가");
		    			 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		 return cnt == 1;
	
	}
	@Override
	public List<BoardVo> getlist(int page) {
		
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;		 
		 int startNum =(page-1)*10+1;
		 int endNum = page * 10;
		 
		 List<BoardVo> list = new ArrayList<BoardVo>();
		 try {
			 conn = getConnection();
			 String sql = "SELECT  rn , no, TITLE,CONTENT ,HIT, REG_DATE,user_no, name FROM(\r\n"
			 		+ 	  "SELECT rownum AS rn , b.NO as no ,b.TITLE ,b.CONTENT ,b.HIT ,REG_DATE,b.user_no as user_no ,u.NAME AS name\r\n"
			 		+ 	  "FROM BOARD b ,USERS u WHERE ROWNUM <=? \r\n"
			 		+     "AND b.USER_NO = u.no)\r\n"
			 		+     "WHERE rn >= ? \r\n"
			 		+     "ORDER BY REG_DATE DESC";
			 //pstmt =conn.createStatement();			 
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, endNum);
			 pstmt.setInt(2, startNum);
			 rs = pstmt.executeQuery();
			 System.out.println(rs.isBeforeFirst());
			 System.out.println(startNum);
			 System.out.println(endNum);
			 
			 while(rs.next()) {
				BoardVo vo = new BoardVo();	
				vo.setRn(rs.getInt("rn"));
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setReg_date(rs.getString("reg_date"));
				vo.setUser_no(rs.getInt("user_no"));
				vo.setUser_name(rs.getString("name"));
				
				list.add(vo);			
				 
		      }
			  
			 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		 return list;	
	}
	@Override
	public int getAllCount() {
		 Connection conn = null;
		 Statement pstmt = null;
		 ResultSet rs = null;
		 int cnt = 0;
		 try {
			 conn = getConnection();
			 pstmt =conn.createStatement();
			 String sql = "SELECT  count(*) AS count FROM BOARD";
			 //pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery(sql);
						
			 while(rs.next()) {
				cnt = rs.getInt("count");			
				 
		      }
			 
		 }catch (SQLException e) {
		  System.err.println("ERROR:" + e.getMessage());
		 }
		 return cnt;
	}
	
}
