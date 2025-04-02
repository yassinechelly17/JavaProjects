import static java.util.Objects.hash;

public class Etudiant implements Comparable<Etudiant>{
    String nom;
    String prenom;
    int id;

    public Etudiant() {
        this.nom = "";
        this.prenom = "";
        this.id = 0;
    }

    public Etudiant(String nom, String prenom, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }

    int getId() {
        return this.id;
    }

    String getNom() {
        return this.nom;
    }

    String getPrenom() {
        return this.prenom;
    }

    void setId(int id) {
        this.id = id;
    }

    void setNom(String nom) {
        this.nom = nom;
    }

    void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    boolean equals(Etudiant e) {
        return this.id == e.id;
    }

    public String toString() {
        return "Etudiant [nom=" + this.nom + ", prenom=" + this.prenom + ", id=" + this.id + "]";
    }

    public int hashCode() {
        return this.id + hash(this.nom) + hash(this.prenom);
    }

    @Override
    public int compareTo(Etudiant o) {
        return this.id - o.id;
    }
}
