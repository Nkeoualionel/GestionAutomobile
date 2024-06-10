package clients.models;

import clients.enums.TypeClient;
import clients.utils.GestionDates;

import java.io.Serializable;

public class Client implements Serializable {
    public  String nomClient;
    public TypeClient typeClient;
    public GestionDates date;

    public int nombreLocation = 0;

    public Client() {

    }
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
