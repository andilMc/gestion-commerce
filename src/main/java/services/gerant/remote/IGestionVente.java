package services.gerant.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Detailvente;
import models.Vente;

@Remote
public interface IGestionVente {
    public void addVente(Vente vente, List<Detailvente> detailsVente);
    public void updateVente(Vente vente);
    public void deleteVente(int venteId);
    public Vente getVenteById(int venteId);
    public List<Vente> getAllVentes();
    public List<Detailvente> getDetailsVente(int venteId);
}
