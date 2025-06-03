package metiers.admin.initSystem.implement;

import java.util.Date;
import java.util.List;

import javax.xml.crypto.dsig.Transform;

import jakarta.ejb.Stateless;
import metiers.admin.initSystem.remote.ICatalogue;
import models.classes.Catalogue;
import models.dao.GenericDAO;

@Stateless
public class CatalogueImpl implements ICatalogue  {
	
	private GenericDAO<Catalogue> dao = new GenericDAO<>(Catalogue.class);


    @Override
    public boolean ajoutCatalogue(String label, String description, boolean etat) {
        // TODO Auto-generated method stub
    	try {
            Catalogue c = new Catalogue();
            c.setLabel(label);
            c.setDescription(description);
            c.setEtat(etat);
            c.setDatecreation(new Date());
            c.setReference("CAT-" + System.currentTimeMillis()); // exemple de génération de référence
            dao.insert(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
       
        
    }

    
    @Override
    public boolean modifierCatalogue(String reference, String label, String description, boolean etat) {
        // TODO Auto-generated method stub
    	try {
            Catalogue old = dao.findByField("reference", reference);
            if (old != null) {
                old.setLabel(label);
                old.setDescription(description);
                old.setEtat(etat);
                dao.update(old);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    

    @Override
    public boolean supprimerCatalogue(String reference) {
        // TODO Auto-generated method stub
    	return dao.deleteByField("reference", reference);
    }

    @Override
    public boolean activerCatalogue(String reference) {
        // TODO Auto-generated method stub
    	Catalogue c = dao.findByField("reference", reference);
        if (c != null && !c.getEtat()) {
            c.setEtat(true);
            dao.update(c);
            return true;
        }
        return false;
    }

    @Override
    public boolean desactiverCatalogue(String reference) {
        // TODO Auto-generated method stub
    	Catalogue c = dao.findByField("reference", reference);
        if (c != null && c.getEtat()) {
            c.setEtat(false);
            dao.update(c);
            return true;
        }
        return false;
    }

    @Override
    public List<List<?>> listerCatalogue() {
        // TODO Auto-generated method stub
    	List<Catalogue> list = dao.listAll();
    	List<List<?>> result = new java.util.ArrayList<>();
        for (Catalogue cat : list) {
            List<Object> ligne = new java.util.ArrayList<>();
            ligne.add(cat.getIdcatalogue());
            ligne.add(cat.getReference());
            ligne.add(cat.getLabel());
            ligne.add(cat.getDescription());
            ligne.add(cat.getDatecreation());
            ligne.add(cat.getEtat());
            result.add(ligne);
        }
        return result;
    }


	@Override
    public List<List<?>> listerCatalogueActif() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerCatalogueActif'");
    }

    @Override
    public List<List<?>> listerCatalogueDesactive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerCatalogueDesactive'");
    }

    @Override
    public List<List<?>> listerCatalogueParReference(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerCatalogueParReference'");
    }

    @Override
    public List<List<?>> listerCatalogueParLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerCatalogueParLabel'");
    }
    
}
