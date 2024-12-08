import java.util.List;

public class Test {
    public static void main(String[] args) {
        Voiture v1 = new Voiture(1, "Renault", 100);
        Voiture v2 = new Voiture(2, "Peugeot", 200);
        Voiture v3 = new Voiture(3, "Citroen", 300);
        Voiture v4 = new Voiture(4, "Renault", 400);
        Voiture v5 = new Voiture(5, "Peugeot", 500);

        Client c1 = new Client(1, "clientNom1", "clientPrenom1");
        Client c2 = new Client(2, "clientNom2", "clientPrenom2");
        Client c3 = new Client(3, "clientNom3", "clientPrenom3");

        ListVoitures lv = new ListVoitures();

        Agence a = new Agence("Agence1");
        try {
            a.ajoutVoiture(v1);
            a.ajoutVoiture(v2);
            a.ajoutVoiture(v3);
            a.ajoutVoiture(v4);
            a.ajoutVoiture(v5);
        } catch (VoitureException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.loueClientVoiture(c1, v1);
            a.loueClientVoiture(c1, v2);
            a.loueClientVoiture(c2, v3);
            a.loueClientVoiture(c2, v4);
            a.loueClientVoiture(c3, v5);
        } catch (VoitureException e) {
            System.out.println(e.getMessage());
        }

        a.afficheLesClientsEtLeursListesVoitures();



    }
}
