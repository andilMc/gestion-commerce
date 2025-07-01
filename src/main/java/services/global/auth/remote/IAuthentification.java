package services.global.auth.remote;

import java.util.Date;
import java.util.List;
import jakarta.ejb.Remote;

@Remote
public interface IAuthentification {
    public List<Object> authentifier(String identifiant, String motDePasse);
    public boolean changerMotDePasse(int compteCourrant, String identifiant,String email, String ancienMotDePasse, String nouveauMotDePasse);
   
    public boolean nouveauPersonne(String nom, String prenom, String email, Date dateNaissance, String telephone, String adresse, String pays, String codePostal, String etat);
    public boolean modifierPersonne(int idPersonne, String nom, String prenom, String email, Date dateNaissance, String telephone, String adresse, String pays, String codePostal, boolean etat);
    
    public boolean nouveauProfile(String libelle);
    public boolean modifierProfile(int idProfile, String libelle);

    public boolean nouveauCompte(int idPersonne ,String identifiant, String motDePasse);
    public boolean modifierCompte(int idCompte, String identifiant, String etat);
    public boolean supprimerCompte(int idCompte);

    public List<Object> getPermissionParCompte(int idCompte);
    public List<Object> getProfileParPersonne(int idPersonne);
    public List<?> getPersonneParCompte(int idCompte);
}