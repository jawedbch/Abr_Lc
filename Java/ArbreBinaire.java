public class ArbreBinaire {
    //Attributs
    private Noeud racine;

    //Constructeur
    public ArbreBinaire() {
        racine = null;
    }

    //Méthodes
    //Insertion
    public boolean inserer(Element elem) {
        return inserer(racine, elem);
    }
    
    private boolean inserer(Noeud n, Element elem) {
        // Si l'arbre est vide, créer la racine
        if (n == null) {
            this.racine = new Noeud(elem);
            return true;
        }
    
        // Si l'élément à insérer est plus petit que le nœud courant, insérer dans le sous-arbre gauche
        if (elem.getCle() < n.getElem().getCle()) {
            // Si l'insertion réussit, retourner vrai
            if (n.getGauche() == null) {
                n.setGauche(new Noeud(elem));
                return true;
            } else {
                // Sinon, continuer l'insertion récursive
                return inserer(n.getGauche(), elem);
            }
        }
        // Si l'élément à insérer est plus grand que le nœud courant, insérer dans le sous-arbre droit
        else if (elem.getCle() > n.getElem().getCle()) {
            // Si l'insertion réussit, retourner vrai
            if (n.getDroite() == null) {
                n.setDroite(new Noeud(elem));
                return true;
            } else {
                // Sinon, continuer l'insertion récursive
                return inserer(n.getDroite(), elem);
            }
        }
        // Si l'élément à insérer est égal au nœud courant, retourner faux (ne peut pas insérer de doublons)
        else {
            return false;
        }
    }
    

    //Recherche
    public Element rechercher(int cle) {
        return rechercher(racine, cle);
    }

    private Element rechercher(Noeud noeud, int cle) {
        if (noeud != null && noeud.getElem() != null) {
            //Si la clé de l'élément recherché est égale à la clé du noeud courant
            if (noeud.getElem().getCle() == cle) {
                return noeud.getElem();
            //Si la clé de l'élément recherché est plus grande que le neoud courant, chercher dans le sous-arbre droit
            } else if (noeud.getElem().getCle() < cle) {
                return rechercher(noeud.getDroite(), cle);
            //Si la clé de l'élément recherché est plus petite que le noeud courant, chercher dans le sous-arbre gauche
            } else if (noeud.getElem().getCle() > cle) {
                return rechercher(noeud.getGauche(), cle);
            }
        }

        //Retourne null si l'élément n'est pas présent
        return null;
    }

    //Suppression
    public boolean supprimer(Element elem) {
        boolean[] estSupprime = new boolean[1]; // Utilisé pour marquer si le nœud a été supprimé avec succès
        racine = supprimerNoeud(racine, elem, estSupprime);
        return estSupprime[0];
    }
    
    private Noeud supprimerNoeud(Noeud n, Element rechElement, boolean[] estSupprime) {
        // Si l'arbre est vide, on renvoie null
        if (n == null) {
            estSupprime[0] = false; // L'élément n'est pas dans l'arbre, donc aucun nœud n'a été supprimé
            return null;
        }
    
        // Si l'élément à supprimer est plus petit que l'élément du nœud courant, aller à gauche
        if (rechElement.getCle() < n.getElem().getCle()) {
            n.setGauche(supprimerNoeud(n.getGauche(), rechElement, estSupprime));
        }
        // Si l'élément à supprimer est plus grand que l'élément du nœud courant, aller à droite
        else if (rechElement.getCle() > n.getElem().getCle()) {
            n.setDroite(supprimerNoeud(n.getDroite(), rechElement, estSupprime));
        }
        // Si l'élément à supprimer est égal à l'élément du nœud courant, alors ce nœud doit être supprimé
        else {
            estSupprime[0] = true; // Marquer que le nœud a été supprimé avec succès
    
            // Le nœud est une feuille ou possède au plus un successeur
            if (n.getGauche() == null) {
                return n.getDroite();
            } else if (n.getDroite() == null) {
                return n.getGauche();
            }
    
            // Le nœud a 2 successeurs, échanger le nœud avec le nœud ayant l'élément le plus petit du sous-arbre droit
            n.setElem(minimumValeur(n.getDroite()));
    
            // Supprimer le nœud dans le sous-arbre droit
            n.setDroite(supprimerNoeud(n.getDroite(), n.getElem(), estSupprime));
        }
    
        return n;
    }
    

    //Cherche le neoud le plus à gauche du sous-arbre droit
    private Element minimumValeur(Noeud n) {
        while (n.getGauche() != null) {
            n = n.getGauche();
        }
        return n.getElem();
    }
    
    //Calcul la hauteur de l'arbre
    public int hauteur() {
        return hauteur(racine);
    }
    
    private int hauteur(Noeud n) {
        // Si le nœud est nul, la hauteur est -1 car il n'y a pas de nœud
        if (n == null) {
            return 0;
        } else {
            // Récursivement calculer la hauteur de chaque sous-arbre gauche et droit
            int hauteurGauche = hauteur(n.getGauche());
            int hauteurDroit = hauteur(n.getDroite());
            // La hauteur de l'arbre est le maximum de la hauteur des sous-arbres gauche et droit, plus 1 pour le nœud courant
            return Math.max(hauteurGauche, hauteurDroit) + 1;
        }
    }

    //Affichage
    public void afficher() {
        afficher(racine);
        System.out.println();
    }

    private void afficher(Noeud racine) {
        if(racine != null) {
            //Afficher l'élément gauche puis le noeud puis l'élément droit
            afficher(racine.getGauche());
            System.out.print(racine.getElem() + " ");
            afficher(racine.getDroite());
        }
    }
}