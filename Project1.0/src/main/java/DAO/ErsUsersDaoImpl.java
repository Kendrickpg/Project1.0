package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.customConnection;
import Models.ersUsers;

public class ErsUsersDaoImpl implements ErsUsersDAO {

	static { //(this would normally go into your dao layer)
	      try {
	          Class.forName("org.postgresql.Driver");
	      }catch(ClassNotFoundException e) {
	          e.printStackTrace();
	          System.out.println("Static block has failed me");
	      }
	}
	
	@Override
	public boolean loginVerfication(ersUsers user) {
		
		try(Connection conn = customConnection.getConnection()){
			String sql = "select * FROM ers_users WHERE username = '"+ user.getEmployeeUser() + 
						 "' AND user_password = '"+ user.getEmployeePassw()+"'";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
//				store
				System.out.println("Login Successful");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ersUsers storeUserSession(ersUsers user) {
		
		ersUsers currentUser = null;
		
		try(Connection conn = customConnection.getConnection()){
			String sql = "select * FROM ers_users WHERE username = '"+ user.getEmployeeUser() + 
						 "' AND user_password = '"+ user.getEmployeePassw()+"'";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				currentUser = (new ersUsers (rs.getInt(1), rs.getString(2), rs.getString(3), 
											 rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(currentUser);
		return currentUser;
	}
}

	


