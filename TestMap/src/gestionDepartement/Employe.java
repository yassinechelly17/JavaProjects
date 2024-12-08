package gestionDepartement;

import java.util.Comparator;

public class Employe {

    private String CIN;
    private String nom;
    private String prenom;
    private String matricule;

    public Employe(String CIN, String nom, String prenom, String matricule) {
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    public Employe() {
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String toString() {
        return this.nom + " " + this.prenom + " " + this.CIN + " " + this.matricule;
    }

    public boolean equals(Employe e) {
        return this.CIN.equals(e.CIN);
    }
}
