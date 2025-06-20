package models;
// Generated Jun 1, 2025, 7:59:38 PM by Hibernate Tools 5.6.15.Final

/**
 * Patterne generated by hbm2java
 */
public class Patterne implements java.io.Serializable {

	private int idpatterne;
	private Compte compte;
	private String prefixe;
	private String suffixe;
	private String class_;
	private String colonne;

	public Patterne() {
	}

	public Patterne(int idpatterne, Compte compte) {
		this.idpatterne = idpatterne;
		this.compte = compte;
	}

	public Patterne(int idpatterne, Compte compte, String prefixe, String suffixe, String class_, String colonne) {
		this.idpatterne = idpatterne;
		this.compte = compte;
		this.prefixe = prefixe;
		this.suffixe = suffixe;
		this.class_ = class_;
		this.colonne = colonne;
	}

	public int getIdpatterne() {
		return this.idpatterne;
	}

	public void setIdpatterne(int idpatterne) {
		this.idpatterne = idpatterne;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public String getPrefixe() {
		return this.prefixe;
	}

	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}

	public String getSuffixe() {
		return this.suffixe;
	}

	public void setSuffixe(String suffixe) {
		this.suffixe = suffixe;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getColonne() {
		return this.colonne;
	}

	public void setColonne(String colonne) {
		this.colonne = colonne;
	}

}
