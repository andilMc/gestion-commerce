package metiers.admin.initSystem.implement;

import java.util.List;
import jakarta.ejb.Stateless;
import metiers.admin.initSystem.remote.IUniteMesure;

@Stateless
public class UniteMesureImpl implements IUniteMesure {

    @Override
    public boolean ajoutUniteMesure(String libelle, String symbole) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajoutUniteMesure'");
    }

    @Override
    public boolean modifierUniteMesure(int idUnite, String libelle, String symbole) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierUniteMesure'");
    }

    @Override
    public boolean supprimerUniteMesure(int idUnite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimerUniteMesure'");
    }

    @Override
    public boolean activerUniteMesure(int idUnite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activerUniteMesure'");
    }

    @Override
    public boolean desactiverUniteMesure(int idUnite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desactiverUniteMesure'");
    }

    @Override
    public boolean lierUniteMesureProduit(String referenceProduit, int idUnite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lierUniteMesureProduit'");
    }

    @Override
    public boolean delierUniteMesureProduit(String referenceProduit, int idUnite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delierUniteMesureProduit'");
    }

    @Override
    public List<List<?>> listerUniteMesure() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerUniteMesure'");
    }

    @Override
    public List<List<?>> listerUniteMesureParIdUnite(int idUnite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerUniteMesureParIdUnite'");
    }

    @Override
    public List<List<?>> listerUniteMesureParLibelle(String libelle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerUniteMesureParLibelle'");
    }
   
    
}
