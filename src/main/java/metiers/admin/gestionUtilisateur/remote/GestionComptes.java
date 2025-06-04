package metiers.admin.gestionUtilisateur.remote;

import java.util.List;

public interface GestionComptes {
    public List<List<Object>> listerToutCompte(int compteCourrant);
    public List<Object> detailCompte(int compteCourrant,int idCompte);
    public boolean activerCompte(int compteCourrant, int idCompte);
    public boolean desactiverCompte(int compteCourrant, int idCompte);
    public boolean supprimerCompte(int compteCourrant, int idCompte);
    public boolean reparerCompte(int compteCourrant, int idCompte,String identifiant);
    public List<List<Object>> recherchCompteParIdentifiant(int compteCourrant, String identifiant);
    public boolean setAdminRole(int compteCourrant, int idCompte);
}
