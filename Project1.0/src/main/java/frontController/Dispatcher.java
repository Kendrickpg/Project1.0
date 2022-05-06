package frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controllers.LoginController;
import Controllers.employeeController;
import Models.ersUsers;

public class Dispatcher {

	/////Dispatcher to take care of all the URI
	public static void virtualRouter (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ersUsers activeUser = new ersUsers();
		
		System.out.println("in the dispatcher");
		
		//endpoints for the servlets 
		switch(req.getRequestURI()) {
			case "/Project1.0/login/login":
			      System.out.println("Taking you to login");
			      activeUser = LoginController.login(req, resp);
			      break;
			      
			case "/Project1.0/forwarding/home":
				 System.out.println("Taking you to the home page");
				 String path = "/resources/html/home.html";
				 req.getRequestDispatcher(path).forward(req, resp);
				 break;
			case "/Project1.0/login/badlogin":
				 System.out.println("Bad log in dude");
				 path = "/resources/html/badlogin.html";
				 req.getRequestDispatcher(path).forward(req, resp);		
				 break;
			case "/Project1.0/login/logout":
				 System.out.println("Logging you out");
				 LoginController.logOut(req, resp);
				 break;
				 
			case "/Project1.0/forwarding/seeAllTickets":
				 System.out.println("Seeing all tickets");
				 employeeController.seeAllTickets(req, resp);
				 break;
				 
			case "/Project1.0/forwarding/insertTicket":
				System.out.println("Inserting a ticket");
				employeeController.insertTicket(req, resp);
				break;
				
			case "/Project1.0/forwarding/finSeeAllTickets":
				System.out.println("Financial Manager: Seeing all tickets");
				employeeController.finSeeAllTickets(req, resp);
				break;
				
			case "/Project1.0/forwarding/updatingTicket":
				System.out.println("dispatcher: update");
				employeeController.finUpdating(req, resp);
				break;
				
			case "/Project1.0/forwarding/filterByAccepted":
				System.out.println("dispatcher: accepted");
				employeeController.filterByAccepted(req, resp);
				break;
				
			case "/Project1.0/forwarding/filterByDenied":
				 System.out.println("dispatcher: DECLINED");
				 employeeController.filterByDeclined(req, resp);
				 break;
				
			case "/Project1.0/forwarding/filterByPending":
				 System.out.println("dispatcher: DECLINED");
				 employeeController.filterByPending(req, resp);
				 break;
				 
			case "/Project1.0/json/getCurrentUserObject":
				System.out.println("getting user");
				LoginController.getCurrentUser(req, resp);
				break;
			case "/Project1.0/forwarding/finHome":
				 System.out.println("Taking you to the home page");
				 String path1 = "/resources/html/finHome.html";
				 req.getRequestDispatcher(path1).forward(req, resp);
				 break;
				
			default: System.out.println("No URI found");
					 break;
		}
		
	}
}
