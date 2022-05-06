package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Models.Reimbursement;
import Models.ersUsers;
import services.ReimbursementServices;
import services.ReimbursementServicesImpl;

public class employeeController {

	static ReimbursementServices reimbursementServices = new ReimbursementServicesImpl();
	
	
	
	///////////////EMPLOYEEEEE
	
	/////Controller method 
	public static void seeAllTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		

		ersUsers currentUser = (ersUsers)req.getSession().getAttribute("loggedInUser");
		List <Reimbursement> allTickets = new ArrayList<>();
		
		////////this updates the ArrayList, with the returned List from the DAO 
		allTickets = reimbursementServices.listOfAllTicketsByAccount(currentUser);
		
		System.out.println(allTickets);
		
		/// Objectmapper converts ArrayList allTickets to a String
		String JSON = new ObjectMapper().writeValueAsString(allTickets);
		System.out.println("string version of list: " + JSON);
		
		///here we are preparing a resp setting its content type and sending a JSON
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();
		printer.write(JSON);
		
		// a lil reminder to keep going
		System.out.println("KEEP IT GOING");

	}
	
	
	public static void insertTicket (HttpServletRequest req, HttpServletResponse resp) throws StreamReadException, DatabindException, IOException {
		ersUsers currentUser = (ersUsers)req.getSession().getAttribute("loggedInUser");
		ObjectMapper mapper = new ObjectMapper();
		
		/// here we are receiving by Requesting and reading it with getInputStream a JSON from javascript and we're casting it to a Class
		Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		System.out.println(reimb);
		System.out.println("taking you to the services");
		
		reimbursementServices.insertTicket(reimb, currentUser);

	}
	
	
	////////////FINANCIAL MANAGER
	
	public static void finSeeAllTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		ersUsers currentUser = (ersUsers)req.getSession().getAttribute("loggedInUser");
		List <Reimbursement> allTickets = new ArrayList<>();
		allTickets = reimbursementServices.listOfAllTickets();
		
		System.out.println(allTickets);
		String JSON = new ObjectMapper().writeValueAsString(allTickets);
		System.out.println("string version of list: " + JSON);
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();
		printer.write(JSON);
		System.out.println("All tickets");
	
	}
	
	public static void finUpdating(HttpServletRequest req, HttpServletResponse resp) throws StreamReadException, DatabindException, IOException {
		ersUsers currentUser = (ersUsers)req.getSession().getAttribute("loggedInUser");
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		System.out.println(reimb);
		
		System.out.println("taking you to update ticket");
		reimbursementServices.updateTicket(reimb,currentUser);
	}
	
	
	public static void filterByAccepted(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("taking to you filer by status accepted");
		List <Reimbursement> allTicketsAccepted = new ArrayList<>();
		
		allTicketsAccepted= reimbursementServices.filterByAccepted(null);
		
		String JSON = new ObjectMapper().writeValueAsString(allTicketsAccepted);
		System.out.println("string version of list: " + JSON);
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();
		printer.write(JSON);
		System.out.println("All tickets Accepted");
	
	}
	
	public static void filterByDeclined(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("taking to you filer by status declined");
		List <Reimbursement> allTicketsDeclined = new ArrayList<>();
		
		allTicketsDeclined= reimbursementServices.filterByDeclined();
		
		String JSON = new ObjectMapper().writeValueAsString(allTicketsDeclined);
		System.out.println("string version of list: " + JSON);
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();
		printer.write(JSON);
		System.out.println("All tickets Declined");
	
	}
	
	public static void filterByPending(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("taking to you filer by status declined");
		List <Reimbursement> allTicketsPending = new ArrayList<>();
		
		allTicketsPending= reimbursementServices.filterByPending();
		
		String JSON = new ObjectMapper().writeValueAsString(allTicketsPending);
		System.out.println("string version of list: " + JSON);
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();
		printer.write(JSON);
		System.out.println("All tickets Declined");
		
	}

}
