package services.client.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Produit;

@Remote
public interface IConsultationProduit {
    public Produit getProduitById(int produitId);
    public List<Produit> getAllProduits();
    public List<Produit> searchProduits(String keyword);
}
