package services.comptable.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Rapportfinancier;

@Remote
public interface IGestionRapportFinancier {
    public void addRapportFinancier(Rapportfinancier rapportFinancier);
    public void updateRapportFinancier(Rapportfinancier rapportFinancier);
    public void deleteRapportFinancier(int rapportFinancierId);
    public Rapportfinancier getRapportFinancierById(int rapportFinancierId);
    public List<Rapportfinancier> getAllRapportFinanciers();
}
