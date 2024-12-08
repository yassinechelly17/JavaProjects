import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.TreeMap;

public class Test{

    public static void main(String[] args) {
        Etudiant e1 = new Etudiant(1, "nom1", "prenom1");
        Etudiant e2 = new Etudiant(2, "nom2", "prenom2");
        Etudiant e3 = new Etudiant(3, "nom3", "prenom3");


        HashMap<Etudiant, String> map = new HashMap<Etudiant, String>();
        map.put(e1, "Classe 1");
        map.put(e2, "Classe 2");
        System.out.println(map);
        System.out.println(map.size());

        // parcourir les clés
        for (Etudiant e : map.keySet()) {
            System.out.println(e);
        }
        System.out.println("******************");
        // parcourir les valeurs
        for (String s : map.values()) {
            System.out.println(s);
        }
        System.out.println("******************");

        // parcourir les clés et les valeurs avec 2 methodes
        for (Etudiant e : map.keySet()) {
            System.out.println(e + " " + map.get(e));
        }
        System.out.println("******************");
        for (HashMap.Entry<Etudiant, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // tri des clés
        System.out.println("******************");
        map.put(e3, "Classe 3");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (Etudiant e : map.keySet()) {
            treeMap.put(e.getId(), map.get(e));
        }
        System.out.println(treeMap);

        TreeMap<Etudiant, String> treeMap2 = new TreeMap<>();
        for (Etudiant e : map.keySet()) {
            treeMap2.put(e, map.get(e));
        }

        System.out.println(treeMap2);
    }
}
