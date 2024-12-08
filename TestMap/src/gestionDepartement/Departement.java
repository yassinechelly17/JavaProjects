package gestionDepartement;

public class Departement {
    private String nom;
    private int id;

    public Departement(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    public Departement(){

    };
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Departement d) {
        return this.id == d.id;
    }

    public String toString() {
        return this.nom + " " + this.id;
    }
}
