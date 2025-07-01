package services.admin.initsystem.implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import jakarta.ejb.Stateless;
import models.Catalogue;
import services.admin.initsystem.remote.ICatalogue;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.GenericDAO;
import utils.Connexion;

@Stateless
public class CatalogueImpl implements ICatalogue  {
	
	private final GenericDAO<Catalogue> dao;

    public CatalogueImpl() {
        this.dao = new GenericDAO<>(Catalogue.class);
    }


    @Override
    public boolean ajoutCatalogue(String label, String description, boolean etat) {
        try {
            Catalogue c = new Catalogue();
            c.setLabel(label);
            c.setDescription(description);
            c.setEtat(etat);
            c.setDatecreation(new Date());
            c.setReference("CAT-" + System.currentTimeMillis()); // exemple de génération de référence
            dao.add(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    @Override
    public boolean modifierCatalogue(Catalogue catalogue) {
        try {
            if (catalogue != null) {
                dao.update(catalogue);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    

    @Override
    public boolean supprimerCatalogue(String reference) {
        try {
            Catalogue c = dao.findAllByField("reference", reference).stream().findFirst().orElse(null);
            if (c != null) {
                dao.delete(c);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean activerCatalogue(String reference) {
        try {
            Catalogue c = dao.findAllByField("reference", reference).stream().findFirst().orElse(null);
            if (c != null && !c.getEtat()) {
                c.setEtat(true);
                dao.update(c);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean desactiverCatalogue(String reference) {
        try {
            Catalogue c = dao.findAllByField("reference", reference).stream().findFirst().orElse(null);
            if (c != null && c.getEtat()) {
                c.setEtat(false);
                dao.update(c);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Catalogue> listerCatalogue() {
        try {
            return dao.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


	@Override
    public List<Catalogue> listerCatalogueActif() {
        try {
            return dao.findAllByField("etat", true);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Catalogue> listerCatalogueDesactive() {
        try {
            return dao.findAllByField("etat", false);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Catalogue listerCatalogueParReference(String reference) {
        try {
            return dao.findAllByField("reference", reference).stream().findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    @Override
    public List<Catalogue> listerCatalogueParLabel(String label) {
        try {
            return dao.findAllByField("label", label);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    
}
