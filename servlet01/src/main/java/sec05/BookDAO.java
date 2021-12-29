package sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BookDAO {
	// DB 연결 담당 메소드 : DB 연결하고 Connection 객체 반환
	private Connection connDB() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/book?serverTimezone=UTC";
			String user = "root";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, user, pwd);
			
			if(con != null) {
				System.out.println("DB 연결 성공!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;		
	}
	
	// 회원 정보 조회 메소드 (전체 회원 정보 SELECT 해서 반환 : MemberVO 반환)
	//MemberVO를 여러 행 반환 : ArrayList<MemberVO>
	public ArrayList<BookVO> bookSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		try {
			con = connDB();
			
			String query = "select * from book";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // 결과 세트에서 한 행씩 처리
				// 한 행(회원 1명당) 처리 
				String num = rs.getString("bookNum");
				String name = rs.getString("bookName");
				String auther = rs.getString("bookAuther");
				String price = rs.getString("bookPrice");
				String date = rs.getString("bookDate");
				String pubnum = rs.getString("pubNum");
				
				// 한 행 정보 가져와서 MemberVO에 저장 : setter 메소드 사용
				BookVO vo = new BookVO();
				vo.setNum(num);
				vo.setName(name);
				vo.setAuther(auther);
				vo.setPrice(price);
				vo.setDate(date);
				vo.setPubnum(pubnum);
				
				// 각 MemberVO를 ArrayList에 추가(저장)
				bookList.add(vo);				
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				pstmt.close();
				con.close();				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return bookList;		
	}
	
}


