package gestion.models;

import vehicules.models.Vehicule;
import clients.models.Client;
import clients.models.ClientParticulier;
import clients.models.ClientProfessionnel;
import clients.utils.GestionDates;
import exception.GestionAutomobileVehiculesLocationException;
import gestion.data.Gestion;

public class GestionLocation {
    private Gestion gestion;

    public GestionLocation(Gestion gestion) {
        this.gestion = gestion;
    }

    public boolean demandeDeLocation(Vehicule vehicule, Client client) throws GestionAutomobileVehiculesLocationException {
        if(!gestion.estDispoLocation(vehicule)) {
          throw new GestionAutomobileVehiculesLocationException()  ;
        }
        gestion.vehiculesDispoLocation.remove(vehicule);
        gestion.vehiculesEnLocation.put(client, vehicule);
        client.nombreLocation++;
        return true;
    }

    public double getTarif(Vehicule vehicule, Client client) {
        Integer nombreDeLocation = null;
        Double tauxRemise = null;
        if(client instanceof ClientParticulier) {
            nombreDeLocation = client.getNombreLocation();
        }

        if(client instanceof  ClientProfessionnel) {
            tauxRemise = ((ClientProfessionnel) client).getTauxRemise();
        }

        int datesDebutLocation = client.date.getDateEnInt();

        GestionDates dates = new GestionDates();
        dates.setDate(vehicule.getDateFin());
        int dateFinLocation = dates.getDateEnInt();

        //Calcule du nombre de jour
        int nombreDeJour = dateFinLocation - datesDebutLocation;
        return gestion.prixLocation(vehicule, nombreDeLocation, tauxRemise, nombreDeJour);
    }

    public double finDeLocation(Vehicule vehicule, Client client) {
        Gestion gestion = Gestion.getInstance();
        gestion.terminerLocation(client, vehicule, vehicule.getDateFin(), vehicule.getKilometrageFin());
        return getTarif(vehicule, client);
    }

    @Override
    public String toString() {
        return "GestionLocation { " +
                    "gestion = " + gestion +
                '}';
    }
}
