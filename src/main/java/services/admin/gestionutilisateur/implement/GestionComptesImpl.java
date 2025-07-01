package services.admin.gestionutilisateur.implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import services.admin.gestionutilisateur.remote.GestionComptes;
import dao.GenericDAO;
import models.Compte;
import models.Personne;
import models.Permission;
import models.Role;
import models.RoleId;



@Stateless
public class GestionComptesImpl implements GestionComptes {

    private final GenericDAO<Compte> compteDAO;
    private final GenericDAO<Personne> personneDAO;
    private final GenericDAO<Role> roleDAO;
    private final GenericDAO<Permission> permissionDAO;

    public GestionComptesImpl() {
        this.compteDAO = new GenericDAO<>(Compte.class);
        this.personneDAO = new GenericDAO<>(Personne.class);
        this.roleDAO = new GenericDAO<>(Role.class);
        this.permissionDAO = new GenericDAO<>(Permission.class);
    }

    // Helper method to get a Compte by ID
    private Compte getCompteById(int idCompte) {
        return compteDAO.getById(idCompte);
    }

    @Override
    public List<Compte> listerToutCompte() {
        return compteDAO.listAll();
    }

    @Override
    public Compte detailCompte(int idCompte) {
        return compteDAO.getByIdWithAssociations(idCompte, "roles", "personne");
    }

    @Override
    public boolean activerCompte(int idCompte) {
        Compte compte = getCompteById(idCompte);
        if (compte != null) {
            compte.setEtat("actif"); // Assuming "actif" is the active state
            compteDAO.update(compte);
            return true;
        }
        return false;
    }

    @Override
    public boolean desactiverCompte(int idCompte) {
        Compte compte = getCompteById(idCompte);
        if (compte != null) {
            compte.setEtat("inactif"); // Assuming "inactif" is the inactive state
            compteDAO.update(compte);
            return true;
        }
        return false;
    }

    @Override
    public boolean supprimerCompte(int idCompte) {
        Compte compte = getCompteById(idCompte);
        if (compte != null) {
            compteDAO.delete(compte);
            return true;
        }
        return false;
    }

    @Override
    public boolean reparerCompte(int idCompte, String identifiant) {
        Compte compte = getCompteById(idCompte);
        if (compte != null) {
            compte.setIdentifiant(identifiant);
            compteDAO.update(compte);
            return true;
        }
        return false;
    }

    @Override
    public List<Compte> rechercherCompteParIdentifiant(String identifiant) {
        List<Compte> comptes = compteDAO.findAllByField("identifiant", identifiant);
        return comptes;
    }

    @Override
    public boolean creerCompte(Compte nouveauCompte, int idPersonne, List<Integer> idPermissions) {
        Personne personne = personneDAO.getById(idPersonne);
        if (personne == null) {
            System.err.println("Personne with ID " + idPersonne + " not found.");
            return false;
        }

        nouveauCompte.setPersonne(personne);
        nouveauCompte.setDatecreation(new Date());
        nouveauCompte.setEtat("actif"); // Default state for new account
        compteDAO.add(nouveauCompte);

        // Assign roles based on permissions
        for (Integer idPermission : idPermissions) {
            Permission permission = permissionDAO.getById(idPermission);
            if (permission != null) {
                Role role = new Role();
                RoleId roleId = new RoleId(nouveauCompte.getIdconnexion(), permission.getIdpermission());
                role.setId(roleId);
                role.setCompte(nouveauCompte);
                role.setPermission(permission);
                role.setDatecreation(new Date().toString()); // Assuming datecreation is String
                role.setEtat(true);
                roleDAO.add(role);
            }
        }
        return true;
    }

    @Override
    public boolean modifierCompte(Compte compteAModifier) {
        if (compteAModifier != null) {
            compteDAO.update(compteAModifier);
            return true;
        }
        return false;
    }

    @Override
    public boolean ajouterRoleACompte(int idCompte, int idPermission) {
        Compte compte = getCompteById(idCompte);
        Permission permission = permissionDAO.getById(idPermission);

        if (compte != null && permission != null) {
            RoleId roleId = new RoleId(idCompte, idPermission);
            Role existingRole = roleDAO.getById(roleId);
            if (existingRole == null) {
                Role newRole = new Role();
                newRole.setId(roleId);
                newRole.setCompte(compte);
                newRole.setPermission(permission);
                newRole.setDatecreation(new Date().toString());
                newRole.setEtat(true);
                roleDAO.add(newRole);
                return true;
            } else {
                System.out.println("Role already exists for this account and permission.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean retirerRoleDeCompte(int idCompte, int idPermission) {
        RoleId roleId = new RoleId(idCompte, idPermission);
        Role roleToDelete = roleDAO.getById(roleId);
        if (roleToDelete != null) {
            roleDAO.delete(roleToDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<Role> listerRolesCompte(int idCompte) {
        Compte compte = compteDAO.getByIdWithAssociations(idCompte, "roles");
        if (compte != null) {
            return new ArrayList<>(compte.getRoles());
        }
        return Collections.emptyList();
    }

    @Override
    public boolean reinitialiserMotDePasse(int idCompte, String nouveauMotDePasse) {
        Compte compte = getCompteById(idCompte);
        if (compte != null) {
            compte.setMotdepasse(nouveauMotDePasse);
            compteDAO.update(compte);
            return true;
        }
        return false;
    }
}
