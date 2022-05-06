package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Reimbursement;
import Models.customConnection;
import Models.ersUsers;

public class ReimbursementDAOImpl implements ReimburesementDAO {

	static { //(this would normally go into your dao layer)
	      try {
	          Class.forName("org.postgresql.Driver");
	      }catch(ClassNotFoundException e) {
	          e.printStackTrace();
	          System.out.println("Static block has failed me");
	      }
	}
	
	public static void main (String[] args) {
//		ReimbursementDAOImpl rDAo = new ReimbursementDAOImpl();
		
//
//		Date sqlDate = new Date();
////		
//		sqlDate=new java.sql.Date(sqlDate.getTime());
//		
//		rDAo.insertTicket(new Reimbursement(75,(java.sql.Date) sqlDate,5,1,2));
		
//		rDAo.updateTicket(new Reimbursement((java.sql.Date) sqlDate , 6, 3, 6));
		
//		System.out.println(rDAo.listOfAllTickets());
		
		
		////////////// WORKING ON DAO WHILE WE WAIT FOR AJAX 
		////////////// also ask if you can pass anything thru servlets or forwarding 
		
	}
	
	/////////////////////////EMPLOYEES SECTION
	@Override
	public List<Reimbursement> listOfAllTicketsByAccount(ersUsers user) {
		List <Reimbursement> targetedList = new ArrayList<>();
		
		try(Connection conn = customConnection.getConnection()){
			user.getEmployeeID();
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getEmployeeID());
			
			ResultSet rs = ps.executeQuery();
			System.out.println(user.getEmployeeID());
			while (rs.next()) {
				targetedList.add(new Reimbursement(rs.getInt(1),rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getString(5)
									, rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),rs.getInt(10)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targetedList;
	}
	
	
	public boolean insertTicket (Reimbursement reimb, ersUsers user) {
		Date sqlDate = new Date();		
		sqlDate=new java.sql.Date(sqlDate.getTime());
		
		try(Connection conn = customConnection.getConnection()){
			String sql = "INSERT INTO ers_reimbursement VALUES (DEFAULT, " + reimb.getReinbursementAmount() +", '"+ sqlDate + "', NULL, '"+ reimb.getReinbursementDesc() + "', NULL, "+ user.getEmployeeID() + ",NULL," + reimb.getReinbursementStatusId() + ","+ reimb.getReinbursementTypeId()+ ")";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int numOfRows = ps.executeUpdate();
			
			if(numOfRows == 1) {
				System.out.println("ticket addded");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	//////////////////////////FINACIAL MANAGER SECTION
	
	public List<Reimbursement> listOfAllTickets(){
		ArrayList<Reimbursement> targetedList = new ArrayList<>();
		
		try (Connection conn = customConnection.getConnection()){
			String sql = "SELECT * FROM ers_reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				targetedList.add(new Reimbursement(rs.getInt(1),rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getString(5)
									, rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),rs.getInt(10)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return targetedList;
		
	}
	
	public boolean updateTicket(Reimbursement reimb, ersUsers user) {
		Date sqlDate = new Date();		
		sqlDate=new java.sql.Date(sqlDate.getTime());
		
		try (Connection conn = customConnection.getConnection()){
			String sql = "UPDATE ers_reimbursement SET reimb_resolved = '" + sqlDate + "' , reimb_resolver = "+ user.getEmployeeID()  +", reimb_status_id = "+ reimb.getReinbursementStatusId() + " WHERE reimb_id =" + reimb.getReinbursementId() + " ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int numOfRows = ps.executeUpdate();
			
			if(numOfRows == 1) {		
				System.out.println("Ticket Updated");
				return true; 	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
	public List<Reimbursement> filterByAccepted(Reimbursement reimb){
		
		ArrayList<Reimbursement> targetList = new ArrayList<>();
		
		try(Connection conn = customConnection.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 2";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				targetList.add(new Reimbursement(rs.getInt(1),rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getString(5)
									, rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),rs.getInt(10)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return targetList;
		
		
	}

	@Override
	public List<Reimbursement> filterByDeclined() {

		ArrayList<Reimbursement> targetList = new ArrayList<>();
		
		try(Connection conn = customConnection.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 3";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				targetList.add(new Reimbursement(rs.getInt(1),rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getString(5)
									, rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),rs.getInt(10)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return targetList;
	}

	@Override
	public List<Reimbursement> filterByPending() {
ArrayList<Reimbursement> targetList = new ArrayList<>();
		
		try(Connection conn = customConnection.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				targetList.add(new Reimbursement(rs.getInt(1),rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getString(5)
									, rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),rs.getInt(10)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return targetList;
	}

}
