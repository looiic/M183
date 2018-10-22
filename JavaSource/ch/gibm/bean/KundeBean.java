package ch.gibm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.gibm.entity.Auto;
import ch.gibm.entity.Kunde;
import ch.gibm.facade.KundeFacade;

@ViewScoped
@ManagedBean
public class KundeBean extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final String SELECTED_KUNDE = "selectedKunde";

	private Kunde kunde;
	private Kunde kundeWithAutos;
	private Kunde kundeForDetail;
	
	private Auto auto;

	private List<Kunde> kunden;
	private KundeFacade kundeFacade;
	
	public void addAutoToKunde() {
		try {
			getKundenFacade().addAutoToKunde(auto.getId(), kundeWithAutos.getId());
			closeDialog();
			displayInfoMessageToUser("Added with success");
			reloadKundeWithAutos();
			resetAuto();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}

	public void removeLanguageFromPerson() {
		try {
			getKundenFacade().removeAutoFromKunde(auto.getId(), kundeWithAutos.getId());
			closeDialog();
			displayInfoMessageToUser("Removed with success");
			reloadKundeWithAutos();
			resetAuto();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}
	
	
	private void reloadKundeWithAutos() {
		//kundeWithAutos = getKundenFacade().findKundeWithAllAutos(kunde.getId());
	}
	
	public void resetAuto() {
		auto = new Auto();
	}
	
	

	public void createKunde() {
		try {
			getKundenFacade().createKunde(kunde);
			closeDialog();
			displayInfoMessageToUser("Created with success");
			loadKunden();
			resetKunde();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}

	public void updateKunde() {
		try {
			getKundenFacade().updateKunde(kunde);
			closeDialog();
			displayInfoMessageToUser("Updated with success");
			loadKunden();
			resetKunde();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while updating. Try again later");
			e.printStackTrace();
		}
	}

	public void deleteKunde() {
		try {
			getKundenFacade().deleteKunde(kunde);
			closeDialog();
			displayInfoMessageToUser("Deleted with success");
			loadKunden();
			resetKunde();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}

	public void setKundeForDetail(Kunde kunde) {
		kundeForDetail = kunde;
	}

	public Kunde getKundeForDetail() {
		if (kundeForDetail == null) {
			kundeForDetail = new Kunde();
		}

		return kundeForDetail;
	}

	public void resetKundeForDetail() {
		kundeForDetail = new Kunde();
	}

	public KundeFacade getKundenFacade() {
		if (kundeFacade == null) {
			kundeFacade = new KundeFacade();
		}

		return kundeFacade;
	}

	public Kunde getKunde() {
		if (kunde == null) {
			kunde = new Kunde();
		}

		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public List<Kunde> getAllKunden() {
		if (kunden == null) {
			loadKunden();
		}

		return kunden;
	}

	private void loadKunden() {
		kunden = getKundenFacade().listAll();
	}

	public void resetKunde() {
		kunde = new Kunde();
	}
}
