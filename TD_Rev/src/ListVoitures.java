import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public ListVoitures() {
        this.voitures = new ArrayList<Voiture>();
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
// à compléter
        try {
            if (voitures.contains(v)) {
                throw new VoitureException("Voiture déjà existante");
            } else {
                voitures.add(v);
            }
        } catch (VoitureException e) {
            System.out.println(e.getMessage());
        }
    }

    public void supprimeVoiture(Voiture v) throws VoitureException {
        try {
            if (voitures.contains(v)) {
                voitures.remove(v);
            } else {
                throw new VoitureException("Voiture inexistante");
            }
        } catch (VoitureException e) {
            System.out.println(e.getMessage());
        }
    }

    public Iterator<Voiture> iterateur() {
        return voitures.iterator();
    }

    public int size() {
        return voitures.size();
    }

    public void affiche() {
        for (Voiture v : voitures) {
            System.out.println(v);
        }
    }
}