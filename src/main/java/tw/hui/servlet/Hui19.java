package tw.hui.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.hui.apis.Bike;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Hui19")
public class Hui19 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Bike bike = (Bike)request.getAttribute("bike");
		
		
		PrintWriter out = response.getWriter();
		out.println("I am Hui9<hr />");
		out.println(bike);
		
		response.flushBuffer();
	}

}
