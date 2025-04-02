import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Etudiant> etudiant_set = new HashSet<>();
        Etudiant et1 = new Etudiant("Yassine", "Chelly", 1);
        etudiant_set.add(et1);
    }
}
