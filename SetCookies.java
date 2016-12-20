import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SetCookies extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for(int i=0; i<3; i++) {
			Cookie cookie = new Cookie("Session-Cookie" + i,"Value" + i);
			resp.addCookie(cookie);
			cookie = new Cookie("persistent-Cookie-"+i,"Cookie-Ｖalue-P"+i);
			cookie.setMaxAge(3600);
			resp.addCookie(cookie);
		}
		resp.setContentType("text/html;charset=gb2312");
		PrintWriter out = resp.getWriter();
		String title = "Setting Cookies";
		out.println("<html><head><title>设置Cookie</title></head>" + "<body gbcolor=\"pink\">" + "<h1 align=\"center\"></h1>" + 
		"<a href=\"ShowCookies\">ShowCookies</a>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
