package gestionDepartement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class SocieteHashMap implements InterfaceSociete{

    HashMap<Employe,Departement> employes = new HashMap<Employe,Departement>();
    @Override
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        employes.put(e, d);
    }

    @Override
    public void supprimerEmploye(Employe e) {
        employes.remove(e);
    }

    @Override
    public void afficherLesEmployesLeursDepartements() {
        for (Employe e : employes.keySet()) {
            System.out.println(e + " " + employes.get(e));
        }
    }

    @Override
    public void afficherLesEmployes() {
        for (Employe e : employes.keySet()) {
            System.out.println(e);
        }
    }

    @Override
    public void afficherLesDepartements() {
        for (Departement d : employes.values()) {
            System.out.println(d);
        }
    }

    @Override
    public void afficherDepartement(Employe e) {
        System.out.println(employes.get(e));
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return employes.containsKey(e);
    }

    @Override
    public boolean rechercherDepartement(Departement e) {
        return employes.containsValue(e);
    }

    public TreeMap<Employe,Departement> triParCin() {
        TreeMap<Employe, Departement> sortedByCin = new TreeMap<>(new Comparator<Employe>() {
            @Override
            public int compare(Employe o1, Employe o2) {
                return o1.getCIN().compareTo(o2.getCIN());
            }
        });
        sortedByCin.putAll(employes);
        return sortedByCin;
    }

    public TreeMap<Employe,Departement> triParNom() {
        TreeMap<Employe, Departement> sortedByNom = new TreeMap<>(new Comparator<Employe>() {
            @Override
            public int compare(Employe o1, Employe o2) {
                return o1.getNom().compareTo(o2.getNom());
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        });
        sortedByNom.putAll(employes);
        return sortedByNom;
    }
}
