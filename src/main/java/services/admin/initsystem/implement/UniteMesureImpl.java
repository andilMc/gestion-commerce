package services.admin.initsystem.implement;

import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import services.admin.initsystem.remote.IUniteMesure;
import dao.GenericDAO;
import models.Assoproduitunite;
import models.AssoproduituniteId;
import models.Produit;
import models.Unitemesure;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Connexion;

@Stateless
public class UniteMesureImpl implements IUniteMesure {

    private final GenericDAO<Unitemesure> uniteMesureDAO;
    private final GenericDAO<Produit> produitDAO;
    private final GenericDAO<Assoproduitunite> assoproduituniteDAO;

    public UniteMesureImpl() {
        this.uniteMesureDAO = new GenericDAO<>(Unitemesure.class);
        this.produitDAO = new GenericDAO<>(Produit.class);
        this.assoproduituniteDAO = new GenericDAO<>(Assoproduitunite.class);
    }

    @Override
    public boolean ajoutUniteMesure(String libelle, String symbole) {
        Unitemesure uniteMesure = new Unitemesure();
        uniteMesure.setLibelle(libelle);
        uniteMesure.setSymbole(symbole);
        uniteMesureDAO.add(uniteMesure);
        return true;
    }

    @Override
    public boolean modifierUniteMesure(Unitemesure uniteMesure) {
        if (uniteMesure != null) {
            uniteMesureDAO.update(uniteMesure);
            return true;
        }
        return false;
    }

    @Override
    public boolean supprimerUniteMesure(int idUnite) {
        Unitemesure um = uniteMesureDAO.getById(idUnite);
        if (um != null) {
            uniteMesureDAO.delete(um);
            return true;
        }
        return false;
    }

    @Override
    public boolean activerUniteMesure(int idUnite) {
        // Assuming 'etat' field in UniteMesure if it exists, otherwise this method might not be applicable
        // For now, we'll assume no 'etat' field for simplicity or it's handled differently
        System.out.println("Activer UniteMesure not implemented as 'etat' field is not clear.");
        return false;
    }

    @Override
    public boolean desactiverUniteMesure(int idUnite) {
        // Assuming 'etat' field in UniteMesure if it exists, otherwise this method might not be applicable
        // For now, we'll assume no 'etat' field for simplicity or it's handled differently
        System.out.println("Desactiver UniteMesure not implemented as 'etat' field is not clear.");
        return false;
    }

    @Override
    public boolean lierUniteMesureProduit(String referenceProduit, int idUnite) {
        Produit produit = produitDAO.findByFieldWithAssociations("reference", referenceProduit);
        Unitemesure uniteMesure = uniteMesureDAO.getById(idUnite);

        if (produit != null && uniteMesure != null) {
            Assoproduitunite assoproduitunite = new Assoproduitunite();
            assoproduitunite.setProduit(produit);
            assoproduitunite.setUnitemesure(uniteMesure);
            assoproduitunite.setDate(new Date());
            assoproduituniteDAO.add(assoproduitunite);
            return true;
        }
        return false;
    }

    @Override
    public boolean delierUniteMesureProduit(String referenceProduit, int idUnite) {
        Produit produit = produitDAO.findByFieldWithAssociations("reference", referenceProduit);
        Unitemesure uniteMesure = uniteMesureDAO.getById(idUnite);

        if (produit != null && uniteMesure != null) {
            // Assuming AssoproduituniteId has a constructor that takes product ID and unite ID
            AssoproduituniteId assoproduituniteId = new AssoproduituniteId(produit.getIdproduit(), uniteMesure.getIdunite());
            Assoproduitunite assoproduitunite = assoproduituniteDAO.getById(assoproduituniteId);
            if (assoproduitunite != null) {
                assoproduituniteDAO.delete(assoproduitunite);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Unitemesure> listerUniteMesure() {
        return uniteMesureDAO.listAll();
    }

    @Override
    public Unitemesure listerUniteMesureParIdUnite(int idUnite) {
        return uniteMesureDAO.getById(idUnite);
    }

    @Override
    public List<Unitemesure> listerUniteMesureParLibelle(String libelle) {
        return uniteMesureDAO.findAllByField("libelle", libelle);
    }
}
