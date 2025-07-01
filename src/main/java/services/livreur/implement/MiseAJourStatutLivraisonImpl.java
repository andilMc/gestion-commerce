package services.livreur.implement;

import jakarta.ejb.Stateless;

import dao.GenericDAO;
import models.Livraison;
import services.livreur.remote.IMiseAJourStatutLivraison;

@Stateless
public class MiseAJourStatutLivraisonImpl implements IMiseAJourStatutLivraison {

    private final GenericDAO<Livraison> livraisonDAO;

    public MiseAJourStatutLivraisonImpl() {
        this.livraisonDAO = new GenericDAO<>(Livraison.class);
    }

    @Override
    public void updateStatutLivraison(Livraison livraison) {
        livraisonDAO.update(livraison);
    }
}
