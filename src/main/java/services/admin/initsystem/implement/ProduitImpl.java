package services.admin.initsystem.implement;

import java.util.List;
import jakarta.ejb.Stateless;
import services.admin.initsystem.remote.IProduit;

@Stateless
public class ProduitImpl implements IProduit {

    @Override
    public boolean ajoutProduit(int idFamille, String designation, String description, int idUnite, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajoutProduit'");
    }

    @Override
    public boolean modifierProduit(String reference, String designation, String description, int idUnite,
            boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierProduit'");
    }

    @Override
    public boolean supprimerProduit(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimerProduit'");
    }

    @Override
    public boolean activerProduit(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activerProduit'");
    }

    @Override
    public boolean desactiverProduit(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desactiverProduit'");
    }

    @Override
    public List<List<?>> listerProduit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerProduit'");
    }

    @Override
    public List<List<?>> listerProduitActif() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerProduitActif'");
    }

    @Override
    public List<List<?>> listerProduitDesactive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerProduitDesactive'");
    }

    @Override
    public List<List<?>> listerProduitParReference(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerProduitParReference'");
    }

    @Override
    public List<List<?>> listerProduitParDesignation(String designation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerProduitParDesignation'");
    }

    @Override
    public List<List<?>> listerUniteMesureParProduit(String referenceProduit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerUniteMesureParProduit'");
    }
   
}
