package sec05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberSelectServlet
 */
@WebServlet("/bookSelect")
public class BookSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		BookDAO dao = new BookDAO();
		
		ArrayList<BookVO> bookList = dao.bookSelect();
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='pink'>");
		out.print("<td>도서번호</td><td>도서명</td><td>저자</td>" 
				+ "<td>가격</td><td>발행일</td><td>출판사번호</td></tr>");
		
		for(int i=0; i<bookList.size(); i++) {
			BookVO vo = (BookVO) bookList.get(i);
			String num = vo.getNum();
			String name = vo.getName();
			String auther = vo.getAuther();
			String price = vo.getPrice();
			String date = vo.getDate();
			String pubnum = vo.getPubnum();
			
			
			// 한 행씩 출력
			out.print("<tr><td>" + num + "</td><td>" +
												     name + "</td><td>" +
													 auther + "</td><td>" +
												     price + "</td><td>" +
													 date + "</td><td>"+
												     pubnum+"</td></tr>"
												     
													 );
		}
		
		out.print("</table></body></html>");
	}

}
