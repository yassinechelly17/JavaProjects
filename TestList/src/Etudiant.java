public class Etudiant {
    private String nom;
    private String prenom;
    private int id;

    public Etudiant(String nom, String prenom, int id) {
        this.nom = nom;
        this.prenom = prenom;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Etudiant e) {
        return this.id == e.id;
    }

    public String toString() {
        return this.nom + " " + this.prenom + " " + this.id;
    }
}
