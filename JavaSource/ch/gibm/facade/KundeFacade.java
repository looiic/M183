package ch.gibm.facade;

import java.util.List;

import ch.gibm.dao.KundeDAO;
import ch.gibm.dao.AutoDAO;
import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.entity.Auto;
import ch.gibm.entity.Kunde;

public class KundeFacade {
	
	private KundeDAO kundeDAO = new KundeDAO();
	private AutoDAO autoDAO = new AutoDAO();
	
	public void createKunde(Kunde kunde) {
		EntityManagerHelper.beginTransaction();
		kundeDAO.save(kunde);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void updateKunde(Kunde kunde) {
		EntityManagerHelper.beginTransaction();
		Kunde persistedEntity= kundeDAO.find(kunde.getId());
		persistedEntity.setVorname(kunde.getVorname());
		persistedEntity.setNachname(kunde.getNachname());
		persistedEntity.setStrasse(kunde.getStrasse());
		persistedEntity.setHausnummer(kunde.getHausnummer());
		persistedEntity.setPostleitzahl(kunde.getPostleitzahl());
		persistedEntity.setOrt(kunde.getOrt());
		
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public void deleteKunde(Kunde kunde){
		EntityManagerHelper.beginTransaction();
		Kunde persistedEntityWithIdOnly = kundeDAO.findReferenceOnly(kunde.getId());
		kundeDAO.delete(persistedEntityWithIdOnly);
		EntityManagerHelper.commitAndCloseTransaction();
		
	}

	public Kunde findKunde(int kundeId) {
		EntityManagerHelper.beginTransaction();
		Kunde kunde = kundeDAO.find(kundeId);
		EntityManagerHelper.commitAndCloseTransaction();
		return kunde;
	}

	public List<Kunde> listAll() {
		EntityManagerHelper.beginTransaction();
		List<Kunde> result = kundeDAO.findAll();
		EntityManagerHelper.commitAndCloseTransaction();

		return result;
	}
	
	public void addAutoToKunde(int autoId, int kundeId) {
		EntityManagerHelper.beginTransaction();
		Auto auto = autoDAO.find(kundeId);
		Kunde kunde = kundeDAO.find(kundeId);
		kunde.getAutos().add(auto);
		auto.getKunden().add(kunde);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void removeAutoFromKunde(int autoId, int kundenId) {
		EntityManagerHelper.beginTransaction();
		Auto auto = autoDAO.find(autoId);
		Kunde kunde = kundeDAO.find(kundenId);
		kunde.getAutos().remove(auto);
		auto.getKunden().remove(kunde);
		EntityManagerHelper.commitAndCloseTransaction();
	}
}
