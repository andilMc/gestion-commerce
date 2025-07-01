package services.logisticien.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Retourproduit;
import services.logisticien.remote.IGestionRetour;
import utils.Connexion;

@Stateless
public class GestionRetourImpl implements IGestionRetour {

    private final GenericDAO<Retourproduit> retourDAO;

    public GestionRetourImpl() {
        this.retourDAO = new GenericDAO<>(Retourproduit.class);
    }

    @Override
    public void addRetour(Retourproduit retour) {
        retourDAO.add(retour);
    }

    @Override
    public void updateRetour(Retourproduit retour) {
        retourDAO.update(retour);
    }

    @Override
    public void deleteRetour(int retourId) {
        Retourproduit retour = retourDAO.getById(retourId);
        if (retour != null) {
            retourDAO.delete(retour);
        }
    }

    @Override
    public Retourproduit getRetourById(int retourId) {
        return retourDAO.getById(retourId);
    }

    @Override
    public List<Retourproduit> getAllRetours() {
        return retourDAO.listAll();
    }
}
