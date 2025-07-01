package services.admin.initsystem.remote;

import java.util.List;

import models.Typevariete;

public interface ITypeVariete {
    public boolean ajoutTypeVariete(String label, String typeValeur, String etat);
    public boolean modifierTypeVariete(Typevariete typeVariete);
    public boolean supprimerTypeVariete(int idTypeVariete);
    public boolean activerTypeVariete(int idTypeVariete);
    public boolean desactiverTypeVariete(int idTypeVariete);
    public boolean lierTypeVarieteArticle(int idArticle, int idTypeVariete);
    public boolean delierTypeVarieteArticle(int idArticle, int idTypeVariete);
    public List<Typevariete> listerTypeVariete();
    public Typevariete listerTypeVarieteParId(int idTypeVariete);
    public List<Typevariete> listerTypeVarieteParLabel(String label);
}
