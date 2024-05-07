package clientele.models;

import clientele.enums.TypeClient;
import clientele.utils.GestionDates;

public class Client {
    public  String nomClient;
    public TypeClient typeClient;
    public GestionDates date;

    public int nombreLocation = 0;

    public Client(String nomClient, TypeClient typeClient, GestionDates date) {
        this.nomClient = nomClient;
        this.typeClient = typeClient;
        this.date = date;
        this.nombreLocation++;
    }

    public String getNom() {
        return nomClient;
    }

    public void setNom(String nomClient) {
        this.nomClient = nomClient;
    }

    public TypeClient getType() {
        return typeClient;
    }

    public void setType(TypeClient typeClient) {
        this.typeClient = typeClient;
    }

    public GestionDates getDate() {
        return date;
    }

    public void setDate(GestionDates date) {
        this.date = date;
    }

    public int getNombreLocation() {return nombreLocation;}
}
