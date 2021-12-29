package sec07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import sec07.BookVO;

public class BookDAO {
	private Connection con = null;
	DataSource dataSource = null;
	
	// 생성자에서 DB 연결 설정
	public BookDAO() {
		try {
			Context init = new InitialContext();
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DB 연결 성공");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	// 회원 정보 조회 메소드 (전체 회원 정보 SELECT 해서 반환 : MemberVO 반환)
	//MemberVO를 여러 행 반환 : ArrayList<MemberVO>
	public ArrayList<BookVO> bookSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		try {
			con = dataSource.getConnection();
			
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
				String pubnum = rs.getString("Pubnum");
				
				
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
	
	
public void bookInsert(BookVO vo){
		
		//sql문 values에 들어갈 데이터 설정
			
		try {
			con = dataSource.getConnection();
			
			String sql = "insert into book values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(0, vo.getNum());
			pstmt.setString(1, vo.getName()); 
			pstmt.setString(2, vo.getAuther()); 
			pstmt.setString(3,  vo.getPrice());
			pstmt.setString(4,  vo.getDate());
			pstmt.setString(5,  vo.getPubnum());
			
			// 쿼리문 실행 : 영향을 받은 행의 수 반환
			//select : executeQuery - 결과 행 resultSet 반환.
			//insert / update / delete : executeUpdate() - 영향을 받은 행의 수 반환
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("데이터 입력 성공!");
			}
			
			// 모든 객체 close() : 리소스 반납	
			pstmt.close();
			con.close();			
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}		
}
		
		public void bookDelete(String num) {
			
			try {
				con = dataSource.getConnection();
				
				String sql = "delete from book where bookNum=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, num); 
				
				// 쿼리문 실행 : 영향을 받은 행의 수 반환
				//select : executeQuery - 결과 행 resultSet 반환.
				//insert / update / delete : executeUpdate() - 영향을 받은 행의 수 반환
				int result = pstmt.executeUpdate();
				
				if(result > 0) {
					System.out.println("회원 정보 삭제 성공!");
				}
				
				// 모든 객체 close() : 리소스 반납	
				pstmt.close();
				con.close();			
				
			} catch (Exception e) {
				System.out.println("오류 발생!");
				e.printStackTrace();
			}		
		}
		
	}
	
	


