package clients.models;

import clients.enums.TypeClient;
import clients.utils.GestionDates;

public class ClientProfessionnel extends Client {
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
                    " nom = " + nomClient + '\'' +
                    ", type = " + typeClient +
                    ", date = " + date.getDate() +
                    ", tauxRemise = " + tauxRemise +
                '}';
    }
}
