package services.admin.initsystem.implement;

import java.util.List;

import jakarta.ejb.Stateless;
import services.admin.initsystem.remote.IFamille;

@Stateless
public class FamilleImpl implements IFamille {

    @Override
    public boolean ajoutFamille(int idCatalogue, String label, String description, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajoutFamille'");
    }

    @Override
    public boolean modifierFamille(String reference, String label, String description, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierFamille'");
    }

    @Override
    public boolean supprimerFamille(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimerFamille'");
    }

    @Override
    public boolean activerFamille(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activerFamille'");
    }

    @Override
    public boolean desactiverFamille(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desactiverFamille'");
    }

    @Override
    public List<List<?>> listerFamille() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerFamille'");
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

    
} 