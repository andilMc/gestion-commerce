package services.admin.initsystem.remote;

import java.util.List;

import jakarta.ejb.Remote;
import models.Famille;

@Remote
public interface IFamille {
    public boolean ajoutFamille(int idCatalogue, String label, String description, boolean etat);
    public boolean modifierFamille(Famille famille);
    public boolean supprimerFamille(String reference);
    public boolean activerFamille(String reference);
    public boolean desactiverFamille(String reference);
    public List<Famille> listerFamille();
    public List<Famille> listerFamilleActif();
    public List<Famille> listerFamilleDesactive();
    public Famille listerFamilleParReference(String reference);
    public List<Famille> listerFamilleParLabel(String label);
}
