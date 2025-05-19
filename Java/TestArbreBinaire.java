public class TestArbreBinaire {
    public static void main(String[] args) {
        ArbreBinaire abr = new ArbreBinaire();

        Element e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;

        e1 = new Element(12, "1.3");
        e2 = new Element(25, "2.1");
        e3 = new Element(7, "3.6");
        e4 = new Element(9, "4.3");
        e5 = new Element(11, "5.2");
        e6 = new Element(4, "6.8");
        e7 = new Element(1, "7.4");

        abr.inserer(e1);
        abr.inserer(e2);
        abr.inserer(e3);
        abr.inserer(e4);
        abr.inserer(e5);
        abr.inserer(e6);
        abr.inserer(e7);

        System.out.print("abr : ");
        abr.afficher();
        System.out.println();
        System.out.println("Hauteur de l'abr : " + abr.hauteur());

        System.out.println("--- Recherche ---");
        System.out.println(abr.rechercher(11));
        System.out.println(abr.rechercher(4));
        System.out.println(abr.rechercher(13));

        e8 = new Element(5, "112");
        e9 = new Element(20,"123");
        e10 = new Element(22, "320");

        abr.supprimer(e7);
        abr.inserer(e8);
        abr.inserer(e9);
        abr.inserer(e10);
        abr.supprimer(e1);

        System.out.println("--- Après Suppression et Insertion ---");
        abr.afficher();
        System.out.println();

        System.out.println("Hauteur de l'abr après modification: " + abr.hauteur());
    }
}
