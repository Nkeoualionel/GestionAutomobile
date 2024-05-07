package gestion.models;

import automobile.data.Vehicules;
import automobile.models.Berline;
import automobile.models.Break;
import automobile.models.Utilitaire;
import automobile.models.Vehicule;
import gestion.data.Gestion;

public class GestionVente {

    private Gestion gestion;
    private Vehicules vehicules;

    public GestionVente(Gestion gestion, Vehicules vehicules) {
        this.gestion = gestion;
        this.vehicules = vehicules;
    }

    public double demandeDeVente(Vehicule vehicule) {
        if (gestion.estDispoVente(vehicule) && vehicule.getKilometrage() <= gestion.kilometrageMaximumVente) {
            double prixVente = getTarif(vehicule);
            gestion.vehiculesDispoVente.remove(vehicule);

            if(vehicule instanceof Break) {
                vehicules.breaks.remove(vehicule);
            }

            if(vehicule instanceof Berline) {
                vehicules.berlines.remove(vehicule);
            }

            if(vehicule instanceof Utilitaire) {
                vehicules.utilitaires.remove(vehicule);
            }
            return prixVente;
        }

        return 0.0;
    }

    public double getTarif(Vehicule vehicule) {
        // retourne prix de la vente
        return gestion.prixVente(vehicule);
    }

    @Override
    public String toString() {
        return "GestionVente { " +
                    "gestion = " + gestion +
                    ", vehicules = " + vehicules +
                '}';
    }
}
