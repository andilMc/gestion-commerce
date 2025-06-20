package models;
// Generated Jun 1, 2025, 7:59:38 PM by Hibernate Tools 5.6.15.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Personne generated by hbm2java
 */
public class Personne implements java.io.Serializable {

	private int idpersonne;
	private Profile profile;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private Date datenaissance;
	private String photoprofil;
	private Date dateinscription;
	private String pays;
	private String adresse;
	private String codepostal;
	private Set comptes = new HashSet(0);
	private Set employers = new HashSet(0);
	private Set clients = new HashSet(0);
	private Set collaborateurs = new HashSet(0);

	public Personne() {
	}

	public Personne(int idpersonne, Profile profile) {
		this.idpersonne = idpersonne;
		this.profile = profile;
	}

	public Personne(int idpersonne, Profile profile, String nom, String prenom, String email, String telephone,
			Date datenaissance, String photoprofil, Date dateinscription, String pays, String adresse,
			String codepostal, Set comptes, Set employers, Set clients, Set collaborateurs) {
		this.idpersonne = idpersonne;
		this.profile = profile;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.datenaissance = datenaissance;
		this.photoprofil = photoprofil;
		this.dateinscription = dateinscription;
		this.pays = pays;
		this.adresse = adresse;
		this.codepostal = codepostal;
		this.comptes = comptes;
		this.employers = employers;
		this.clients = clients;
		this.collaborateurs = collaborateurs;
	}

	public int getIdpersonne() {
		return this.idpersonne;
	}

	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getPhotoprofil() {
		return this.photoprofil;
	}

	public void setPhotoprofil(String photoprofil) {
		this.photoprofil = photoprofil;
	}

	public Date getDateinscription() {
		return this.dateinscription;
	}

	public void setDateinscription(Date dateinscription) {
		this.dateinscription = dateinscription;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepostal() {
		return this.codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public Set getComptes() {
		return this.comptes;
	}

	public void setComptes(Set comptes) {
		this.comptes = comptes;
	}

	public Set getEmployers() {
		return this.employers;
	}

	public void setEmployers(Set employers) {
		this.employers = employers;
	}

	public Set getClients() {
		return this.clients;
	}

	public void setClients(Set clients) {
		this.clients = clients;
	}

	public Set getCollaborateurs() {
		return this.collaborateurs;
	}

	public void setCollaborateurs(Set collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

}
