package tw.hui.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Hui09")
public class Hui09 extends HttpServlet {
   
    public Hui09() {
        super();
        System.out.println("Hui09");
    }
 
//    @Override
//    public void init() throws ServletException {
//    	System.out.println("init()");
//    	super.init();
//    }
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init(config)");
//		super.init(config);
//	}

//    @Override
//    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//    	System.out.println("service(2)");
//    	super.service(arg0, arg1);
//    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service(1)");
		// super.service(arg0, arg1);
		
		String method = req.getMethod();
		System.out.println(method);
	}





	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Hui09:doGet()");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Hui09:doPost()");
	}

}
