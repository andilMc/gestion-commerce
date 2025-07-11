package models;
// Generated Jun 1, 2025, 7:59:38 PM by Hibernate Tools 5.6.15.Final

/**
 * EmployerId generated by hbm2java
 */
public class EmployerId implements java.io.Serializable {

	private int idpersonne;
	private int idemployer;

	public EmployerId() {
	}

	public EmployerId(int idpersonne, int idemployer) {
		this.idpersonne = idpersonne;
		this.idemployer = idemployer;
	}

	public int getIdpersonne() {
		return this.idpersonne;
	}

	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}

	public int getIdemployer() {
		return this.idemployer;
	}

	public void setIdemployer(int idemployer) {
		this.idemployer = idemployer;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmployerId))
			return false;
		EmployerId castOther = (EmployerId) other;

		return (this.getIdpersonne() == castOther.getIdpersonne())
				&& (this.getIdemployer() == castOther.getIdemployer());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdpersonne();
		result = 37 * result + this.getIdemployer();
		return result;
	}

}
