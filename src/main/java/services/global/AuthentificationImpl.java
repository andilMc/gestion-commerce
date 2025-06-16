package services.global;

import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateful;

@Stateful
public class AuthentificationImpl implements IAuthentification {

    @Override
    public List<Object> authentifier(String identifiant, String motDePasse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authentifier'");
    }

    @Override
    public boolean changerMotDePasse(int compteCourrant, String identifiant, String email, String ancienMotDePasse,
            String nouveauMotDePasse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changerMotDePasse'");
    }

    @Override
    public boolean nouveauPersonne(String nom, String prenom, String email, Date dateNaissance, String telephone,
            String adresse, String pays, String codePostal, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nouveauPersonne'");
    }

    @Override
    public boolean modifierPersonne(int idPersonne, String nom, String prenom, String email, Date dateNaissance,
            String telephone, String adresse, String pays, String codePostal, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierPersonne'");
    }

    @Override
    public boolean nouveauProfile(int idPersonne, String libelle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nouveauProfile'");
    }

    @Override
    public boolean modifierProfile(int idProfile, String libelle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierProfile'");
    }

    @Override
    public boolean nouveauCompte(int idPersonne, String identifiant, String motDePasse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nouveauCompte'");
    }

    @Override
    public boolean modifierCompte(int idCompte, String identifiant, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierCompte'");
    }

    @Override
    public boolean supprimerCompte(int idCompte) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimerCompte'");
    }

    @Override
    public List<Object> getPermissionParCompte(int idCompte) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPermissionParCompte'");
    }

    @Override
    public List<Object> getProfileParPersonne(int idPersonne) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProfileParPersonne'");
    }

    @Override
    public List<?> getPersonneParCompte(int idCompte) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonneParCompte'");
    }

    
}
