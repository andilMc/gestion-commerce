package services.rh.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Contrattravail;
import services.rh.remote.IGestionContrat;
import utils.Connexion;

@Stateless
public class GestionContratImpl implements IGestionContrat {

    private final GenericDAO<Contrattravail> contratDAO;

    public GestionContratImpl() {
        this.contratDAO = new GenericDAO<>(Contrattravail.class);
    }

    @Override
    public void addContrat(Contrattravail contrat) {
        contratDAO.add(contrat);
    }

    @Override
    public void updateContrat(Contrattravail contrat) {
        contratDAO.update(contrat);
    }

    @Override
    public void deleteContrat(int contratId) {
        Contrattravail contrat = contratDAO.getById(contratId);
        if (contrat != null) {
            contratDAO.delete(contrat);
        }
    }

    @Override
    public Contrattravail getContratById(int contratId) {
        return contratDAO.getById(contratId);
    }

    @Override
    public List<Contrattravail> getAllContrats() {
        return contratDAO.listAll();
    }
}
