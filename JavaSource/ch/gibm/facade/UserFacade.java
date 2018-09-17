package ch.gibm.facade;

import java.io.Serializable;

import ch.gibm.dao.UserDAO;

public class UserFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO = new UserDAO();

	/*public User getUserIfExists(String username, String password) {
		
	}*/
	
	//...
}
