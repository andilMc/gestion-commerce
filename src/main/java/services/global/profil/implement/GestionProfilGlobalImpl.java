package services.global.profil.implement;

import jakarta.ejb.Stateless;
import dao.GenericDAO;
import models.Personne;
import models.Profile;
import services.global.profil.remote.IGestionProfilGlobal;

@Stateless
public class GestionProfilGlobalImpl implements IGestionProfilGlobal {

    private final GenericDAO<Personne> personneDAO;
    private final GenericDAO<Profile> profileDAO;

    public GestionProfilGlobalImpl() {
        this.personneDAO = new GenericDAO<>(Personne.class);
        this.profileDAO = new GenericDAO<>(Profile.class);
    }

    @Override
    public Personne getPersonneById(int personneId) {
        return personneDAO.getByIdWithAssociations(personneId, "comptes", "employers", "clients", "collaborateurs");
    }

    @Override
    public void updatePersonne(Personne personne) {
        personneDAO.update(personne);
    }

    @Override
    public Profile getProfileById(int profileId) {
        return profileDAO.getById(profileId);
    }

    @Override
    public void updateProfile(Profile profile) {
        profileDAO.update(profile);
    }
}
