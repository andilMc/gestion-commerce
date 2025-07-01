package services.admin.initsystem.remote;

import java.util.List;

import jakarta.ejb.Remote;
import models.Produit;
import models.Unitemesure;

@Remote
public interface IProduit {
    public boolean ajoutProduit(int idFamille, String designation, String description, int idUnite, boolean etat);
    public boolean modifierProduit(Produit produit);
    public boolean supprimerProduit(String reference);
    public boolean activerProduit(String reference);
    public boolean desactiverProduit(String reference);
    public List<Produit> listerProduit();
    public List<Produit> listerProduitActif();
    public List<Produit> listerProduitDesactive();
    public Produit listerProduitParReference(String reference);
    public List<Produit> listerProduitParDesignation(String designation);
    public List<Unitemesure> listerUniteMesureParProduit(String referenceProduit);
}
