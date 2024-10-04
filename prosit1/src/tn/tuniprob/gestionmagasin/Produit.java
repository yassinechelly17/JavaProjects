package prosit1.gestion_Magasin.tn.tuniprob.gestionmagasin;

import java.util.Date;

public class Produit {
    private int id;
    private String libelle;
    private String marque;
    private double prix;
    private Date date_expiration;

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


    // public String toString() {
     //   return "Produit [id=" + this.id + ", libelle=" + this.libelle + ", marque=" + this.marque + ", prix=" + this.prix + "]";
   // }

    public String toString(){
        return "Produit [marque=" + this.marque + ", prix=" + this.prix + "]";
    }

    // Getters
    public int getId() {
        return this.id;
    }
    public String getLibelle() {
        return this.libelle;
    }
    public String getMarque() {
        return this.marque;
    }
    public double getPrix() {
        return this.prix;
    }
    public Date getDateExpiration() {
        return this.date_expiration;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public void setPrix(double prix) {
        if (prix < 0) {
            System.out.println("Le prix ne peut pas être négatif");
            return;
        }
        this.prix = prix;
    }
    public void setDateExpiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public static boolean comparer(Produit p1, Produit p2) {
        if (p1.id == p2.id && p1.libelle == p2.libelle && p1.prix == p2.prix) {
            return true;
        }
        return false;
    }

    public boolean comparer(Produit p) {
        if (this.id == p.id && this.libelle == p.libelle && this.prix == p.prix) {
            return true;
        }
        return false;
    }

}

