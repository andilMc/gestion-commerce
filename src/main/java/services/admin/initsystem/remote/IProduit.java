package services.admin.initsystem.remote;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface IProduit {
    public boolean ajoutProduit(int idFamille, String designation, String description, int idUnite,boolean etat);
    public boolean modifierProduit(String reference, String designation, String description, int idUnite,boolean etat);
    public boolean supprimerProduit(String reference);
    public boolean activerProduit(String reference);
    public boolean desactiverProduit(String reference);
    public List<List<?>> listerProduit();
    public List<List<?>> listerProduitActif();
    public List<List<?>> listerProduitDesactive();
    public List<List<?>> listerProduitParReference(String reference);
    public List<List<?>> listerProduitParDesignation(String designation);
    public List<List<?>> listerUniteMesureParProduit(String referenceProduit);
}
