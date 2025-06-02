package metiers.admin.initSystem.remote;

import java.util.List;

public interface ITypeVariete {
    public boolean ajoutTypeVariete(String label, String typeValeur, boolean etat);
    public boolean modifierTypeVariete(int idTypeVariete, String label, String typeValeur, boolean etat);
    public boolean supprimerTypeVariete(int idTypeVariete);
    public boolean activerTypeVariete(int idTypeVariete);
    public boolean desactiverTypeVariete(int idTypeVariete);
    public boolean lierTypeVarieteArticle(int idArticle, int idTypeVariete);
    public boolean delierTypeVarieteArticle(int idArticle, int idTypeVariete);
    public List<List<?>> listerTypeVariete();
    public List<List<?>> listerTypeVarieteParId(int idTypeVariete);
    public List<List<?>> listerTypeVarieteParLabel(String label);
}
