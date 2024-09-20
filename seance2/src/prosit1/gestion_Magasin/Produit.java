package prosit1.gestion_Magasin;

import java.util.Date;

public class Produit {
    int id;
    String libelle;
    String marque;
    double prix;
    Date date_expiration;

    public Produit () {
        this.id = 0;
        this.libelle = "";
        this.marque = "";
        this.prix = 0.0;
    }
    public Produit(int id, String libelle, String marque, double prix) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
    }

    public Produit(int id, String libelle, String marque){
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        this.prix = 0.0;
    }

    public void afficher() {
        System.out.println("Le produit " + this.libelle + " de la marque " + this.marque + " a pour prix " + this.prix);
        return;
    }


    public String toString() {
        return "Produit [id=" + this.id + ", libelle=" + this.libelle + ", marque=" + this.marque + ", prix=" + this.prix + "]";
    }
}

