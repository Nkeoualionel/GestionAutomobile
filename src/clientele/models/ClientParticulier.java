package clientele.models;


import clientele.enums.TypeClient;
import clientele.utils.GestionDates;

public class ClientParticulier extends Location {
    public String prenom;
    public int age;
    public String adresse;
    public int nombreLocations;

    public ClientParticulier(String nom, TypeClient typeClient, GestionDates dateLocation, String prenom, int age, String adresse, int nombreLocations) {
        super(nom, typeClient, dateLocation);
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.nombreLocations = nombreLocations;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNombreLocations() {
        return nombreLocations;
    }

    public void setNombreLocations(int nombreLocations) {
        this.nombreLocations = nombreLocations;
    }

    @Override
    public String toString() {
        return "ClientParticulier { " +
                    " nom = '" + nom + '\'' +
                    " prenom = '" + prenom + '\'' +
                    ", age = " + age +
                    ", adresse = '" + adresse + '\'' +
                    ", nombreLocations = " + nombreLocations +
                    ", type = " + type +
                    ", date = " + date.getDate() +
                '}';
    }
}
