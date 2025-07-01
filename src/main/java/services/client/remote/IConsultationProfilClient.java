package services.client.remote;

import jakarta.ejb.Remote;

import models.Client;

@Remote
public interface IConsultationProfilClient {
    public Client getProfilClient(int clientId);
    public void updateProfilClient(Client client);
}
