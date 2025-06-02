package metiers.admin.initSystem.implement;

import java.util.List;
import jakarta.ejb.Stateless;
import metiers.admin.initSystem.remote.ICatalogue;

@Stateless
public class CatalogueImpl implements ICatalogue  {

    @Override
    public boolean ajoutCatalogue(String label, String description, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajoutCatalogue'");
    }

    @Override
    public boolean modifierCatalogue(String reference, String label, String description, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierCatalogue'");
    }

    @Override
    public boolean supprimerCatalogue(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimerCatalogue'");
    }

    @Override
    public boolean activerCatalogue(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activerCatalogue'");
    }

    @Override
    public boolean desactiverCatalogue(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desactiverCatalogue'");
    }

    @Override
    public List<List<?>> listerCatalogue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerCatalogue'");
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
