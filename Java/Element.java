public class Element {
    //Attributs
    private int cle;
    private String valeur;

    //Constructeurs
    public Element(int cle, String valeur) {
        this.cle = cle;
        this.valeur = valeur;
    }

    //Méthodes 
    //Getters
    public int getCle() {
        return cle;
    }

    public String getValeur() {
        return valeur;
    }
    //Setters
    public void setCle(int newCle) {
        this.cle = newCle;
    }

    public void setValeur(String newValeur) {
        this.valeur = newValeur;
    }

    // Affichage
    public String toString() {
        return cle + ":" + '"' + valeur + '"';
    }
}