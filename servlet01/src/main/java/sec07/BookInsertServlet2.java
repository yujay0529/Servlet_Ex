package sec07;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/bookInsert2")
public class BookInsertServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 받으면서 데이터 전달 받음
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("bookNum");
		String name = request.getParameter("bookName");
		String auther = request.getParameter("bookAuther"); 
		String price = request.getParameter("bookPrice");
		String date = request.getParameter("bookDate");
		String pubnum = request.getParameter("Pubnum");
		
		// MemberVO에 저장
		BookVO vo = new BookVO();
		vo.setNum(num);
		vo.setName(name);
		vo.setAuther(auther);
		vo.setPrice(price);
		vo.setDate(date);
		vo.setPubnum(pubnum);
		
		// 또는 생성자 사용
		//MemberVO vo = new MemberVO(id, pwd, name, email);
		
		// 회원 정보 등록 : memberInsert() 호출  -> DB에 저장
		BookDAO dao = new BookDAO();
		dao.bookInsert(vo);		
	}

}