package prosit1.gestion_Magasin.tn.tuniprob.gestionmagasin;

public class Magasin {
    int id;
    String adresse;
    final int CAPACITE = 50;
    Produit[] produits = new Produit[CAPACITE];
    int nbProduits = 0;
    static int nbProduitsMax = 0;
    Employe[] employes = new Employe[20];

    public void ajouterProduit(Produit p) {
        for (int i = 0; i < CAPACITE; i++) {
            if (produits[i] == null && !this.chercherProduit(p)) {
                produits[i] = p;
                this.nbProduits++;
                nbProduitsMax++;
                return;
            }
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder("Magasin [id=" + this.id + ", adresse=" + this.adresse + "]\n");
        for (int i = 0; i < CAPACITE; i++) {
            if (produits[i] != null) {
                s.append(produits[i].toString()).append("\n");
            }
        }
        for (int i = 0; i < 20; i++) {
            if (employes[i] != null) {
                s.append(employes[i].toString()).append("\n");
            }
        }
        return s.toString();
    }

    public int afficherNbProduitsMax(){
        return nbProduitsMax;
    }

    public boolean chercherProduit(Produit p){
        for (int i = 0; i < this.nbProduits; i++) {
            if (produits[i] != null && produits[i].getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

    public void supprimerProduit(Produit p){
        for (int i = 0; i < this.nbProduits; i++) {
            if (produits[i] != null && produits[i].getId() == p.getId()) {
                produits[i] = null;
                this.nbProduits--;
                return;
            }
        }
    }

    public static Magasin retourneMagAvecPlusProds(Magasin m1, Magasin m2){
        if (m1.nbProduits > m2.nbProduits) {
            return m1;
        } else {
            return m2;
        }
    }

    String afficherPrime(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            if (employes[i] != null && employes[i] instanceof Responsable) {
                s.append(((Responsable) employes[i]).prime).append("\n");
            }
        }
        return s.toString();
    }

    String afficherSalaire(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            if (employes[i] != null) {
                if (employes[i] instanceof Vendeur) {
                    s.append(((Vendeur) employes[i]).calculerSalaire()).append("\n");
                } else if (employes[i] instanceof Caissier) {
                    s.append(((Caissier) employes[i]).calculerSalaire()).append("\n");
                } else if (employes[i] instanceof Responsable) {
                    s.append(((Responsable) employes[i]).calculerSalaire()).append("\n");
                }

            }
        }
        return s.toString();
    }

    void afficherNbEmployes_ParType() {
        int nbCaissiers = 0;
        int nbVendeurs = 0;
        int nbResponsables = 0;
        for (int i = 0; i < 20; i++) {
            if (employes[i] != null) {
                if (employes[i] instanceof Caissier) {
                    nbCaissiers++;
                } else if (employes[i] instanceof Vendeur) {
                    nbVendeurs++;
                } else if (employes[i] instanceof Responsable) {
                    nbResponsables++;
                }
            }
        }
        System.out.println("Nombre de caissiers: " + nbCaissiers);
        System.out.println("Nombre de vendeurs: " + nbVendeurs);
        System.out.println("Nombre de responsables: " + nbResponsables);

    }

}


