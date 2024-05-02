package clientele.models;

import clientele.enums.TypeClient;
import clientele.utils.GestionDates;

public class ClientProfessionnel extends Location {
    private double tauxRemise;
    public ClientProfessionnel(String nom, TypeClient type, GestionDates date, double tauxRemise) {
        super(nom, type, date);
        this.tauxRemise = tauxRemise;
    }

    public double getTauxRemise() {
        return tauxRemise;
    }

    public void setTauxRemise(double tauxRemise) {
        this.tauxRemise = tauxRemise;
    }

    @Override
    public String toString() {
        return "ClientProfessionnel { " +
                    " nom = " + nom + '\'' +
                    ", type = " + type +
                    ", date = " + date.getDate() +
                    ", tauxRemise = " + tauxRemise +
                '}';
    }
}
