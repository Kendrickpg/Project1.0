package services;

import Models.ersUsers;

public interface ErsUsersServices {

	public static boolean loginVerfication (ersUsers user) {
		// TODO Auto-generated method stub
		return ErsUsersServicesImpl.loginVerfication(user);
	}
	
	public static ersUsers storeUserSession(ersUsers user) {
		
		return ErsUsersServicesImpl.storeUserSession(user);
		
	}
	
}
