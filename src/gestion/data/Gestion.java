package gestion.data;

import vehicules.models.Vehicule;
import clients.models.Client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Gestion {
    public static Gestion instance = null;
    public HashSet<Vehicule> vehiculesDispoLocation;
    public LinkedList<Vehicule> vehiculesDispoVente;
    public HashMap<Client, Vehicule> vehiculesEnLocation;
    public static final double KILOMETRAGE_VENTE = 100000.0;
    public static final double KILOMETRAGE_MAX_VENTE = 200000.0;

    public Gestion() {
        this.vehiculesDispoLocation = new HashSet<>();
        this.vehiculesDispoVente = new LinkedList<>();
        this.vehiculesEnLocation = new HashMap<>();
    }

    /*Singleton: Cette méthode renvoie toujours la même instance de la classe Vehicules, en s'assurant
       qu'il n'y a qu'une seule instance de cette classe dans toute l'application.*/
    public static Gestion getInstance() {
        if(instance == null) {
            instance = new Gestion();
        }
        return instance;
    }

    public static void setInstance(Gestion gestion) {
        instance = gestion;
    }

    //Verification si un véhicule spécifique fait parti des véhicules en location disponible
    //Un vehicule est en location ssi, il n'est pas disponible pour la vente et n'est pas actuellement
    //dejà en location
    public boolean estDispoLocation(Vehicule vehicule) {
        return !vehiculesDispoVente.contains(vehicule) && !vehiculesEnLocation.containsValue(vehicule);
    }

    //Verification si un véhicule spécifique fait parti des véhicules en vente disponible
    public boolean estDispoVente(Vehicule vehicule) {
        return vehiculesDispoVente.contains(vehicule);
    }

    //Verification si un véhicule spécifique est en location actuellement
    public boolean estEnLocation(Vehicule vehicule) {
        return vehiculesEnLocation.get(vehicule) != null;
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
            //Arrondire le prixLocation pour avoir un prix ayant 2 chiffre après la virgule
            return Math.round(prixLocation * 100.0) / 100.0;
        }

        return 0.0;
    }


    //Calcule du prix de vente d'un véhicule
    public double prixVente(Vehicule vehicule) {
        return Math.round((vehicule.getPrixAchat() *  KILOMETRAGE_MAX_VENTE) / (KILOMETRAGE_MAX_VENTE + vehicule.getKilometrage()) * 100.0) / 100.0;
    }


    public void terminerLocation(Client client, Vehicule vehicule, String dateFin, double kilometrageFin) {
        vehiculesEnLocation.remove(client);
        vehicule.setDateFin(dateFin);
        vehicule.setKilometrageFin(kilometrageFin);

        // Vérifier si le véhicule est disponible à la vente en fonction du kilométrage
        if (kilometrageFin <= KILOMETRAGE_VENTE) {
            vehiculesDispoLocation.add(vehicule);
        }
    }

    @Override
    public String toString() {
        return "Gestion { " +
                    "  vehiculesDispoLocation = " + vehiculesDispoLocation +
                    ", vehiculesDispoVente = " + vehiculesDispoVente +
                    ", vehiculesEnLocation = " + vehiculesEnLocation +
                    ", kilometrageVente = " + KILOMETRAGE_VENTE +
                    ", kilometrageMaximumVente = " + KILOMETRAGE_MAX_VENTE +
                '}';
    }
}
