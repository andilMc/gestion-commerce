package services.admin.initsystem.implement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Connexion;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import services.admin.initsystem.remote.IFamille;
import dao.GenericDAO;
import models.Catalogue;
import models.Famille;

@Stateless
public class FamilleImpl implements IFamille {

    private final GenericDAO<Famille> familleDAO;
    private final GenericDAO<Catalogue> catalogueDAO;

    public FamilleImpl() {
        this.familleDAO = new GenericDAO<>(Famille.class);
        this.catalogueDAO = new GenericDAO<>(Catalogue.class);
    }

    @Override
    public boolean ajoutFamille(int idCatalogue, String label, String description, boolean etat) {
        try {
            Catalogue catalogue = catalogueDAO.getById(idCatalogue);
            if (catalogue == null) {
                System.err.println("Catalogue with ID " + idCatalogue + " not found.");
                return false;
            }

            Famille famille = new Famille();
            famille.setCatalogue(catalogue);
            famille.setLabel(label);
            famille.setDescription(description);
            famille.setEtat(etat);
            famille.setDatecreation(new Date());
            famille.setReference("FAM-" + System.currentTimeMillis());
            familleDAO.add(famille);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierFamille(Famille famille) {
        try {
            if (famille != null) {
                familleDAO.update(famille);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerFamille(String reference) {
        try {
            Famille f = familleDAO.findAllByField("reference", reference).stream().findFirst().orElse(null);
            if (f != null) {
                familleDAO.delete(f);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean activerFamille(String reference) {
        try {
            Famille famille = familleDAO.findAllByField("reference", reference).stream().findFirst().orElse(null);
            if (famille != null && !famille.getEtat()) {
                famille.setEtat(true);
                familleDAO.update(famille);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean desactiverFamille(String reference) {
        try {
            Famille famille = familleDAO.findAllByField("reference", reference).stream().findFirst().orElse(null);
            if (famille != null && famille.getEtat()) {
                famille.setEtat(false);
                familleDAO.update(famille);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Famille> listerFamille() {
        try {
            return familleDAO.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Famille> listerFamilleActif() {
        try {
            return familleDAO.findAllByField("etat", true);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Famille> listerFamilleDesactive() {
        try {
            return familleDAO.findAllByField("etat", false);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Famille listerFamilleParReference(String reference) {
        try {
            return familleDAO.findAllByField("reference", reference).stream().findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Famille> listerFamilleParLabel(String label) {
        try {
            return familleDAO.findAllByField("label", label);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
 