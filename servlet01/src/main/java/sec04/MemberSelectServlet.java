package sec04;

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
@WebServlet("/memberSelect")
public class MemberSelectServlet extends HttpServlet {
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
		
		MemberDAO dao = new MemberDAO();
		
		ArrayList<MemberVO> memList = dao.memberSelect();
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='pink'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>" 
				+ "<td>이메일</td><td>가입일</td></tr>");
		
		for(int i=0; i<memList.size(); i++) {
			MemberVO vo = (MemberVO) memList.get(i);
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			Date joinDate = vo.getJoinDate();
			
			// 한 행씩 출력
			out.print("<tr><td>" + id + "</td><td>" +
												     pwd + "</td><td>" +
													 name + "</td><td>" +
												     email + "</td><td>" +
													 joinDate + "</td></tr>");
		}
		
		out.print("</table></body></html>");
	}

}
