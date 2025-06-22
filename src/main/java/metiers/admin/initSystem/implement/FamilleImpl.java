package metiers.admin.initSystem.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import metiers.admin.initSystem.remote.IFamille;
import models.classes.Catalogue;
import models.classes.Famille;
import models.dao.GenericDAO;

@Stateless
public class FamilleImpl implements IFamille {
	
	private final GenericDAO<Famille> familleDao = new GenericDAO<>(Famille.class);
    private final GenericDAO<Catalogue> catalogueDao = new GenericDAO<>(Catalogue.class);

    @Override
    public boolean ajoutFamille(int idCatalogue, String label, String description, boolean etat) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'ajoutFamille'");
    	Catalogue catalogue = catalogueDao.findByField("idcatalogue", idCatalogue);
        if (catalogue == null) return false;

        Famille famille = new Famille();
        famille.setCatalogue(catalogue);
        famille.setLabel(label);
        famille.setDescription(description);
        famille.setEtat(etat);
        famille.setDatecreation(new Date());
        famille.setReference("REF-" + System.currentTimeMillis()); // simple unique ref

        familleDao.insert(famille);
        return true;
    }

    
    @Override
    public boolean modifierFamille(String reference, String label, String description, boolean etat) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'modifierFamille'");
    	Famille existing = familleDao.findByField("reference", reference);
        if (existing == null) return false;

        existing.setLabel(label);
        existing.setDescription(description);
        existing.setEtat(etat);

        familleDao.update(existing);
        return true;
    }

    @Override
    public boolean supprimerFamille(String reference) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'supprimerFamille'");
    	 return familleDao.deleteByField("reference", reference);
    }

    @Override
    public boolean activerFamille(String reference) {
        // TODO Auto-generated method stub
    	Famille famille = familleDao.findByField("reference", reference);
        if (famille == null) return false;

        famille.setEtat(true);
        familleDao.update(famille);
        return true;
    }

    @Override
    public boolean desactiverFamille(String reference) {
        // TODO Auto-generated method stub
    	 Famille famille = familleDao.findByField("reference", reference);
         if (famille == null) return false;

         famille.setEtat(false);
         familleDao.update(famille);
         return true;
    }

    @Override
    public List<List<?>> listerFamille() {
        // TODO Auto-generated method stub
    	List<Famille> familles = familleDao.listAll();
        return toListOfLists(familles);
    }

    @Override
    public List<List<?>> listerFamilleActif() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerFamilleActif'");
    }

    @Override
    public List<List<?>> listerFamilleDesactive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerFamilleDesactive'");
    }

    @Override
    public List<List<?>> listerFamilleParReference(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerFamilleParReference'");
    }

    @Override
    public List<List<?>> listerFamilleParLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerFamilleParLabel'");
    }
    
    
 // Méthode utilitaire pour transformer une Famille en List<Object>
    private List<Object> toList(Famille f) {
        return List.of(
            f.getReference(),
            f.getLabel(),
            f.getDescription(),
            f.getDatecreation(),
            f.getEtat(),
            f.getCatalogue() != null ? f.getCatalogue().getReference() : null
        );
    }

    // Méthode utilitaire pour transformer une liste de Famille
    private List<List<?>> toListOfLists(List<Famille> familles) {
        List<List<?>> result = new ArrayList<>();
        for (Famille f : familles) {
            result.add(toList(f));
        }
        return result;
    }

    
} 