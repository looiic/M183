package ch.gibm.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import ch.gibm.entity.Role;
import ch.gibm.entity.User;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean extends AbstractBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String USER_BEAN_NAME = "userBean";
	public static final String DI_NAME = "#{" + USER_BEAN_NAME + "}";
	
	private User loggedInUser;
	
	public void logout(){
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		try {
			ec.redirect("/SecJSFApp/pages/public/login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User getLoggedInUser() {
		return this.loggedInUser;
	}

	public void setLoggedInUser(User user) {
		this.loggedInUser = user;
	}
	
	public boolean isCurrentUserAdmin(){
		if(this.loggedInUser != null){
			return this.loggedInUser.getRole() == Role.ADMIN;
		}
		return false;
	}
	
	public boolean isCurrentUserUserOrHigher() {
		if(this.loggedInUser != null) {
			return this.loggedInUser.getRole() == Role.ADMIN || this.loggedInUser.getRole() == Role.USER;
		}
		return false;
	}
	
}
