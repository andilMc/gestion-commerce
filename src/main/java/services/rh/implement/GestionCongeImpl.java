package services.rh.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Conge;
import services.rh.remote.IGestionConge;
import utils.Connexion;

@Stateless
public class GestionCongeImpl implements IGestionConge {

    private final GenericDAO<Conge> congeDAO;

    public GestionCongeImpl() {
        this.congeDAO = new GenericDAO<>(Conge.class);
    }

    @Override
    public void addConge(Conge conge) {
        congeDAO.add(conge);
    }

    @Override
    public void updateConge(Conge conge) {
        congeDAO.update(conge);
    }

    @Override
    public void deleteConge(int congeId) {
        Conge conge = congeDAO.getById(congeId);
        if (conge != null) {
            congeDAO.delete(conge);
        }
    }

    @Override
    public Conge getCongeById(int congeId) {
        return congeDAO.getById(congeId);
    }

    @Override
    public List<Conge> getAllConges() {
        return congeDAO.listAll();
    }
}
