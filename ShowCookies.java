import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ShowCookies extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=gb2312");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>获取客户端Cookie</title></head>"
				+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">"
				+ "title" + "</H1>\n" + "<TABLE BORDER=1 ALIGN=\"CENTER\">\n"
				+ "<TR BGCOLOR=\"#FFAD00\">\n" + "  <TH>Cookie Name\n"
				+ "  <TH>Cookie Value");
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			Cookie cookie = null;
			for(int i=0; i<cookies.length; i++) {
				cookie = cookies[i];
				out.print("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() +"</td></tr>");
			}
		}
		out.println("</table></body><>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
