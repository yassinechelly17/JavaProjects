import javax.swing.*;
import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> ClientVoitureLoue;

    public Agence(String nom)
    {
        this.nom = nom;
        vs = new ListVoitures();
        ClientVoitureLoue = new HashMap<Client, ListVoitures>();
    }
    public void ajoutVoiture(Voiture v) throws VoitureException{
        try{
            vs.ajoutVoiture(v);
        }catch(VoitureException e){
            System.out.println(e.getMessage());
        }
    }
    public void suppVoiture(Voiture v)throws VoitureException{
        try {
            if (vs.getVoitures().contains(v)) {
                throw new VoitureException("Voiture déjà existante");
            } else {
                vs.supprimeVoiture(v);
            }
        } catch (VoitureException e) {
            System.out.println(e.getMessage());
        }
    }
    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException{
        try{
            if(vs.getVoitures().contains(v)){
                vs.supprimeVoiture(v);
                ListVoitures lv = ClientVoitureLoue.get(cl);
                if(lv == null){
                    lv = new ListVoitures();
                    ClientVoitureLoue.put(cl, lv);
                }
                lv.ajoutVoiture(v);
            }else{
                throw new VoitureException("Voiture inexistante");
            }
        }catch(VoitureException e){
            System.out.println(e.getMessage());
        }
    }
    public void retourClientVoiture(Client cl , Voiture v) throws VoitureException{
        try{
            ListVoitures lv = ClientVoitureLoue.get(cl);
            if(lv.getVoitures().contains(v)){
                lv.supprimeVoiture(v);
                vs.ajoutVoiture(v);
            }else{
                throw new VoitureException("Voiture inexistante");
            }
        }catch(VoitureException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Voiture> selectVoitureSelonCritere(Critere c){
        List<Voiture> res = new ArrayList<Voiture>();
        for(Voiture v : vs.getVoitures()){
            if(c.estSatisfaitPar(v)){
                res.add(v);
            }
        }
        return res;
    }
    public Set<Client> ensembleClientsLoueurs(){
        return ClientVoitureLoue.keySet();
    }
    public Collection<ListVoitures> collectionVoituresLouees(){
        return ClientVoitureLoue.values();
    }
    public void afficheLesClientsEtLeursListesVoitures(){
        for (Client cl : ClientVoitureLoue.keySet()){
            System.out.println(cl);
            ClientVoitureLoue.get(cl).affiche();
        }
    }
    public Map<Client, ListVoitures> triCodeCroissant(){
        Map<Client, ListVoitures> res = new TreeMap<Client, ListVoitures>(new Comparator<Client>(){
            public int compare(Client c1, Client c2){
                return c1.getCode() - c2.getCode();
            }
        });
        return res;
    }
    public Map<Client, ListVoitures> triNomCroissant() {
        Map<Client, ListVoitures> res = new TreeMap<Client, ListVoitures>(new Comparator<Client>() {
            public int compare(Client c1, Client c2) {
                return c1.getNom().compareTo(c2.getNom());
            }
        });
        return res;
    }

}