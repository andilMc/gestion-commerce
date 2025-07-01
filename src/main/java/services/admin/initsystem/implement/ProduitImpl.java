package services.admin.initsystem.implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.ejb.Stateless;
import services.admin.initsystem.remote.IProduit;
import dao.GenericDAO;
import models.Assoproduitunite;
import models.AssoproduituniteId;
import models.Famille;
import models.Produit;
import models.Unitemesure;

@Stateless
public class ProduitImpl implements IProduit {

    private final GenericDAO<Produit> produitDAO;
    private final GenericDAO<Famille> familleDAO;
    private final GenericDAO<Unitemesure> uniteMesureDAO;
    private final GenericDAO<Assoproduitunite> assoproduituniteDAO;

    public ProduitImpl() {
        this.produitDAO = new GenericDAO<>(Produit.class);
        this.familleDAO = new GenericDAO<>(Famille.class);
        this.uniteMesureDAO = new GenericDAO<>(Unitemesure.class);
        this.assoproduituniteDAO = new GenericDAO<>(Assoproduitunite.class);
    }

    @Override
    public boolean ajoutProduit(int idFamille, String designation, String description, int idUnite, boolean etat) {
        try {
            Famille famille = familleDAO.getById(idFamille);
            if (famille == null) {
                System.err.println("Famille with ID " + idFamille + " not found.");
                return false;
            }

            Unitemesure uniteMesure = uniteMesureDAO.getById(idUnite);
            if (uniteMesure == null) {
                System.err.println("UniteMesure with ID " + idUnite + " not found.");
                return false;
            }

            Produit produit = new Produit();
            produit.setFamille(famille);
            produit.setDesignation(designation);
            produit.setDescription(description);
            produit.setEtat(etat);
            produit.setDatecreation(new Date());
            produit.setReference("PROD-" + System.currentTimeMillis());
            produitDAO.add(produit);

            // Associer l'unité de mesure au produit
            Assoproduitunite assoproduitunite = new Assoproduitunite();
            // Créer et définir la clé composite
            AssoproduituniteId assoproduituniteId = new AssoproduituniteId(uniteMesure.getIdunite(), produit.getIdproduit());
            assoproduitunite.setId(assoproduituniteId);
            
            assoproduitunite.setProduit(produit);
            assoproduitunite.setUnitemesure(uniteMesure);
            assoproduitunite.setDate(new Date());
            assoproduituniteDAO.add(assoproduitunite);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierProduit(Produit produit) {
        try {
            if (produit != null) {
                produitDAO.update(produit);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerProduit(String reference) {
        try {
            Produit p = produitDAO.findAllByField("reference", reference).stream().findFirst().orElse(null);
            if (p != null) {
                produitDAO.delete(p);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean activerProduit(String reference) {
        try {
            Produit produit = produitDAO.findAllByField("reference", reference).stream().findFirst().orElse(null);
            if (produit != null && !produit.getEtat()) {
                produit.setEtat(true);
                produitDAO.update(produit);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean desactiverProduit(String reference) {
        try {
            Produit produit = produitDAO.findAllByField("reference", reference).stream().findFirst().orElse(null);
            if (produit != null && produit.getEtat()) {
                produit.setEtat(false);
                produitDAO.update(produit);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Produit> listerProduit() {
        try {
            return produitDAO.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Produit> listerProduitActif() {
        try {
            return produitDAO.findAllByField("etat", true);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Produit> listerProduitDesactive() {
        try {
            return produitDAO.findAllByField("etat", false);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Produit listerProduitParReference(String reference) {
        try {
            return produitDAO.findAllByField("reference", reference).stream().findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Produit> listerProduitParDesignation(String designation) {
        try {
            return produitDAO.findAllByField("designation", designation);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Unitemesure> listerUniteMesureParProduit(String referenceProduit) {
        try {
            Produit produit = produitDAO.findAllByField("reference", referenceProduit).stream().findFirst().orElse(null);
            if (produit != null) {
                Set<Assoproduitunite> assos = produit.getAssoproduitunites();
                List<Unitemesure> unites = new ArrayList<>();
                for (Assoproduitunite asso : assos) {
                    unites.add(asso.getUnitemesure());
                }
                return unites;
            }
            return Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
