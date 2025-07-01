package services.client.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Detailvente;
import models.Vente;

@Remote
public interface IGestionCommande {
    public void passerCommande(Vente vente, List<Detailvente> detailsVente);
    public List<Vente> getHistoriqueCommandes(int clientId);
    public Vente getCommandeById(int commandeId);
}
