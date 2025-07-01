package services.gerant.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Caisse;

@Remote
public interface IGestionCaisse {
    public void addCaisse(Caisse caisse);
    public void updateCaisse(Caisse caisse);
    public void deleteCaisse(int caisseId);
    public Caisse getCaisseById(int caisseId);
    public List<Caisse> getAllCaisses();
}
