package tw.hui.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@MultipartConfig(
	location = "C:\\Users\\a0985\\eclipse-workspace\\HuiWeb\\src\\main\\webapp\\upload"
		)
@WebServlet("/Hui13")
public class Hui13 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String urip = request.getRemoteAddr();
		
		String account = request.getParameter("account");
		System.out.println(account);
		Collection<Part> parts = request.getParts();
		for(Part part: parts) {
			String type = part.getContentType();
		 	String name = part.getName();
		 	String sname = part.getSubmittedFileName();
		 	long size = part.getSize();
		 	System.out.printf("%s:%s:%s:%d\n", type, name, sname, size);
		 	
		 	String filename = String.format("%s_%s", account, sname);
		 	if(name.equals("upload") && size > 0 ) {
		 		part.write(filename);
		 		// part.getInputStream();
		 	}
		 	
		}
		
		response.setContentType("text/html; charset=UTF=8");
		PrintWriter out = response.getWriter();
		
		response.flushBuffer();
	}

}
