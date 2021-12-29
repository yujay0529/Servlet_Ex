package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/bookInsert")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	// 클라이언트이 <form>태그를 통해 데이터 전달 받아서 콘솔창에 출력
	// request : 클라이언트 --> 서버
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 데이터 인코딩 
		request.setCharacterEncoding("utf-8");
		
		// <form> 태그 안에 입력된 데이터 받아오기
		String num = request.getParameter("book_num");
		String name = request.getParameter("book_name");
		String auther = request.getParameter("book_auther");
		String price = request.getParameter("book_price");
		String year = request.getParameter("book_year");
		String month = request.getParameter("book_month");
		String date = request.getParameter("book_date");
		String stock = request.getParameter("book_stock");
		String pub_num = request.getParameter("pub_num");


		System.out.println("도서번호 : " + num);
		System.out.println("도서명 : " + name);
		System.out.println("저자 : " + auther);
		System.out.println("가격 : " + price);
		System.out.println("발행일 : "  + year+"-"+month+"-"+date);
		System.out.println("재고 : " + stock);
		System.out.println("출판사번호 : " + pub_num);
		
	}

}


