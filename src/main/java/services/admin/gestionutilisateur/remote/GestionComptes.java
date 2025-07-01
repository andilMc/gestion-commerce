package services.admin.gestionutilisateur.remote;

import java.util.List;

import models.Compte;
import models.Role;

public interface GestionComptes {
    // Méthodes existantes, avec des retours d'objets Compte
    public List<Compte> listerToutCompte();
    public Compte detailCompte(int idCompte);
    public boolean activerCompte(int idCompte);
    public boolean desactiverCompte(int idCompte);
    public boolean supprimerCompte(int idCompte);
    public boolean reparerCompte(int idCompte, String identifiant);
    public List<Compte> rechercherCompteParIdentifiant(String identifiant);

    // Nouvelles fonctionnalités pour l'administrateur
    public boolean creerCompte(Compte nouveauCompte, int idPersonne, List<Integer> idPermissions);
    public boolean modifierCompte(Compte compteAModifier);
    public boolean ajouterRoleACompte(int idCompte, int idPermission);
    public boolean retirerRoleDeCompte(int idCompte, int idPermission);
    public List<Role> listerRolesCompte(int idCompte);
    public boolean reinitialiserMotDePasse(int idCompte, String nouveauMotDePasse);
}
