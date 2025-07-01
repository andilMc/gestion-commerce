package services.comptable.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Rapportfinancier;
import services.comptable.remote.IGestionRapportFinancier;
import utils.Connexion;

@Stateless
public class GestionRapportFinancierImpl implements IGestionRapportFinancier {

    private final GenericDAO<Rapportfinancier> rapportFinancierDAO;

    public GestionRapportFinancierImpl() {
        this.rapportFinancierDAO = new GenericDAO<>(Rapportfinancier.class);
    }

    @Override
    public void addRapportFinancier(Rapportfinancier rapportFinancier) {
        rapportFinancierDAO.add(rapportFinancier);
    }

    @Override
    public void updateRapportFinancier(Rapportfinancier rapportFinancier) {
        rapportFinancierDAO.update(rapportFinancier);
    }

    @Override
    public void deleteRapportFinancier(int rapportFinancierId) {
        Rapportfinancier rapportFinancier = rapportFinancierDAO.getById(rapportFinancierId);
        if (rapportFinancier != null) {
            rapportFinancierDAO.delete(rapportFinancier);
        }
    }

    @Override
    public Rapportfinancier getRapportFinancierById(int rapportFinancierId) {
        return rapportFinancierDAO.getById(rapportFinancierId);
    }

    @Override
    public List<Rapportfinancier> getAllRapportFinanciers() {
        return rapportFinancierDAO.listAll();
    }
}
