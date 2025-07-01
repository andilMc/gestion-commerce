package services.gerant.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Caisse;
import services.gerant.remote.IGestionCaisse;
import utils.Connexion;

@Stateless
public class GestionCaisseImpl implements IGestionCaisse {

    private final GenericDAO<Caisse> caisseDAO;

    public GestionCaisseImpl() {
        this.caisseDAO = new GenericDAO<>(Caisse.class);
    }

    @Override
    public void addCaisse(Caisse caisse) {
        caisseDAO.add(caisse);
    }

    @Override
    public void updateCaisse(Caisse caisse) {
        caisseDAO.update(caisse);
    }

    @Override
    public void deleteCaisse(int caisseId) {
        Caisse caisse = caisseDAO.getById(caisseId);
        if (caisse != null) {
            caisseDAO.delete(caisse);
        }
    }

    @Override
    public Caisse getCaisseById(int caisseId) {
        return caisseDAO.getById(caisseId);
    }

    @Override
    public List<Caisse> getAllCaisses() {
        return caisseDAO.listAll();
    }
}
