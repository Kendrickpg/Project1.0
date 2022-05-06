package frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MasterServlet", urlPatterns = {"/master/*", "/json/*", "/forwarding/*", "/redirecting/*", "/login/*" })
public class MasterServlet extends HttpServlet {
	
	
	public MasterServlet() {
		
	}
	
	////// make sure you're logged in before you even get in the dispatcher  
	protected boolean loggedIn(HttpServletRequest req) {
		if (req.getRequestURI().indexOf("/Project1.0/login/") ==-1 && req.getSession(false)==null)
			return false;
		else 
			return true; 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (loggedIn(req)) {
			Dispatcher.virtualRouter(req, resp);
		}else {
			resp.getWriter().println("Youre not logged in");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(loggedIn(req)) {
			Dispatcher.virtualRouter(req, resp);
		}else {
			resp.getWriter().println("Youre not logged in");
		}
	}
}