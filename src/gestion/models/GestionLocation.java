package gestion.models;

import automobile.models.Vehicule;
import clientele.models.Client;
import clientele.models.ClientParticulier;
import clientele.models.ClientProfessionnel;
import clientele.utils.GestionDates;
import gestion.data.Gestion;

public class GestionLocation {
    private Gestion gestion;

    public GestionLocation(Gestion gestion) {
        this.gestion = gestion;
    }

    public boolean demandeDeLocation(Vehicule vehicule, Client client) {
        if (gestion.estDispoLocation(vehicule)) {
            gestion.vehiculesDispoLocation.remove(vehicule);
            gestion.vehiculesEnLocation.put(client, vehicule);
            client.nombreLocation++;
            return true;
        }

        return false;
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

    public double finDeLocation(Vehicule vehicule, Client client, String dateFin, double kilometrageFin) {
        gestion.vehiculesEnLocation.remove(client);
        vehicule.setKilometrageFin(kilometrageFin);
        vehicule.setDateFin(dateFin);
        gestion.vehiculesDispoLocation.add(vehicule);
        return getTarif(vehicule, client);
    }

    @Override
    public String toString() {
        return "GestionLocation { " +
                    "gestion = " + gestion +
                '}';
    }
}
