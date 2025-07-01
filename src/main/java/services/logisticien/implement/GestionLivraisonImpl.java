package services.logisticien.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Livraison;
import services.logisticien.remote.IGestionLivraison;
import utils.Connexion;

@Stateless
public class GestionLivraisonImpl implements IGestionLivraison {

    private final GenericDAO<Livraison> livraisonDAO;

    public GestionLivraisonImpl() {
        this.livraisonDAO = new GenericDAO<>(Livraison.class);
    }

    @Override
    public void addLivraison(Livraison livraison) {
        livraisonDAO.add(livraison);
    }

    @Override
    public void updateLivraison(Livraison livraison) {
        livraisonDAO.update(livraison);
    }

    @Override
    public void deleteLivraison(int livraisonId) {
        Livraison livraison = livraisonDAO.getById(livraisonId);
        if (livraison != null) {
            livraisonDAO.delete(livraison);
        }
    }

    @Override
    public Livraison getLivraisonById(int livraisonId) {
        return livraisonDAO.getById(livraisonId);
    }

    @Override
    public List<Livraison> getAllLivraisons() {
        return livraisonDAO.listAll();
    }
}
