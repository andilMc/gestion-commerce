package models;
// Generated Jun 1, 2025, 7:59:38 PM by Hibernate Tools 5.6.15.Final

/**
 * CollaborateurId generated by hbm2java
 */
public class CollaborateurId implements java.io.Serializable {

	private int idpersonne;
	private int idcollaborateur;

	public CollaborateurId() {
	}

	public CollaborateurId(int idpersonne, int idcollaborateur) {
		this.idpersonne = idpersonne;
		this.idcollaborateur = idcollaborateur;
	}

	public int getIdpersonne() {
		return this.idpersonne;
	}

	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}

	public int getIdcollaborateur() {
		return this.idcollaborateur;
	}

	public void setIdcollaborateur(int idcollaborateur) {
		this.idcollaborateur = idcollaborateur;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CollaborateurId))
			return false;
		CollaborateurId castOther = (CollaborateurId) other;

		return (this.getIdpersonne() == castOther.getIdpersonne())
				&& (this.getIdcollaborateur() == castOther.getIdcollaborateur());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdpersonne();
		result = 37 * result + this.getIdcollaborateur();
		return result;
	}

}
