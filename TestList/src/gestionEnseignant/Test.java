package gestionEnseignant;

public class Test {
    public static void main(String[] args) {
        GestionEnseignant espritTreeSet = new EspritTreeSet();
        GestionEnseignant espritHashSet = new EspritHashSet();
        Enseignant e1 = new Enseignant(1, "nom1", "prenom1");
        Enseignant e2 = new Enseignant(2, "nom2", "prenom2");
        Enseignant e3 = new Enseignant(3, "nom3", "prenom3");
        Enseignant e4 = new Enseignant(4, "nom4", "prenom4");
        espritHashSet.ajouterEnseignant(e1);
        espritHashSet.ajouterEnseignant(e2);
        espritHashSet.displayEnseignants();
        System.out.println(espritHashSet.rechercherEnseignant(2));
        System.out.println(espritHashSet.rechercherEnseignant(e3));
        espritHashSet.supprimerEnseignant(e2);
        espritHashSet.displayEnseignants();

        espritTreeSet.ajouterEnseignant(e3);
        espritTreeSet.ajouterEnseignant(e4);
        espritTreeSet.displayEnseignants();
        System.out.println(espritTreeSet.rechercherEnseignant(e1));
    }
}
