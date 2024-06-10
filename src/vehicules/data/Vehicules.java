package vehicules.data;

import vehicules.models.Berline;
import vehicules.models.Break;
import vehicules.models.Utilitaire;
import vehicules.models.Vehicule;
import exception.GestionAutomobileVehiculesVenteException;
import gestion.data.Gestion;

import java.util.ArrayList;
import java.util.Vector;

public class Vehicules extends Vector<Vehicule> {
    public static Vehicules instance = null;
    public Vector<Berline> berlines;
    public Vector<Break> breaks;
    public Vector<Utilitaire> utilitaires;

    ArrayList<Vehicule> vehicules = new ArrayList<>();

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

    public static void setInstance(Vehicules vehiculesInstance) {
        instance = vehiculesInstance;
    }


    //Ajoute un vehicule si et seulement si le kim
    public void ajouterVehicule(Vehicule vehicule) throws GestionAutomobileVehiculesVenteException {
        if(vehicule.getKilometrageFin() >= Gestion.KILOMETRAGE_MAX_VENTE) {
            throw new GestionAutomobileVehiculesVenteException();
        }

        vehicules.add(vehicule);
    }

    public void setVehicules(ArrayList<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    /*
          Méthode qui retourne une liste de classe generique, qui est un ensemble des
         */
    public ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }
}
