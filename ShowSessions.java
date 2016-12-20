import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ShowSessions extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=gb2312");
		PrintWriter out = resp.getWriter();
		String head = null;
		//判断服务器有没有session
		HttpSession session = req.getSession(true);
		
		Integer accessCount = (Integer) session.getAttribute("accessCount");
		if(accessCount == null) {
			accessCount = new Integer(0);
			head = "Welcome, Newcomer";
		} else {
			head = "Welcome To Back";
			accessCount = new Integer(accessCount.intValue() + 1);
		}
		session.setAttribute("accessCount", accessCount);
		
		out.println("<html><head><title>Session追踪</title></head><body bgcolor=\"pink\"><table style=\"border:1px solid red;align=center;font-color:blue;\">"
				+ "<tr border=1px><td>id</td><td>" + session.getId() + "</td></tr>"
				
				+ "<tr border=1px><td>"+"创立时间"+ "</td><td>" + new Date(session.getCreationTime()) + "</td></tr>"
				+ "<tr border=1px><td>"+"最后一次访问时间" + "</td><td>" + new Date(session.getLastAccessedTime())+ "</td></tr>"
				+ "<tr border=1px><td>"+"第几次访问" + "</td><td>" + accessCount + "</td></tr>"
				+ "</table></body></html>");
		
		
			
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
