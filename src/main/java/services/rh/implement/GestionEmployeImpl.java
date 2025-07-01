package services.rh.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Collaborateur;
import models.Employer;
import services.rh.remote.IGestionEmploye;
import utils.Connexion;

@Stateless
public class GestionEmployeImpl implements IGestionEmploye {

    private final GenericDAO<Employer> employeDAO;
    private final GenericDAO<Collaborateur> collaborateurDAO;

    public GestionEmployeImpl() {
        this.employeDAO = new GenericDAO<>(Employer.class);
        this.collaborateurDAO = new GenericDAO<>(Collaborateur.class);
    }

    @Override
    public void addEmploye(Employer employe, Collaborateur collaborateur) {
        employeDAO.add(employe);
        collaborateurDAO.add(collaborateur);
    }

    @Override
    public void updateEmploye(Employer employe, Collaborateur collaborateur) {
        employeDAO.update(employe);
        collaborateurDAO.update(collaborateur);
    }

    @Override
    public void deleteEmploye(int employeId) {
        Employer employe = employeDAO.getById(employeId);
        if (employe != null) {
            employeDAO.delete(employe);
        }
    }

    @Override
    public Employer getEmployeById(int employeId) {
        return employeDAO.getById(employeId);
    }

    @Override
    public List<Employer> getAllEmployes() {
        return employeDAO.listAll();
    }
}
