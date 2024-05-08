package gestion.data;

import automobile.models.Vehicule;
import clientele.models.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Gestion {
    public static Gestion instance = null;
    public HashSet<Vehicule> vehiculesDispoLocation;
    public LinkedList<Vehicule> vehiculesDispoVente;
    public HashMap<Client, Vehicule> vehiculesEnLocation;
    public double kilometrageVente;
    public double kilometrageMaximumVente;

    public Gestion() {
        this.vehiculesDispoLocation = new HashSet<>();
        this.vehiculesDispoVente = new LinkedList<>();
        this.vehiculesEnLocation = new HashMap<>();
        this.kilometrageVente = 0.0;
        this.kilometrageMaximumVente = 100000.0;
    }

    /*Singleton: Cette méthode renvoie toujours la même instance de la classe Vehicules, en s'assurant
       qu'il n'y a qu'une seule instance de cette classe dans toute l'application.*/
    public static Gestion getInstance() {
        if(instance == null) {
            instance = new Gestion();
        }
        return instance;
    }

    //Verification si un véhicule spécifique fait parti des véhicules en location disponible
    public boolean estDispoLocation(Vehicule vehicule) {
        return vehiculesDispoLocation.contains(vehicule);
    }

    //Verification si un véhicule spécifique fait parti des véhicules en vente disponible
    public boolean estDispoVente(Vehicule vehicule) {
        return vehiculesDispoVente.contains(vehicule);
    }

    //Verification si un véhicule spécifique est en location actuellement
    public boolean estEnLocation(Vehicule vehicule) {
        return vehiculesEnLocation.get(vehicule) != null;
    }

    //Calcule du prix de location d'un véhicule
    public double prixLocation(Vehicule vehicule, Integer nombreLocation, Double tauxRemise,  int nombreDeJour) {
        double reduction = 0.0;

        //Verification si c'est un client particulier
        if(nombreLocation != null) {
            reduction = (1.0 - 0.005) * nombreLocation;
        }

        //Verification si c'est un client professionnel
        if(tauxRemise != null) {
            reduction = tauxRemise;
        }

        double prixParKilometre = vehicule.getTypeVehicule().getPrixLocationParKm();
        double kilometrageEffectue = vehicule.getKilometrageFin() - vehicule.getKilometrage();

        //Formule de calcule
        double prixLocation = reduction * ((prixParKilometre * kilometrageEffectue) + (nombreDeJour * (1 + ((double) vehicule.getNombreDePortes().getNombre() / 10))));

        if(prixLocation > 0) {
            return prixLocation;
        }

        return 0.0;
    }


    //Calcule du prix de vente d'un véhicule
    public double prixVente(Vehicule vehicule) {
        return (vehicule.getPrixAchat() *  kilometrageMaximumVente) / (kilometrageMaximumVente + kilometrageVente);
    }

    public HashSet<Vehicule> getVehiculesDispoLocation() {
        return vehiculesDispoLocation;
    }

    public LinkedList<Vehicule> getVehiculesDispoVente() {
        return vehiculesDispoVente;
    }
    public HashMap<Client, Vehicule> getVehiculesEnLocation() {
        return vehiculesEnLocation;
    }

    @Override
    public String toString() {
        return "Gestion { " +
                    "  vehiculesDispoLocation = " + vehiculesDispoLocation +
                    ", vehiculesDispoVente = " + vehiculesDispoVente +
                    ", vehiculesEnLocation = " + vehiculesEnLocation +
                    ", kilometrageVente = " + kilometrageVente +
                    ", kilometrageMaximumVente = " + kilometrageMaximumVente +
                '}';
    }
}
