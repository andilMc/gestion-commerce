package services.gerant.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Client;
import services.gerant.remote.IGestionClient;
import utils.Connexion;

@Stateless
public class GestionClientImpl implements IGestionClient {

    private final GenericDAO<Client> clientDAO;

    public GestionClientImpl() {
        this.clientDAO = new GenericDAO<>(Client.class);
    }

    @Override
    public void addClient(Client client) {
        clientDAO.add(client);
    }

    @Override
    public void updateClient(Client client) {
        clientDAO.update(client);
    }

    @Override
    public void deleteClient(int clientId) {
        Client client = clientDAO.getById(clientId);
        if (client != null) {
            clientDAO.delete(client);
        }
    }

    @Override
    public Client getClientById(int clientId) {
        return clientDAO.getById(clientId);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDAO.listAll();
    }
}
