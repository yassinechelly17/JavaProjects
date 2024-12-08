public class Voiture {
    private int immariculation;
    private String marque;
    private float prixLocation;

    public Voiture(int immariculation, String marque, float prixLocation) {
        this.immariculation = immariculation;
        this.marque = marque;
        this.prixLocation = prixLocation;
    }
    public int getImmariculation() {
        return immariculation;
    }
    public void setImmariculation(int immariculation) {
        this.immariculation = immariculation;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public float getPrixLocation() {
        return prixLocation;
    }
    public void setPrixLocation(float prixLocation) {
        this.prixLocation = prixLocation;
    }
    public int hashCode() {
        return immariculation + marque.hashCode() + (int) prixLocation;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Voiture) {
        return (this.immariculation == ((Voiture) obj).immariculation) || (this.marque.equals(((Voiture) obj).marque));
    }
    return false;
    }
    public String toString(){
        return "Immatriculation: " + immariculation + " Marque: " + marque + " Prix de location: " + prixLocation;
    }
}
