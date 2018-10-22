package ch.gibm.facade;

import java.io.Serializable;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.dao.UserDAO;
import ch.gibm.entity.User;

public class UserFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO = new UserDAO();



	public User getUserByName(String name) {
		EntityManagerHelper.beginTransaction();
		User user = userDAO.getUserByName(name);
		EntityManagerHelper.commitAndCloseTransaction();

		return user;
	}
}
