public class ListeChainee {
    
    private Cellule tete;
    private Cellule courant;

    public ListeChainee() {
        tete = null;
        courant = null;
    }

    public ListeChainee(Cellule cell) {
        tete = cell;
        courant = tete;
    }

    public boolean estVide() {
        return tete == null;
    }

    public Cellule getTete() {
        return tete;
    }

    public Cellule getCourant() {
        return courant;
    }

    public void setCourant(Cellule n_courant) {
        courant = n_courant;
    }

    public void ajouteTete(Object o_tete) {
        Cellule c_tete = new Cellule(o_tete);
    
        if(tete == null) {
            tete = c_tete;
            courant = tete;
            tete.setSuivant(null);
        } else {
            c_tete.setSuivant(tete);
            tete = c_tete;
        } 
    }

    public void retireTete() {
        if(estVide()) {
            return;
        } else {
            Cellule ancienneTete = tete;
            tete = tete.getSuivant();
            ancienneTete.setSuivant(null);
            courant = tete; // Si courant pointait sur l'ancienne tête, mettez-le à jour.
        }
    }
    
    public void ajouteApresCourant(Object o_apresCourant) {
        if (courant == null) {
            return;
        }
        
        Cellule nouvelleCellule = new Cellule(o_apresCourant);
        nouvelleCellule.setSuivant(courant.getSuivant());
        courant.setSuivant(nouvelleCellule);
    }
    
    public void retireCourant() {
        if (tete == null || courant == null) {
            return;
        }
    
        if (courant == tete) {
            tete = tete.getSuivant();
            courant = tete;
            return;
        }
    
        Cellule precedantCourant = tete;
        while (precedantCourant != null && precedantCourant.getSuivant() != courant) {
            precedantCourant = precedantCourant.getSuivant();
        }
    
        if (precedantCourant != null) {
            precedantCourant.setSuivant(courant.getSuivant());
            courant = courant.getSuivant();
        }
    }

    public String toString() {
        StringBuilder chaine = new StringBuilder("[");
        Cellule temp = tete; // Utilisez une variable temporaire pour parcourir la liste.
        while(temp != null && temp.getSuivant() != null) {
            chaine.append(temp);
            temp = temp.getSuivant();
            if (temp != null && temp.getSuivant() != null) {
                chaine.append(",");
            }
        }
        chaine.append("]");
        return chaine.toString();
    }

    public void razCourant() {
        courant = tete;
    }

    public void suivant() {
        if (courant != null) {
            courant = courant.getSuivant();
        }
    }

    public boolean possedeSuivant() {
        return courant != null && courant.getSuivant() != null;
    }

    public Object enTete() {
        if (tete != null) {
            return tete.getContenu();
        }
        return null;
    }

    public Object enCourant() {
        if (courant != null) {
            return courant.getContenu();
        }
        return null;
    }

    public long longueur() {
        return longueur(tete);
    }

    private long longueur(Cellule cell) {
        if(cell == null) {
            return 0;
        } else {
            return 1 + longueur(cell.getSuivant());
        }
    }
}
