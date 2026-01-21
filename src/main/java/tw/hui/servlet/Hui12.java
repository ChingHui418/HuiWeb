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

@MultipartConfig(
	location = "C:\\Users\\a0985\\eclipse-workspace\\HuiWeb\\src\\main\\webapp\\upload"
		)
@WebServlet("/Hui12")
public class Hui12 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		
		Part part = request.getPart("upload");
		
		String name = part.getName();
		String sname = part.getSubmittedFileName();
		long len = part.getSize();
		System.out.printf("%s:%s:%d", name, sname, len);
		if(len >0) {
			part.write(sname);
		}
		
		
		response.setContentType("text/html; charset=UTF=8");
		PrintWriter out = response.getWriter();
		
		response.flushBuffer();
	}

}
