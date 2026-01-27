package tw.hui.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.hui.apis.Member;
import tw.hui.dao.MemberDAO;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF=8");
		
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		Member member = new Member();
		member.setEmail(email);
		member.setPasswd(passwd);
		member.setName(name);
		
		MemberDAO dao = new MemberDAO();
		
		try {
			Member dbMember = dao.findByEmail(email);
			if(dbMember == null) {
				if(dao.addMember(member)){
					response.sendRedirect("hui37.jsp");
				}else {
					response.sendRedirect("hui36.jsp?errType=2"); // 新增失敗
				}
			}else {
				response.sendRedirect("hui36.jsp?errType=1"); // 帳號重複
			}
		}catch(Exception e) {
			System.out.println(e);
			response.sendRedirect("hui36.jsp?errType=3");

		}
	}

}
