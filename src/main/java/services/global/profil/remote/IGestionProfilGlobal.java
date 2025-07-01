package services.global.profil.remote;

import jakarta.ejb.Remote;

import models.Personne;
import models.Profile;

@Remote
public interface IGestionProfilGlobal {
    public Personne getPersonneById(int personneId);
    public void updatePersonne(Personne personne);
    public Profile getProfileById(int profileId);
    public void updateProfile(Profile profile);
}
