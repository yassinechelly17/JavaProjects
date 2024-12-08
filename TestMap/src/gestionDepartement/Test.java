package gestionDepartement;

public class Test {
    public static void main(String[] args) {
        Employe e3 = new Employe("1", "nom3", "prenom3", "matricule3");
        Employe e1 = new Employe("3", "nom1", "prenom1", "matricule1");
        Employe e2 = new Employe("2", "nom2", "prenom2", "matricule2");

        Departement d1 = new Departement("departement1", 1);
        Departement d2 = new Departement("departement2", 2);
        Departement d3 = new Departement("departement3", 3);

        SocieteHashMap societe = new SocieteHashMap();
        societe.ajouterEmployeDepartement(e3, d3);
        societe.ajouterEmployeDepartement(e2, d2);
        societe.ajouterEmployeDepartement(e1, d1);
        societe.afficherLesEmployesLeursDepartements();
        System.out.println("******************");
        System.out.println(societe.triParCin());
        System.out.println("******************");
        System.out.println(societe.triParNom());

    }
}
