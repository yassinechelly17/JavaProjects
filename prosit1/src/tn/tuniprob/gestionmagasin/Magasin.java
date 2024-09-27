package prosit1.gestion_Magasin.tn.tuniprob.gestionmagasin;

public class Magasin {
    int id;
    String adresse;
    final int CAPACITE = 50;
    Produit[] produits = new Produit[CAPACITE];
    int nbProduits = 0;

    public void ajouterProduit(Produit p) {
        for (int i = 0; i < CAPACITE; i++) {
            if (produits[i] == null) {
                produits[i] = p;
                this.nbProduits++;
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
        return s.toString();
    }
}


