package services.rh.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Payementsalaire;
import models.Salaire;
import services.rh.remote.IGestionSalaire;
import utils.Connexion;

@Stateless
public class GestionSalaireImpl implements IGestionSalaire {

    private final GenericDAO<Salaire> salaireDAO;
    private final GenericDAO<Payementsalaire> payementSalaireDAO;

    public GestionSalaireImpl() {
        this.salaireDAO = new GenericDAO<>(Salaire.class);
        this.payementSalaireDAO = new GenericDAO<>(Payementsalaire.class);
    }

    @Override
    public void addSalaire(Salaire salaire) {
        salaireDAO.add(salaire);
    }

    @Override
    public void updateSalaire(Salaire salaire) {
        salaireDAO.update(salaire);
    }

    @Override
    public void deleteSalaire(int salaireId) {
        Salaire salaire = salaireDAO.getById(salaireId);
        if (salaire != null) {
            salaireDAO.delete(salaire);
        }
    }

    @Override
    public Salaire getSalaireById(int salaireId) {
        return salaireDAO.getById(salaireId);
    }

    @Override
    public List<Salaire> getAllSalaires() {
        return salaireDAO.listAll();
    }

    @Override
    public void addPayementSalaire(Payementsalaire payementSalaire) {
        payementSalaireDAO.add(payementSalaire);
    }

    @Override
    public List<Payementsalaire> getPayementSalaireByEmploye(int employeId) {
        return payementSalaireDAO.findAllByField("employe.id", employeId);
    }
}
