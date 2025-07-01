package services.admin.initsystem.implement;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import services.admin.initsystem.remote.ITypeVariete;
import dao.GenericDAO;
import models.Article;
import models.Typevariete;
import models.Variete;

@Stateless
public class TypeVarieteImpl implements ITypeVariete {

    private final GenericDAO<Typevariete> typeVarieteDAO;
    private final GenericDAO<Article> articleDAO;

    public TypeVarieteImpl() {
        this.typeVarieteDAO = new GenericDAO<>(Typevariete.class);
        this.articleDAO = new GenericDAO<>(Article.class);
    }

    @Override
    public boolean ajoutTypeVariete(String label, String typeValeur, String etat) {
        try {
            Typevariete typeVariete = new Typevariete();
            typeVariete.setLabel(label);
            typeVariete.setTypevaleur(typeValeur);
            typeVariete.setEtat(etat);
            typeVariete.setDatecreation(new Date());
            typeVarieteDAO.add(typeVariete);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifierTypeVariete(Typevariete typeVariete) {
        try {
            if (typeVariete != null) {
                typeVarieteDAO.update(typeVariete);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerTypeVariete(int idTypeVariete) {
        try {
            Typevariete typeVariete = typeVarieteDAO.getById(idTypeVariete);
            if (typeVariete != null) {
                typeVarieteDAO.delete(typeVariete);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean activerTypeVariete(int idTypeVariete) {
        try {
            Typevariete typeVariete = typeVarieteDAO.getById(idTypeVariete);
            if (typeVariete != null && (typeVariete.getEtat()=="inactif")) {
                typeVariete.setEtat("actif");
                typeVarieteDAO.update(typeVariete);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean desactiverTypeVariete(int idTypeVariete) {
        try {
            Typevariete typeVariete = typeVarieteDAO.getById(idTypeVariete);
            if (typeVariete != null && (typeVariete.getEtat()=="actif")) {
                typeVariete.setEtat("inactif");
                typeVarieteDAO.update(typeVariete);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean lierTypeVarieteArticle(int idArticle, int idTypeVariete) {
        // TODO: Implement this method based on the actual relationship between Article and Typevariete
        // If there's a many-to-many relationship, a linking entity might be needed.
        // For now, returning false as the direct linking mechanism is not clear from the provided models.
        return false;
    }

    @Override
    public boolean delierTypeVarieteArticle(int idArticle, int idTypeVariete) {
        // TODO: Implement this method based on the actual relationship between Article and Typevariete
        // If there's a many-to-many relationship, a linking entity might be needed.
        // For now, returning false as the direct linking mechanism is not clear from the provided models.
        return false;
    }

    @Override
    public List<Typevariete> listerTypeVariete() {
        try {
            return typeVarieteDAO.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Typevariete listerTypeVarieteParId(int idTypeVariete) {
        try {
            return typeVarieteDAO.getById(idTypeVariete);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Typevariete> listerTypeVarieteParLabel(String label) {
        try {
            return typeVarieteDAO.findAllByField("label", label);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
