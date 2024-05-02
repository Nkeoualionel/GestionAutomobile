package automobile.data;

import automobile.models.Berline;
import automobile.models.Break;
import automobile.models.Utilitaire;

import java.util.Vector;

public class Vehicules {
    private static Vehicules instance = null;
    private Vector<Berline> berlines;
    private Vector<Break> breaks;
    private Vector<Utilitaire> utilitaires;

    private Vehicules() {
        berlines = new Vector<>();
        breaks = new Vector<>();
        utilitaires = new Vector<>();
    }

    //Singleton: Cette méthode renvoie toujours la même instance de la classe Vehicules, en s'assurant
    // qu'il n'y a qu'une seule instance de cette classe dans toute l'application.
    public static Vehicules getInstance() {
        return instance == null ?  instance = new Vehicules() : instance;
    }

    public void ajouterBerline(Berline berline) {
        if(berline == null) {
            return;
        }
        berlines.add(berline);
    }

    public void ajouterBreak(Break berline) {
        if(berline == null) {
            return;
        }
        breaks.add(berline);
    }

    public void ajouterUtilitaire(Utilitaire utilitaire) {
        if(utilitaire == null) {
            return;
        }
        utilitaires.add(utilitaire);
    }


    public void afficherVehicules() {
        for (Berline berline : berlines) {
            System.out.println(berline);
        }

        for (Break br: breaks) {
            System.out.println(br);
        }

        for (Utilitaire utilitaire : utilitaires) {
            System.out.println(utilitaire);
        }
    }
}
