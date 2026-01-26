package tw.hui.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.hui.apis.Member;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Hui22")
public class Hui22 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("hui21.html");
		}
		
		Member member = (Member)session.getAttribute("member");
		if(member == null) {
			response.sendRedirect("hui21.html");	
		}
		Integer lottery = (Integer)session.getAttribute("lottery");
		int[] ary = (int[])session.getAttribute("ary");
		
		out.print("<h1> Main Page</h1> <hr />");
		out.print(String.format("Welcome, %s：%s<br />",
				member.getName(), member.getEmail()));
		
		out.print(String.format("<div>Lottery: %d</div>", lottery));
		for(int v : ary) {
			out.print(String.format("<div>%d</div>", v));
		}
		
		out.print("<hr /><a href='Hui23'>Logout</a>");
		
		response.flushBuffer();
	}

}
