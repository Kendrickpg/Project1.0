package services;

import DAO.ErsUsersDAO;
import DAO.ErsUsersDaoImpl;
import Models.ersUsers;

public class ErsUsersServicesImpl implements ErsUsersServices {

	static ErsUsersDAO ersUsersDao = new ErsUsersDaoImpl();
	
	public static boolean loginVerfication (ersUsers user) {
		
		return ersUsersDao.loginVerfication(user);
	}

	public static ersUsers storeUserSession(ersUsers user) {
		// TODO Auto-generated method stub
		return ersUsersDao.storeUserSession(user);
	}
	
}
