package ch.gibm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Kunde.findKundeById", query = "select k from Kunde k where k.id = :kundeId")
public class Kunde {
	
	public static final String FIND_KUNDE_BY_ID = "Kunde.findKundeById";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nachname;
	private String vorname;
	private String strasse;
	private String hausnummer;
	private String postleitzahl;
	private String ort;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getPostleitzahl() {
		return postleitzahl;
	}

	public void setPostleitzahl(String postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Kunde) {
			Kunde kunde = (Kunde) obj;
			return kunde.getId() == id;
		}

		return false;
	}
}
