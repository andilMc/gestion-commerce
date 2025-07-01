package services.admin.initsystem.remote;

import java.util.List;

import jakarta.ejb.Remote;
import models.Catalogue;

@Remote
public interface ICatalogue {
    public boolean ajoutCatalogue(String label, String description, boolean etat);
    public boolean modifierCatalogue(Catalogue catalogue);
    public boolean supprimerCatalogue(String reference);
    public boolean activerCatalogue(String reference);
    public boolean desactiverCatalogue(String reference);
    List<Catalogue> listerCatalogue();
    List<Catalogue> listerCatalogueActif();
    List<Catalogue> listerCatalogueDesactive();
    Catalogue listerCatalogueParReference(String reference);
    List<Catalogue> listerCatalogueParLabel(String label);
}
