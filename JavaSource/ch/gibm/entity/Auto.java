package ch.gibm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Auto.findAutoById", query = "select a from Auto a where a.id = :autoId")
public class Auto {
	
	public static final String FIND_ENTITY_BY_ID = "GeneralEntity.findEntityById";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int jahrgang;
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getJahrgang() {
		return jahrgang;
	}

	public void setJahrgang(int jahrgang) {
		this.jahrgang = jahrgang;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Auto) {
			Auto auto = (Auto) obj;
			return auto.getId() == id;
		}

		return false;
	}
}
