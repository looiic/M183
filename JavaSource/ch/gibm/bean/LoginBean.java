package ch.gibm.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ch.gibm.entity.Role;
import ch.gibm.entity.User;
import ch.gibm.facade.AutoFacade;
import ch.gibm.facade.UserFacade;
import ch.gibm.util.BCrypt;

@ManagedBean
@RequestScoped
public class LoginBean extends AbstractBean{
	public static final String ATTR_USER = "user";
	
	@ManagedProperty(value = UserBean.DI_NAME)
	private UserBean userBean;
	
	private UserFacade userFacade;
	
	private String username;
	private String password;
	
	public void login() {
		
		User user = getUserFacade().getUserByName(username);
		
		//now, always a pseudo admin user is logged in
		//you have to implement a safe login mechanism
		//User user = new User("admin", "12345678", Role.ADMIN);
		//user.setEmail("admin@gibmit.ch");
		
		
		
		if(BCrypt.checkpw(password, user.getPassword())) {
			userBean.setLoggedInUser(user);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest)context.getExternalContext().getRequest();
			req.getSession().setAttribute(ATTR_USER, user);
		}else{
			keepDialogOpen();
			displayErrorMessageToUser("Wrong Username/Password. Try again");
		}
		
	}
	
	public UserFacade getUserFacade() {
		if (userFacade == null) {
			userFacade = new UserFacade();
		}

		return userFacade;
	}
	
	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserBean(UserBean userBean){
		this.userBean = userBean;
	}
	
}
