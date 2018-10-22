package ch.gibm.facade;

import java.util.List;

import ch.gibm.dao.AutoDAO;
import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.entity.Auto;

public class AutoFacade {
	
	private AutoDAO autoDAO = new AutoDAO();
	
	public void createAuto(Auto auto) {
		EntityManagerHelper.beginTransaction();
		autoDAO.save(auto);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void updateAuto(Auto auto) {
		EntityManagerHelper.beginTransaction();
		Auto persistedEntity= autoDAO.find(auto.getId());
		persistedEntity.setName(auto.getName());
		persistedEntity.setJahrgang(auto.getJahrgang());
		persistedEntity.setStatus(auto.isStatus());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public void deleteAuto(Auto auto){
		EntityManagerHelper.beginTransaction();
		Auto persistedEntityWithIdOnly = autoDAO.findReferenceOnly(auto.getId());
		autoDAO.delete(persistedEntityWithIdOnly);
		EntityManagerHelper.commitAndCloseTransaction();
		
	}

	public Auto findAuto(int autoId) {
		EntityManagerHelper.beginTransaction();
		Auto auto = autoDAO.find(autoId);
		EntityManagerHelper.commitAndCloseTransaction();
		return auto;
	}

	public List<Auto> listAll() {
		EntityManagerHelper.beginTransaction();
		List<Auto> result = autoDAO.findAll();
		EntityManagerHelper.commitAndCloseTransaction();

		return result;
	}
}
