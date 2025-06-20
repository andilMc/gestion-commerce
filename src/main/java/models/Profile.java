package models;
// Generated Jun 1, 2025, 7:59:38 PM by Hibernate Tools 5.6.15.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Profile generated by hbm2java
 */
public class Profile implements java.io.Serializable {

	private int idprofile;
	private String libelle;
	private Set personnes = new HashSet(0);

	public Profile() {
	}

	public Profile(int idprofile) {
		this.idprofile = idprofile;
	}

	public Profile(int idprofile, String libelle, Set personnes) {
		this.idprofile = idprofile;
		this.libelle = libelle;
		this.personnes = personnes;
	}

	public int getIdprofile() {
		return this.idprofile;
	}

	public void setIdprofile(int idprofile) {
		this.idprofile = idprofile;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set getPersonnes() {
		return this.personnes;
	}

	public void setPersonnes(Set personnes) {
		this.personnes = personnes;
	}

}
