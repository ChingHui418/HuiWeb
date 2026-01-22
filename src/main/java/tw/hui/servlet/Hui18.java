package tw.hui.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.hui.apis.Bike;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Hui18")
public class Hui18 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Hui19");
		
		
		request.setAttribute("age", 20);
		request.setAttribute("x", 10);
		request.setAttribute("y", 5);
		
		Bike bike = new Bike();
		bike.upSpeed().upSpeed().upSpeed().upSpeed();
		request.setAttribute("bike", bike);
		
		response.setContentType("text/html; charset=UTF=8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1> Hui Big Conpany </h1>");
		out.println("<hr />");
		out.println("<div> Hello, World </div>");
		out.println("<hr />");
//		dispatcher.include(request, response);
		dispatcher.forward(request, response);
		out.println("<hr />");
		
		response.flushBuffer();
	}

}
