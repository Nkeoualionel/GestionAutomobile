package clientele.models;

import clientele.enums.TypeClient;
import clientele.utils.GestionDates;

public class Location {
    public  String nom;
    public TypeClient type;
    public GestionDates date;

    public Location(String nom, TypeClient type, GestionDates date) {
        this.nom = nom;
        this.type = type;
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeClient getType() {
        return type;
    }

    public void setType(TypeClient type) {
        this.type = type;
    }

    public GestionDates getDate() {
        return date;
    }

    public void setDate(GestionDates date) {
        this.date = date;
    }
}
