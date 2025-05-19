public class Noeud {
    //Attributs
    private Element elem;
    private Noeud gauche, droite;

    //Constructeurs
    public Noeud(Element elem) {
        this.elem = elem;
        gauche = null;
        droite = null;
    }

    //Méthodes
    public Noeud getGauche() {
        return gauche;
    }

    public Noeud getDroite() {
        return droite;
    }

    public Element getElem() {
        return elem;
    }

    public void setElem(Element e) {
        elem = e;
    }

    public void setGauche(Noeud g) {
        gauche = g;
    }

    public void setDroite(Noeud d) {
        droite = d;
    }
}
