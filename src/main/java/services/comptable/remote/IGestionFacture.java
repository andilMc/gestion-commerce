package services.comptable.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Facture;

@Remote
public interface IGestionFacture {
    public void addFacture(Facture facture);
    public void updateFacture(Facture facture);
    public void deleteFacture(int factureId);
    public Facture getFactureById(int factureId);
    public List<Facture> getAllFactures();
}
