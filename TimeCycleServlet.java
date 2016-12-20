import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TimeCycleServlet extends HttpServlet {
	@Override
	public void destroy() {
		System.out.println("destroy...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init--");
	}

	public TimeCycleServlet() {
		System.out.println("Constructor");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	

	
}
