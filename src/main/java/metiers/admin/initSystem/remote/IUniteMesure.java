package metiers.admin.initSystem.remote;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface IUniteMesure {
    public boolean ajoutUniteMesure(String libelle, String symbole);
    public boolean modifierUniteMesure(int idUnite, String libelle, String symbole);
    public boolean supprimerUniteMesure(int idUnite);
    public boolean activerUniteMesure(int idUnite);
    public boolean desactiverUniteMesure(int idUnite);
    public boolean lierUniteMesureProduit(String referenceProduit, int idUnite);
    public boolean delierUniteMesureProduit(String referenceProduit, int idUnite);
    public List<List<?>> listerUniteMesure();
    public List<List<?>> listerUniteMesureParIdUnite(int idUnite);
    public List<List<?>> listerUniteMesureParLibelle(String libelle);
    
}
