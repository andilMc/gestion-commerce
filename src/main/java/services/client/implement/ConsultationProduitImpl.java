package services.client.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Produit;
import services.client.remote.IConsultationProduit;
import utils.Connexion;

@Stateless
public class ConsultationProduitImpl implements IConsultationProduit {

    private final GenericDAO<Produit> produitDAO;

    public ConsultationProduitImpl() {
        this.produitDAO = new GenericDAO<>(Produit.class);
    }

    @Override
    public Produit getProduitById(int produitId) {
        return produitDAO.getById(produitId);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitDAO.listAll();
    }

    @Override
    public List<Produit> searchProduits(String keyword) {
        return produitDAO.findAllByField("nom", keyword);
    }
}
