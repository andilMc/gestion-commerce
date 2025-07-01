package services.client.implement;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Client;
import services.client.remote.IConsultationProfilClient;
import utils.Connexion;

@Stateless
public class ConsultationProfilClientImpl implements IConsultationProfilClient {

    private final GenericDAO<Client> clientDAO;

    public ConsultationProfilClientImpl() {
        this.clientDAO = new GenericDAO<>(Client.class);
    }

    @Override
    public Client getProfilClient(int clientId) {
        return clientDAO.getById(clientId);
    }

    @Override
    public void updateProfilClient(Client client) {
        clientDAO.update(client);
    }
}
