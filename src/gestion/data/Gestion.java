package gestion.data;

import automobile.models.Vehicule;
import clientele.enums.TypeClient;
import clientele.models.Client;
import clientele.utils.GestionDates;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Gestion {
    public HashSet<Vehicule> vehiculesDispoLocation;
    public LinkedList<Vehicule> vehiculesDispoVente;
    public HashMap<Client, Vehicule> vehiculesEnLocation;
    public double kilometrageVente;
    public double kilometrageMaximumVente;

    //Constructeur sans argument qui initialise
    public Gestion() {
        this.vehiculesDispoLocation = new HashSet<>();
        this.vehiculesDispoVente = new LinkedList<>();
        this.vehiculesEnLocation = new HashMap<>();
        this.kilometrageVente = 0.0;
        this.kilometrageMaximumVente = 100000.0;
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
