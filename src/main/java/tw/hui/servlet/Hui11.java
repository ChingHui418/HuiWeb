package tw.hui.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Hui11")
public class Hui11 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		System.out.println(account + ":" + passwd + ":" + gender);
		
		String[] hobby = request.getParameterValues("hobby");
		if (hobby != null) {
			System.out.println(hobby.length);
			for(String h: hobby)System.out.println(h);
		}
		System.out.println("---");
		String scale = request.getParameter("scale");
		System.out.println(scale);
		String color = request.getParameter("color");
		System.out.println(color);
		
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			doGet(request, response);
		}
}