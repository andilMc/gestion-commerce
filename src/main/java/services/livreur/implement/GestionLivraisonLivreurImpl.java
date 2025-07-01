package services.livreur.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Livraison;
import services.livreur.remote.IGestionLivraisonLivreur;
import utils.Connexion;

@Stateless
public class GestionLivraisonLivreurImpl implements IGestionLivraisonLivreur {

    private final GenericDAO<Livraison> livraisonDAO;

    public GestionLivraisonLivreurImpl() {
        this.livraisonDAO = new GenericDAO<>(Livraison.class);
    }

    @Override
    public List<Livraison> getLivraisonsByLivreur(int livreurId) {
        return livraisonDAO.findAllByField("livreur.id", livreurId);
    }

    @Override
    public Livraison getLivraisonById(int livraisonId) {
        return livraisonDAO.getById(livraisonId);
    }
}
