package models;
// Generated Jun 1, 2025, 7:59:38 PM by Hibernate Tools 5.6.15.Final

/**
 * Casquette generated by hbm2java
 */
public class Casquette implements java.io.Serializable {

	private int idcasquette;
	private Collaborateur collaborateur;
	private String libelle;

	public Casquette() {
	}

	public Casquette(int idcasquette, Collaborateur collaborateur) {
		this.idcasquette = idcasquette;
		this.collaborateur = collaborateur;
	}

	public Casquette(int idcasquette, Collaborateur collaborateur, String libelle) {
		this.idcasquette = idcasquette;
		this.collaborateur = collaborateur;
		this.libelle = libelle;
	}

	public int getIdcasquette() {
		return this.idcasquette;
	}

	public void setIdcasquette(int idcasquette) {
		this.idcasquette = idcasquette;
	}

	public Collaborateur getCollaborateur() {
		return this.collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
