package metiers.global.remote;

import jakarta.ejb.Remote;

@Remote
public interface IAuthentification {
    public boolean getRole(int idCompte);
    
}