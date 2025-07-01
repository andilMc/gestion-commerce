package services.client.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Detailvente;
import models.Vente;
import services.client.remote.IGestionCommande;
import utils.Connexion;

@Stateless
public class GestionCommandeImpl implements IGestionCommande {

    private final GenericDAO<Vente> venteDAO;
    private final GenericDAO<Detailvente> detailVenteDAO;

    public GestionCommandeImpl() {
        this.venteDAO = new GenericDAO<>(Vente.class);
        this.detailVenteDAO = new GenericDAO<>(Detailvente.class);
    }

    @Override
    public void passerCommande(Vente vente, List<Detailvente> detailsVente) {
        venteDAO.add(vente);
        for (Detailvente detail : detailsVente) {
            detailVenteDAO.add(detail);
        }
    }

    @Override
    public List<Vente> getHistoriqueCommandes(int clientId) {
        return venteDAO.findAllByField("client.id", clientId);
    }

    @Override
    public Vente getCommandeById(int commandeId) {
        return venteDAO.getById(commandeId);
    }
}
