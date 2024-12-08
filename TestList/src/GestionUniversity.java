import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestionUniversity implements University {
    private List<Etudiant> EspritArrayList = new ArrayList<Etudiant>();

    public void ajouterEtudiant(Etudiant e) {
        EspritArrayList.add(e);
    }

    public boolean rechercherEtudiant(Etudiant e) {
        return EspritArrayList.contains(e);
    }

    public boolean rechercherEtudiant(String nom) {
        for (Etudiant e : EspritArrayList) {
            if (e.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    public void supprimerEtudiant(Etudiant e) {
        EspritArrayList.remove(e);
    }

    public void displayEtudiants() {
        for (Etudiant e : EspritArrayList) {
            System.out.println(e.toString());
        }
    }

    public void trierEtudiantsParId() {
        Collections.sort(EspritArrayList, new Comparator<Etudiant>() {
            public int compare(Etudiant e1, Etudiant e2) {
                return e1.getId() - e2.getId();
            }
        });
    }

    public void trierEtudiantsParNom() {
        Collections.sort(EspritArrayList, new Comparator<Etudiant>() {
            public int compare(Etudiant e1, Etudiant e2) {
                return e1.getNom().compareTo(e2.getNom());
            }
        });
    }

}
