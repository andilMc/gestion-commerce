package services.livreur.remote;

import jakarta.ejb.Remote;

import models.Livraison;

@Remote
public interface IMiseAJourStatutLivraison {
    public void updateStatutLivraison(Livraison livraison);
}
