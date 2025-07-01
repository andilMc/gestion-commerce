package services.comptable.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Paiement;
import services.comptable.remote.IGestionPaiement;
import utils.Connexion;

@Stateless
public class GestionPaiementImpl implements IGestionPaiement {

    private final GenericDAO<Paiement> paiementDAO;

    public GestionPaiementImpl() {
        this.paiementDAO = new GenericDAO<>(Paiement.class);
    }

    @Override
    public void addPaiement(Paiement paiement) {
        paiementDAO.add(paiement);
    }

    @Override
    public void updatePaiement(Paiement paiement) {
        paiementDAO.update(paiement);
    }

    @Override
    public void deletePaiement(int paiementId) {
        Paiement paiement = paiementDAO.getById(paiementId);
        if (paiement != null) {
            paiementDAO.delete(paiement);
        }
    }

    @Override
    public Paiement getPaiementById(int paiementId) {
        return paiementDAO.getById(paiementId);
    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementDAO.listAll();
    }
}
