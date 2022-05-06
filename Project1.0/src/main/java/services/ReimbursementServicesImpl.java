package services;

import java.util.List;

import DAO.ReimburesementDAO;
import DAO.ReimbursementDAOImpl;
import Models.Reimbursement;
import Models.ersUsers;

public class ReimbursementServicesImpl implements ReimbursementServices {

	ReimburesementDAO reimburesementDao = new ReimbursementDAOImpl();
	@Override
	public List<Reimbursement> listOfAllTicketsByAccount(ersUsers user) {
		// TODO Auto-generated method stub
		return reimburesementDao.listOfAllTicketsByAccount(user);
	}
	@Override
	public boolean insertTicket(Reimbursement reimb, ersUsers user) {

		return reimburesementDao.insertTicket(reimb, user);
		// TODO Auto-generated method stub
		
	}
	
	public List<Reimbursement> listOfAllTickets(){
		
		return reimburesementDao.listOfAllTickets(); 
	}
	
	public boolean updateTicket(Reimbursement reimb, ersUsers user) {
		
		return reimburesementDao.updateTicket(reimb, user);
		
	}
	
	public List<Reimbursement> filterByAccepted(Reimbursement reimb){
		
		return reimburesementDao.filterByAccepted(reimb);
		
	}
	@Override
	public List<Reimbursement> filterByDeclined() {
		// TODO Auto-generated method stub
		return reimburesementDao.filterByDeclined();
	}
	
	public List<Reimbursement> filterByPending(){
		
		
		return reimburesementDao.filterByPending();
	}

	
}
