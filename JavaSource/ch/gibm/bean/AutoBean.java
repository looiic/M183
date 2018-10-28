package ch.gibm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import ch.gibm.entity.Auto;
import ch.gibm.facade.AutoFacade;

@ViewScoped
@ManagedBean
public class AutoBean extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private static final String SELECTED_AUTO = "selectedAuto";
	
	private static final Logger logger = Logger.getLogger(AutoBean.class);
	
	private Auto auto;
	private Auto autoForDetail;

	private List<Auto> autos;
	private AutoFacade autoFacade;

	public void createAuto() {
		try {
			getAutoFacade().createAuto(auto);
			closeDialog();
			displayInfoMessageToUser("Created with success");
			loadAutos();
			resetAuto();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
			logger.error(e);
		}
	}

	public void updateAuto() {
		try {
			getAutoFacade().updateAuto(auto);
			closeDialog();
			displayInfoMessageToUser("Updated with success");
			loadAutos();
			resetAuto();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while updating. Try again later");
			e.printStackTrace();
		}
	}

	public void deleteAuto() {
		try {
			getAutoFacade().deleteAuto(auto);
			closeDialog();
			displayInfoMessageToUser("Deleted with success");
			loadAutos();
			resetAuto();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}

	public void setAutoForDetail(Auto auto) {
		autoForDetail = auto;
	}

	public Auto getAutoForDetail() {
		if (autoForDetail == null) {
			autoForDetail = new Auto();
		}

		return autoForDetail;
	}

	public void resetAutoForDetail() {
		autoForDetail = new Auto();
	}

	public AutoFacade getAutoFacade() {
		if (autoFacade == null) {
			autoFacade = new AutoFacade();
		}

		return autoFacade;
	}

	public Auto getAuto() {
		if (auto == null) {
			auto = new Auto();
		}

		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public List<Auto> getAllAutos() {
		if (autos == null) {
			loadAutos();
		}

		return autos;
	}

	private void loadAutos() {
		autos = getAutoFacade().listAll();
	}

	public void resetAuto() {
		auto = new Auto();
	}
	
	public void validateName(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String name = (String) value;
		  if (name.length() > 30 || name.length() < 1) {
		    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Min. 1 Zeichen Max. 30 Zeichen", "Min. 1 Zeichen Max. 30 Zeichen"));
		  }
	}
	
	public void validateJahrgang(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		int jg = (int) value;
		  if (jg < 1000 || jg > 9999) {
		    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Jahrgang darf nur 4 Stellig sein", "Jahrgang darf nur 4 Stellig sein"));
		  }
	}
	
}
