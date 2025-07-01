package services.global.auth.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateful;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.GenericDAO;
import models.Compte;
import models.Permission;
import models.Personne;
import models.Profile;
import models.Role;
import services.global.auth.remote.IAuthentification;
import utils.Connexion;

@Stateful
public class AuthentificationImpl implements IAuthentification {

    private final GenericDAO<Personne> personneDAO;
    private final GenericDAO<Profile> profileDAO;
    private final GenericDAO<Compte> compteDAO;
    private final GenericDAO<Role> roleDAO;
    private final GenericDAO<Permission> permissionDAO;

    public AuthentificationImpl() {
        this.personneDAO = new GenericDAO<>(Personne.class);
        this.profileDAO = new GenericDAO<>(Profile.class);
        this.compteDAO = new GenericDAO<>(Compte.class);
        this.roleDAO = new GenericDAO<>(Role.class);
        this.permissionDAO = new GenericDAO<>(Permission.class);
    }

    @Override
    public List<Object> authentifier(String identifiant, String motDePasse) {
        List<Object> result = new ArrayList<>();
        try {
            Compte compte = compteDAO.findByFields(Map.of("identifiant", identifiant, "motDePasse", motDePasse)).get(0);

            if (compte != null) {
                result.add(compte);
                Personne personne = compte.getPersonne();
                if (personne != null) {
                    result.add(personne);
                    result.add(personne.getProfile());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return result;
    }

    @Override
    public boolean changerMotDePasse(int compteCourrant, String identifiant, String email, String ancienMotDePasse,
            String nouveauMotDePasse) {
        try {
            Compte compte = compteDAO.findByFields(Map.of("identifiant", identifiant, "motDePasse", ancienMotDePasse)).get(0);

            if (compte != null && compte.getPersonne().getEmail().equals(email)) {
                compte.setMotdepasse(nouveauMotDePasse);
                compteDAO.update(compte);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean nouveauPersonne(String nom, String prenom, String email, Date dateNaissance, String telephone,
            String adresse, String pays, String codePostal, String etat) {
        try {
            Personne personne = new Personne();
            personne.setNom(nom);
            personne.setPrenom(prenom);
            personne.setEmail(email);
            personne.setDatenaissance(dateNaissance);
            personne.setTelephone(telephone);
            personne.setAdresse(adresse);
            personne.setPays(pays);
            personne.setCodepostal(codePostal);
            personneDAO.add(personne);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean modifierPersonne(int idPersonne, String nom, String prenom, String email, Date dateNaissance,
            String telephone, String adresse, String pays, String codePostal, boolean etat) {
        try {
            Personne personne = personneDAO.getById(idPersonne);
            if (personne != null) {
                personne.setNom(nom);
                personne.setPrenom(prenom);
                personne.setEmail(email);
                personne.setDatenaissance(dateNaissance);
                personne.setTelephone(telephone);
                personne.setAdresse(adresse);
                personne.setPays(pays);
                personne.setCodepostal(codePostal);
                personneDAO.update(personne);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean nouveauProfile(String libelle) {
        try {
                Profile profile = new Profile();
                profile.setLibelle(libelle);
                profileDAO.add(profile);
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean modifierProfile(int idProfile, String libelle) {
        try {
            Profile profile = profileDAO.getById(idProfile);
            if (profile != null) {
                profile.setLibelle(libelle);
                profileDAO.update(profile);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean nouveauCompte(int idPersonne, String identifiant, String motDePasse) {
        try {
            Personne personne = personneDAO.getById(idPersonne);
            if (personne != null) {
                Compte compte = new Compte();
                compte.setIdentifiant(identifiant);
                compte.setMotdepasse(motDePasse);
                compte.setPersonne(personne);
                compte.setEtat("actif"); // Default to active
                compteDAO.add(compte);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean modifierCompte(int idCompte, String identifiant, String etat) {
        try {
            Compte compte = compteDAO.getById(idCompte);
            if (compte != null) {
                compte.setIdentifiant(identifiant);
                compte.setEtat(etat);
                compteDAO.update(compte);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean supprimerCompte(int idCompte) {
        try {
            Compte compte = compteDAO.getById(idCompte);
            if (compte != null) {
                compteDAO.delete(compte);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public List<Object> getPermissionParCompte(int idCompte) {
        List<Object> permissions = new ArrayList<>();
        try {
            Compte compte = compteDAO.getByIdWithAssociations(idCompte, "personne.profile");
            if (compte != null && compte.getPersonne() != null && compte.getPersonne().getProfile() != null) {
                Profile profile = compte.getPersonne().getProfile();
                List<Role> roles = roleDAO.findAllByField("profile", profile);
                for (Role role : roles) {
                    permissions.add(role.getPermission());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return permissions;
    }

    @Override
    public List<Object> getProfileParPersonne(int idPersonne) {
        List<Object> profiles = new ArrayList<>();
        try {
            Personne personne = personneDAO.getByIdWithAssociations(idPersonne, "profile");
            if (personne != null && personne.getProfile() != null) {
                profiles.add(personne.getProfile());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return profiles;
    }

    @Override
    public List<?> getPersonneParCompte(int idCompte) {
        List<Personne> personnes = new ArrayList<>();
        try {
            Compte compte = compteDAO.getById(idCompte);
            if (compte != null && compte.getPersonne() != null) {
                personnes.add(compte.getPersonne());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return personnes;
    }
}
