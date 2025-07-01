package services.livreur.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Livraison;

@Remote
public interface IGestionLivraisonLivreur {
    public List<Livraison> getLivraisonsByLivreur(int livreurId);
    public Livraison getLivraisonById(int livraisonId);
}
