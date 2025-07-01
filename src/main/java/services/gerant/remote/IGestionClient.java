package services.gerant.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Client;

@Remote
public interface IGestionClient {
    public void addClient(Client client);
    public void updateClient(Client client);
    public void deleteClient(int clientId);
    public Client getClientById(int clientId);
    public List<Client> getAllClients();
}
