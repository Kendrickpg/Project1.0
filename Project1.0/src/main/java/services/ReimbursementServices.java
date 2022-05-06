package services;

import java.util.List;

import Models.Reimbursement;
import Models.ersUsers;

public interface ReimbursementServices {

	public List<Reimbursement> listOfAllTicketsByAccount (ersUsers user);
	
	public boolean insertTicket (Reimbursement reimb, ersUsers user);
	
	public List<Reimbursement> listOfAllTickets();
	
	public boolean updateTicket(Reimbursement reimb, ersUsers user);
	
	public List<Reimbursement> filterByAccepted(Reimbursement reimb);
	
	public List<Reimbursement> filterByDeclined();
	
	public List<Reimbursement> filterByPending();
	
}
