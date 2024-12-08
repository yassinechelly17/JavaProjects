package gestionEnseignant;

public class Enseignant implements Comparable<Enseignant>{
    private int id;
    private String nom;
    private String prenom;

    public Enseignant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Enseignant(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Enseignant(){
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean equals(Enseignant e) {
        return this.id == e.id;
    }

    public String toString() {
        return this.nom + " " + this.prenom + " " + this.id;
    }

    @Override
    public int compareTo(Enseignant o) {
        return this.id - o.id;
    }
}
