package services.admin.initsystem.remote;

import java.util.List;

import jakarta.ejb.Remote;
import models.Unitemesure;

@Remote
public interface IUniteMesure {
    public boolean ajoutUniteMesure(String libelle, String symbole);
    public boolean modifierUniteMesure(Unitemesure uniteMesure);
    public boolean supprimerUniteMesure(int idUnite);
    public boolean activerUniteMesure(int idUnite);
    public boolean desactiverUniteMesure(int idUnite);
    public boolean lierUniteMesureProduit(String referenceProduit, int idUnite);
    public boolean delierUniteMesureProduit(String referenceProduit, int idUnite);
    public List<Unitemesure> listerUniteMesure();
    public Unitemesure listerUniteMesureParIdUnite(int idUnite);
    public List<Unitemesure> listerUniteMesureParLibelle(String libelle);
    
}
