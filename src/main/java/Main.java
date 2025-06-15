import java.util.List;

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
        //cat.listerCatalogue();
        
        //Liste catalogue inactif
        //List<List<?>> resultats = cat.listerCatalogueDesactive();
        //if (resultats.isEmpty()) {
        //System.out.println("Aucun catalogue actif trouvé.");
        //} else {
        //for (List<?> ligne : resultats) {
        //System.out.println(ligne);
        //}
        // }
        
       //cat.listerCatalogueParReference("CAT-1748855451641");
//       List<List<?>> result = cat.listerCatalogueParReference("CAT-1748855451641");
//       System.out.println("Résultat : " + result.size());

//        cat.listerCatalogueParLabel("Electronics");
//        List<List<?>> result = cat.listerCatalogueParLabel("Electronics");
//        System.out.println("Résultat : " + result.size());
        
        
    }
}
