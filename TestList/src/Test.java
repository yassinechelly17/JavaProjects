import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Test {

    public static void main(String[] args) {

        Etudiant e1 = new Etudiant("Yassine", "Chelly", 1);
        Etudiant e2 = new Etudiant("Test", "Test", 2);

        System.out.println(e1.equals(e2)); // false
        System.out.println((e1.toString())); // Yassine Chelly


}

}
