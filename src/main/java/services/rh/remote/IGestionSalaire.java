package services.rh.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Payementsalaire;
import models.Salaire;

@Remote
public interface IGestionSalaire {
    public void addSalaire(Salaire salaire);
    public void updateSalaire(Salaire salaire);
    public void deleteSalaire(int salaireId);
    public Salaire getSalaireById(int salaireId);
    public List<Salaire> getAllSalaires();

    public void addPayementSalaire(Payementsalaire payementSalaire);
    public List<Payementsalaire> getPayementSalaireByEmploye(int employeId);
}
