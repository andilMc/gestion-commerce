package metiers.admin.initSystem.implement;

import java.util.List;

import jakarta.ejb.Stateless;
import metiers.admin.initSystem.remote.ITypeVariete;

@Stateless
public class TypeVarieteImpl implements ITypeVariete{

    @Override
    public boolean ajoutTypeVariete(String label, String typeValeur, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajoutTypeVariete'");
    }

    @Override
    public boolean modifierTypeVariete(int idTypeVariete, String label, String typeValeur, boolean etat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierTypeVariete'");
    }

    @Override
    public boolean supprimerTypeVariete(int idTypeVariete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimerTypeVariete'");
    }

    @Override
    public boolean activerTypeVariete(int idTypeVariete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activerTypeVariete'");
    }

    @Override
    public boolean desactiverTypeVariete(int idTypeVariete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desactiverTypeVariete'");
    }

    @Override
    public boolean lierTypeVarieteArticle(int idArticle, int idTypeVariete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lierTypeVarieteArticle'");
    }

    @Override
    public boolean delierTypeVarieteArticle(int idArticle, int idTypeVariete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delierTypeVarieteArticle'");
    }

    @Override
    public List<List<?>> listerTypeVariete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerTypeVariete'");
    }

    @Override
    public List<List<?>> listerTypeVarieteParId(int idTypeVariete) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerTypeVarieteParId'");
    }

    @Override
    public List<List<?>> listerTypeVarieteParLabel(String label) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerTypeVarieteParLabel'");
    }
    
}
