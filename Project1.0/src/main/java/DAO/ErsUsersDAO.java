package DAO;

import Models.ersUsers;

public interface ErsUsersDAO {

	public boolean loginVerfication (ersUsers user); 
	
	public ersUsers storeUserSession(ersUsers user);
}
