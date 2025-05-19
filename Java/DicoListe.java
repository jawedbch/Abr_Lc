public class DicoListe {
    // Attributs
    ListeChainee l_elements;

    // Constructeurs
    /**
     * Crée un dictionnaire vide
     */
    public DicoListe() {
        l_elements = new ListeChainee();
    }

    // Insérer un élément
    public void inserer(Element elem) {
        l_elements.ajouteTete(elem);
    }

    // Supprimer un élément
    public void supprimer(Element elem) {
        if (!estVide()) {
            l_elements.razCourant();
            while (l_elements.getCourant() != null) {
                if (l_elements.getCourant().getContenu() instanceof Element) {
                    Element courantElem = (Element) l_elements.getCourant().getContenu();
                    if (courantElem.equals(elem)) {
                        l_elements.retireCourant();
                        break; // Arrête la recherche après suppression
                    }
                }
                l_elements.setCourant(l_elements.getCourant().getSuivant());
            }
        }
    }

    // Rechercher un élément par clé
    public Element rechercher(int cle) {
        l_elements.razCourant();
        while (l_elements.getCourant() != null) {
            if (l_elements.getCourant().getContenu() instanceof Element) {
                Element courantElem = (Element) l_elements.getCourant().getContenu();
                if (courantElem.getCle() == cle) {
                    return courantElem;
                }
            }
            l_elements.setCourant(l_elements.getCourant().getSuivant());
        }
        return null; // Retourner null si l'élément n'est pas trouvé
    }

    // Vérifier si le dictionnaire est vide
    public boolean estVide() {
        return l_elements.estVide();
    }

    // Affichage du dictionnaire
    public String toString() {
        return l_elements.toString();
    }

    public void afficher() {
        System.out.println(l_elements); 
    }

    public long longueurDicoListe() {
        return l_elements.longueur();
    }
}
