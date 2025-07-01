package services.comptable.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Paiement;

@Remote
public interface IGestionPaiement {
    public void addPaiement(Paiement paiement);
    public void updatePaiement(Paiement paiement);
    public void deletePaiement(int paiementId);
    public Paiement getPaiementById(int paiementId);
    public List<Paiement> getAllPaiements();
}
