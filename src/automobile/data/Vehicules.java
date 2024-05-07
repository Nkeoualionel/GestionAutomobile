package automobile.data;

import automobile.models.Berline;
import automobile.models.Break;
import automobile.models.Utilitaire;
import automobile.models.Vehicule;

import java.util.ArrayList;
import java.util.Vector;

public class Vehicules extends Vector<Vehicule> {
    public static Vehicules instance = null;
    public Vector<Berline> berlines;
    public Vector<Break> breaks;
    public Vector<Utilitaire> utilitaires;

    public Vehicules() {
        berlines = new Vector<>();
        breaks = new Vector<>();
        utilitaires = new Vector<>();
    }

    //Singleton: Cette méthode renvoie toujours la même instance de la classe Vehicules, en s'assurant
    // qu'il n'y a qu'une seule instance de cette classe dans toute l'application.
    public static Vehicules getInstance() {
        return instance == null ?  instance = new Vehicules() : instance;
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
