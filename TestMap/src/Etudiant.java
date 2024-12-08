public class Etudiant implements Comparable<Etudiant> {
    private int id;
    private String nom;
    private String prenom;


    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Etudiant(){
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

    public boolean equals(Etudiant e) {
        return this.id == e.id;
    }

    public String toString() {
        return this.nom + " " + this.prenom + " " + this.id;
    }

    public int hashCode() {
        return this.id + this.nom.hashCode()+this.prenom.hashCode();
    }

    @Override
    public int compareTo(Etudiant o) {
        return this.id - o.id;
    }
}
