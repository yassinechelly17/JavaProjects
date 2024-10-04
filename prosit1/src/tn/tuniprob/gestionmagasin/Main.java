package prosit1.gestion_Magasin.tn.tuniprob.gestionmagasin;
import java.util.Date;

class Main {
    public static void main(String[] args) {

        // question 1
        Produit p_vide = new Produit();

        // question 2
            //  p1
        Produit p1 = new Produit(1021, "Lait", "Delice");
            //  p2
        Produit p2 = new Produit(2510, "Yaourt", "Vitalait");
            // p3
        Produit p3 = new Produit(3250, "Tomate", "Sicam", 1.200);

        // question 3
        p1.afficher();
        p2.afficher();
        p3.afficher();

        System.out.println("");
        System.out.println("-----------------");
        System.out.println("Valeurs modfiées:");

        // question 4
        p1.setPrix(0.800);
        p1.afficher();

        // question 5
        p2.setPrix(0.500);
        // question 6
        p2.afficher();

        // question 7
        System.out.println("");
        System.out.println("-----------------");
        System.out.println("Affichés avec toString():");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        p1.setDateExpiration(new Date(2024, 9, 31));
        p2.setDateExpiration(new Date(2024, 10, 10));

        System.out.println("-----------------");
        Magasin m1 = new Magasin();
        m1.id = 1;
        m1.adresse = "Tunis";
        m1.ajouterProduit(p1);
        m1.ajouterProduit(p2);
        Magasin m2 = new Magasin();
        m2.id = 2;
        m2.adresse = "Ariana";
        m2.ajouterProduit(p3);
        System.out.println(m1.toString());
        System.out.println(m2.toString());

        System.out.println("Nombre de produits max: " + m1.afficherNbProduitsMax());
        System.out.println("Nombre de produits max: " + Magasin.nbProduitsMax);
        Produit p1_identique = new Produit(1021, "Lait", "Delice", 0.800);
        System.out.println("Produit p1 et p1_identique sont identiques? (fonction statique): " + Produit.comparer(p1, p1_identique));
        System.out.println("Produit p1 et p1_identique sont identiques? : " + p1.comparer(p1_identique));
        System.out.println("Est-ce que magasin m1 a le produit p1? " + m1.chercherProduit(p1));
        System.out.println("Est-ce que magasin m1 a le produit p3? " + m1.chercherProduit(p3));
        System.out.println("Le magasin avec le plus de produits est le magasin avec id " + Magasin.retourneMagAvecPlusProds(m1, m2).id + " et comme addresse: " + Magasin.retourneMagAvecPlusProds(m1, m2).adresse);




        return;
    }
}


