package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import Models.ersUsers;
import services.ErsUsersServices;

public class LoginController {
	
	public static ersUsers login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String path = null;
			
			if (!req.getMethod().equals("POST")) {
				path = "/index.html";
				req.getRequestDispatcher(path).forward(req, resp);
				
			}
			
			ersUsers user = new ersUsers();
			
			////getting the information from the HTML using req.getParameters 
			user.setEmployeeUser(req.getParameter("myUsername"));
			user.setEmployeePassw(req.getParameter("myPassword"));
			
			System.out.println(user.getEmployeeUser() + user.getEmployeePassw());
			
			///login Verifcation is true we go inside the loop
			if (ErsUsersServices.loginVerfication(user)) {
				
				ersUsers currentUser = ErsUsersServices.storeUserSession(user);
				req.getSession().setAttribute("loggedInUser", currentUser);
				System.out.println(currentUser.getEmployeeRole());
				if (currentUser.getEmployeeRole()==1) {
				path = "/forwarding/home";
				} else {
					path = "/forwarding/finHome";
					System.out.println("finance man");
				}
				System.out.println("Login good");
				req.getRequestDispatcher(path).forward(req, resp);
				System.out.println(req.getSession(false));
				
			}else {
				path="/login/badlogin";
				System.out.println("badLogin");
				req.getRequestDispatcher(path).forward(req, resp);
			}
			return user;
			
	}

	public static void logOut(HttpServletRequest req, HttpServletResponse resp ) throws IOException, ServletException {
		//to get the session code
		HttpSession session = req.getSession();

		//using this method to log out 
		session.invalidate();
		System.out.println("session invalidated");
		

		
		String path = "/index.html";
		req.getRequestDispatcher(path).forward(req, resp);;
		
	}
	
	public static void getCurrentUser (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("in the method of getCurrentUser");
		///////gets the current user from the session we created upon logging in 
		ersUsers currentUser = (ersUsers)req.getSession().getAttribute("loggedInUser");
		
		//////// writes it as a JSON and sends it to the method that calls it 
		PrintWriter printer = resp.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(currentUser) );
		System.out.println("sending currentUser");
		
	}
}
