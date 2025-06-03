import metiers.admin.initSystem.implement.CatalogueImpl;

public class Main {
    public static void main(String[] args) {
        
        //Connexion.getSession();
        CatalogueImpl cat = new CatalogueImpl();
        //cat.ajoutCatalogue("menager", "Outils de maison", false);
        //cat.modifierCatalogue("CAT-1748854302406", "Electronics", "electonics description", true);
        //cat.supprimerCatalogue("CAT-1748854302406");
        //cat.activerCatalogue("CAT-1748854754818");
        //cat.desactiverCatalogue("CAT-1748854754818");
        cat.listerCatalogue();
    }
}
