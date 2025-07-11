package models;
// Generated Jun 1, 2025, 7:59:38 PM by Hibernate Tools 5.6.15.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Poste generated by hbm2java
 */
public class Poste implements java.io.Serializable {

	private int idposte;
	private String titre;
	private String descriptionposte;
	private Set employers = new HashSet(0);

	public Poste() {
	}

	public Poste(int idposte) {
		this.idposte = idposte;
	}

	public Poste(int idposte, String titre, String descriptionposte, Set employers) {
		this.idposte = idposte;
		this.titre = titre;
		this.descriptionposte = descriptionposte;
		this.employers = employers;
	}

	public int getIdposte() {
		return this.idposte;
	}

	public void setIdposte(int idposte) {
		this.idposte = idposte;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescriptionposte() {
		return this.descriptionposte;
	}

	public void setDescriptionposte(String descriptionposte) {
		this.descriptionposte = descriptionposte;
	}

	public Set getEmployers() {
		return this.employers;
	}

	public void setEmployers(Set employers) {
		this.employers = employers;
	}

}
