import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void insertionDansArbre(ArbreBinaire dico, Element[] aInserer, String fichier) {
        long debut, fin, dureeInsertionAbr;
        debut = System.currentTimeMillis();
        for(int j = 0; j < aInserer.length; j++) {
            dico.inserer(aInserer[j]);
        }
        fin = System.currentTimeMillis();

        dureeInsertionAbr = fin - debut;

        int hauteurAbrAvantInsertion = dico.hauteur();

        System.out.println("Durée de l'insertion : " + dureeInsertionAbr + " ms");
        System.out.println("Hauteur avant insertion: "+hauteurAbrAvantInsertion);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true));
            bw.write(String.valueOf(dureeInsertionAbr)+", "+hauteurAbrAvantInsertion);
            bw.newLine();
            
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void suppressionDansArbre(ArbreBinaire dico, Element[] aSuppr, String fichier) {
        long debut, fin, dureeSuppressionAbr;

        debut = System.currentTimeMillis();
        for(int i = 0; i < aSuppr.length; i++) {
            dico.supprimer(aSuppr[i]);
        }
        fin = System.currentTimeMillis();

        dureeSuppressionAbr = fin - debut;

        int hauteurAbrAvantSuppression = dico.hauteur();

        System.out.println("Durée de la suppression : " + dureeSuppressionAbr + " ms");
        System.out.println("Hauteur avant suppression: "+hauteurAbrAvantSuppression);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true));
            bw.write(String.valueOf(dureeSuppressionAbr)+", "+hauteurAbrAvantSuppression);
            bw.newLine();
            
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertionDansListeChainee(DicoListe dico, Element[] aInserer, String fichier) {
        long debut, fin, dureeInsertionListe;

        debut = System.currentTimeMillis();
        for(int i = 0; i < aInserer.length; i++) {
            dico.inserer(aInserer[i]);
        }
        fin = System.currentTimeMillis();

        dureeInsertionListe = fin - debut;

        System.out.println("Durée de l'insertion : " + dureeInsertionListe + " ms");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true));
            bw.write(String.valueOf(dureeInsertionListe));
            bw.newLine();
            
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void suppressionDansListeChainee(DicoListe dico, Element[] aSuppr, String fichier) {
        long debut, fin, dureeSuppressionListe;

        debut = System.currentTimeMillis();
        for(int i = 0; i < aSuppr.length; i++) {
            dico.supprimer(aSuppr[i]);
        }
        fin = System.currentTimeMillis();

        dureeSuppressionListe = fin - debut;

        System.out.println("Durée de la suppression : " + dureeSuppressionListe + " ms");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true));
            bw.write(String.valueOf(dureeSuppressionListe));
            bw.newLine();
            
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // Gestion des fichiers.
        String fichierResuInsertionAbr = "resuInsertionAbr.txt";
        String fichierResuSuppressionAbr = "resuSuppressionAbr.txt";
        String fichierResuInsertionListe = "resuInsertionListe.txt";
        String fichierResuSuppressionListe = "resuSuppressionListe.txt";

        // Etape 1 : création de l'ensemble des éléments à insérer
        int nbElement = 10000;
        Element elements[] = new Element[nbElement];

        int indice = 0;
        Random rand = new Random();

        while(indice < nbElement) {
            int cle = rand.nextInt(1000000);

            elements[indice] = new Element(cle, String.valueOf(indice));

            indice++;
        }

        // Etape 2 : création de l'ensemble des éléments à supprimer
        double probaSuppression = 0.15;

        Element aSuppr[] = new Element[1000];

        int nbElemSuppr = 0;
        
        for(int i = 0; i < elements.length; i++) {
            double proba = rand.nextDouble();
            if(proba < probaSuppression && nbElemSuppr < 1000) {
                aSuppr[nbElemSuppr] = elements[i];
                nbElemSuppr++;
            }
        }

        Element aInserer[] = new Element[1000];

        for(int i = 0; i < aInserer.length; i++) {
            int cle = rand.nextInt(1000000);

            aInserer[i] = new Element(cle, String.valueOf(i));
        }

        // Arbre binaire
        ArbreBinaire dicoAbr = new ArbreBinaire();

        // Insertion des 10_000 éléments        
        for(int i = 0; i < elements.length; i++) {
            dicoAbr.inserer(elements[i]);
        }

        System.out.println("--- ABR : ---");
        // Insertion de 1000 éléments supplémentaires
        insertionDansArbre(dicoAbr, aInserer, fichierResuInsertionAbr);
        
        // Suppression des éléments conservés
        suppressionDansArbre(dicoAbr, aSuppr, fichierResuSuppressionAbr);
        System.out.println("Hauteur: "+dicoAbr.hauteur());

        // Liste Chainee
        System.out.println("--- Liste Chainee : ---");
        DicoListe dicoListe = new DicoListe();

        // Insertion des 10_000 éléments
        for(int i = 0; i < elements.length; i++) {
            dicoListe.inserer(elements[i]);
        }

        // Insertion des 1_000 éléments supplémentaire
        insertionDansListeChainee(dicoListe, aInserer, fichierResuInsertionListe);
        
        // Suppression des 1_000 éléments conservés
        suppressionDansListeChainee(dicoListe, aSuppr, fichierResuSuppressionListe);
    }
}
