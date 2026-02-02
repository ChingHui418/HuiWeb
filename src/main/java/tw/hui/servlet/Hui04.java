package tw.hui.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/public/Hui04")
public class Hui04 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		// response.getWriter().append("<h1>Server at</h1>: ").append(request.getContextPath());
	
		System.out.println("Hello, World1");
		
		PrintWriter out = response.getWriter();
		out.println("Hello, World2");
	}

}
