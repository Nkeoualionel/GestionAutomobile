package gestion.models;

import vehicules.data.Vehicules;
import vehicules.models.Vehicule;
import gestion.data.Gestion;

public class GestionVente {

    private Gestion gestion;
    private Vehicules vehicules;

    public GestionVente(Gestion gestion, Vehicules vehicules) {
        this.gestion = gestion;
        this.vehicules = vehicules;
    }

    public double getTarif(Vehicule vehicule) {
        // retourne prix de la vente
        return gestion.prixVente(vehicule);
    }

    public double demandeDeVente(Vehicule vehicule) {
        if (gestion.estDispoVente(vehicule) && vehicule.getKilometrage() <= Gestion.KILOMETRAGE_MAX_VENTE) {
            double prixVente = getTarif(vehicule);
            gestion.vehiculesDispoVente.remove(vehicule);

            return Math.round(prixVente * 100.0) / 100.0;
        }

        return 0.0;
    }

    @Override
    public String toString() {
        return "GestionVente { " +
                    "gestion = " + gestion +
                    ", vehicules = " + vehicules +
                '}';
    }
}
