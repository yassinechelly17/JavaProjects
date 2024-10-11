package prosit1.gestion_Magasin.tn.tuniprob.gestionmagasin;

public class Employe {
    int id;
    String nom;
    String adresse;
    int nbr_heures;

    public Employe(int id, String nom, String adresse, int nbr_heures) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nbr_heures = nbr_heures;
    }

    void ajouterEmploye(Magasin m) {
        for (int i = 0; i < 20; i++) {
            if (m.employes[i] == null) {
                m.employes[i] = this;
                return;
            }
        }
    }

    public String toString() {
        return "Employe [id=" + this.id + ", nom=" + this.nom + ", adresse=" + this.adresse + ", nbr_heures=" + this.nbr_heures + "]";
    }

    public boolean equals(Employe e) {
        return this.id == e.id;
    }

    public boolean comparerEmploye(Employe e) {
        return this.equals(e);
    }

}

class Caissier extends Employe {
    int numeroDeCaisse;
    public Caissier(int id, String nom, String adresse, int nbr_heures, int numeroDeCaisse) {
        super(id, nom, adresse, nbr_heures);
        this.numeroDeCaisse = numeroDeCaisse;
    }
    double calculerSalaire() {
        double salaire = 0;
        if (nbr_heures <= 180) {
            salaire = nbr_heures * 5;
        } else {
            salaire = 180 * 5 + (nbr_heures - 180) * 15;
        }
        return salaire;
    }
}

class Vendeur extends Employe {
    double tauxDeVente;
    public Vendeur(int id, String nom, String adresse, int nbr_heures, double tauxDeVente) {
        super(id, nom, adresse, nbr_heures);
        this.tauxDeVente = tauxDeVente;
    }
    double calculerSalaire() {
        return 450 * tauxDeVente;
    }
}

class Responsable extends Employe {
    double prime;
    public Responsable(int id, String nom, String adresse, int nbr_heures, double prime) {
        super(id, nom, adresse, nbr_heures);
        this.prime = prime;
    }
    double calculerSalaire() {
        double salaire = 0;
        if (nbr_heures <= 160) {
            salaire = nbr_heures * 10;
        } else {
            salaire = 160 * 10 + (nbr_heures - 160) * 20;
        }
        return salaire;
    }

}
