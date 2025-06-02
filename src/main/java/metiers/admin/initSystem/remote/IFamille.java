package metiers.admin.initSystem.remote;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface IFamille {
    public boolean ajoutFamille(int idCatalogue, String label, String description, boolean etat);
    public boolean modifierFamille(String reference, String label, String description, boolean etat);
    public boolean supprimerFamille(String reference);
    public boolean activerFamille(String reference);
    public boolean desactiverFamille(String reference);
    public List<List<?>> listerFamille();
    public List<List<?>> listerFamilleActif();
    public List<List<?>> listerFamilleDesactive();
    public List<List<?>> listerFamilleParReference(String reference);
    public List<List<?>> listerFamilleParLabel(String label);
}
