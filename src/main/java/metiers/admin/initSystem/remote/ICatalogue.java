package metiers.admin.initSystem.remote;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface ICatalogue {
    public boolean ajoutCatalogue(String label, String description,boolean etat);
    public boolean modifierCatalogue(String reference, String label, String description,boolean etat);
    public boolean supprimerCatalogue(String reference);
    public boolean activerCatalogue(String reference);
    public boolean desactiverCatalogue(String reference);
    List<List<?>> listerCatalogue();
    List<List<?>> listerCatalogueActif();
    List<List<?>> listerCatalogueDesactive();
    List<List<?>> listerCatalogueParReference(String reference);
    List<List<?>> listerCatalogueParLabel(String label);
}
