package tw.hui.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Hui16")
public class Hui16 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Hui17?age=26");
		
		
		response.setContentType("text/html; charset=UTF=8");
		PrintWriter out = response.getWriter();
		
		request.setAttribute("age", 20);
		request.setAttribute("x", 10);
		request.setAttribute("y", 5);
		
		out.println("<h1> Hui Big Conpany </h1>");
		out.println("<hr />");
		out.println("<div> Hello, World </div>");
		out.println("<hr />");
		dispatcher.include(request, response);
		out.println("<hr />");
		
		response.flushBuffer();
	}

}
