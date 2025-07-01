package services.logisticien.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Retourproduit;

@Remote
public interface IGestionRetour {
    public void addRetour(Retourproduit retour);
    public void updateRetour(Retourproduit retour);
    public void deleteRetour(int retourId);
    public Retourproduit getRetourById(int retourId);
    public List<Retourproduit> getAllRetours();
}
