package gestionEnseignant;

import java.util.TreeSet;

public class EspritTreeSet implements GestionEnseignant{
    private TreeSet<Enseignant> enseignants = new TreeSet<Enseignant>();

    public void ajouterEnseignant(Enseignant e) {
        enseignants.add(e);
    }

    public boolean rechercherEnseignant(Enseignant e) {
        return enseignants.contains(e);
    }

    public boolean rechercherEnseignant(int id) {
        for (Enseignant e : enseignants) {
            if (e.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void supprimerEnseignant(Enseignant e) {
        enseignants.remove(e);
    }

    public void displayEnseignants() {
        for (Enseignant e : enseignants) {
            System.out.println(e);
        }
    }
}
