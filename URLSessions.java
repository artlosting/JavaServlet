import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class URLSessions extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out  = resp.getWriter();
		HttpSession session = req.getSession(true);
		out.println("<html><head><title>Session追踪</title></head><body>"
		+"session id:"+session.getId()+"</br>"
		+"from url:" + req.isRequestedSessionIdFromURL()+"</br>"
		+"from cookie:" + req.isRequestedSessionIdFromCookie()+"</br>"
		+"<a href="+resp.encodeURL(req.getRequestURL().toString())+">test"+"</a>"+"</br>"
		+"</body></html>"		
				);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
