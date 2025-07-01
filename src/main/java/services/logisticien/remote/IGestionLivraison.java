package services.logisticien.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Livraison;

@Remote
public interface IGestionLivraison {
    public void addLivraison(Livraison livraison);
    public void updateLivraison(Livraison livraison);
    public void deleteLivraison(int livraisonId);
    public Livraison getLivraisonById(int livraisonId);
    public List<Livraison> getAllLivraisons();
}
