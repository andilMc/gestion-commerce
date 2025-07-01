package services.gerant.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Detailvente;
import models.Vente;
import services.gerant.remote.IGestionVente;
import utils.Connexion;

@Stateless
public class GestionVenteImpl implements IGestionVente {

    private final GenericDAO<Vente> venteDAO;
    private final GenericDAO<Detailvente> detailVenteDAO;

    public GestionVenteImpl() {
        this.venteDAO = new GenericDAO<>(Vente.class);
        this.detailVenteDAO = new GenericDAO<>(Detailvente.class);
    }

    @Override
    public void addVente(Vente vente, List<Detailvente> detailsVente) {
        venteDAO.add(vente);
        for (Detailvente detail : detailsVente) {
            detailVenteDAO.add(detail);
        }
    }

    @Override
    public void updateVente(Vente vente) {
        venteDAO.update(vente);
    }

    @Override
    public void deleteVente(int venteId) {
        Vente vente = venteDAO.getById(venteId);
        if (vente != null) {
            venteDAO.delete(vente);
        }
    }

    @Override
    public Vente getVenteById(int venteId) {
        return venteDAO.getById(venteId);
    }

    @Override
    public List<Vente> getAllVentes() {
        return venteDAO.listAll();
    }

    @Override
    public List<Detailvente> getDetailsVente(int venteId) {
        return detailVenteDAO.findAllByField("vente.id", venteId);
    }
}
