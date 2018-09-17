package ch.gibm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.gibm.entity.GeneralEntity;
import ch.gibm.facade.EntityFacade;

@ViewScoped
@ManagedBean
public class EntityBean extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String SELECTED_ENTITY = "selectedEntity";

	private GeneralEntity generalEntity;
	private GeneralEntity generalEntityForDetail;

	private List<GeneralEntity> generalEntities;
	private EntityFacade entityFacade;

	public void createEntity() {
		try {
			getEntityFacade().createEntity(generalEntity);
			closeDialog();
			displayInfoMessageToUser("Created with success");
			loadEntities();
			resetEntity();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}

	public void updateEntity() {
		try {
			getEntityFacade().updateEntity(generalEntity);
			closeDialog();
			displayInfoMessageToUser("Updated with success");
			loadEntities();
			resetEntity();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while updating. Try again later");
			e.printStackTrace();
		}
	}

	public void deleteEntity() {
		try {
			getEntityFacade().deleteEntity(generalEntity);
			closeDialog();
			displayInfoMessageToUser("Deleted with success");
			loadEntities();
			resetEntity();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}

	public void setGeneralEntityForDetail(GeneralEntity generalEntity) {
		generalEntityForDetail = generalEntity;
	}

	public GeneralEntity getGeneralEntityForDetail() {
		if (generalEntityForDetail == null) {
			generalEntityForDetail = new GeneralEntity();
		}

		return generalEntityForDetail;
	}

	public void resetGeneralEntityForDetail() {
		generalEntityForDetail = new GeneralEntity();
	}

	public EntityFacade getEntityFacade() {
		if (entityFacade == null) {
			entityFacade = new EntityFacade();
		}

		return entityFacade;
	}

	public GeneralEntity getGeneralEntity() {
		if (generalEntity == null) {
			generalEntity = new GeneralEntity();
		}

		return generalEntity;
	}

	public void setGeneralEntity(GeneralEntity generalEntity) {
		this.generalEntity = generalEntity;
	}

	public List<GeneralEntity> getAllEntities() {
		if (generalEntities == null) {
			loadEntities();
		}

		return generalEntities;
	}

	private void loadEntities() {
		generalEntities = getEntityFacade().listAll();
	}

	public void resetEntity() {
		generalEntity = new GeneralEntity();
	}

}