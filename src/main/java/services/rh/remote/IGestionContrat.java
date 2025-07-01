package services.rh.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Contrattravail;

@Remote
public interface IGestionContrat {
    public void addContrat(Contrattravail contrat);
    public void updateContrat(Contrattravail contrat);
    public void deleteContrat(int contratId);
    public Contrattravail getContratById(int contratId);
    public List<Contrattravail> getAllContrats();
}
