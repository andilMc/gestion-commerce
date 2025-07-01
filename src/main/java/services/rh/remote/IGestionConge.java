package services.rh.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Conge;

@Remote
public interface IGestionConge {
    public void addConge(Conge conge);
    public void updateConge(Conge conge);
    public void deleteConge(int congeId);
    public Conge getCongeById(int congeId);
    public List<Conge> getAllConges();
}
