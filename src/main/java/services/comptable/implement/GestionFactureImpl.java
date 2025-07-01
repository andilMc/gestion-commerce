package services.comptable.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Facture;
import services.comptable.remote.IGestionFacture;
import utils.Connexion;

@Stateless
public class GestionFactureImpl implements IGestionFacture {

    private final GenericDAO<Facture> factureDAO;

    public GestionFactureImpl() {
        this.factureDAO = new GenericDAO<>(Facture.class);
    }

    @Override
    public void addFacture(Facture facture) {
        factureDAO.add(facture);
    }

    @Override
    public void updateFacture(Facture facture) {
        factureDAO.update(facture);
    }

    @Override
    public void deleteFacture(int factureId) {
        Facture facture = factureDAO.getById(factureId);
        if (facture != null) {
            factureDAO.delete(facture);
        }
    }

    @Override
    public Facture getFactureById(int factureId) {
        return factureDAO.getById(factureId);
    }

    @Override
    public List<Facture> getAllFactures() {
        return factureDAO.listAll();
    }
}
