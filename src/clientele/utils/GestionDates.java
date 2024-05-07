package clientele.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestionDates {
    private String date;
    private final String format = "dd/MM/yyyy";
    private SimpleDateFormat simpleDateFormat;

    public GestionDates() {
        this.simpleDateFormat = new SimpleDateFormat(format);
    }
    public GestionDates(String date) {
        this.date = date;
        this.simpleDateFormat = new SimpleDateFormat(format);
    }

    // méthode pour parser la date puis la retourne en format string
    public String getDate() {
        try {
            return simpleDateFormat.parse(date).toString();
        }catch (ParseException e) {
            return "Error parsing"; // Renvoie ce message pour indiquer une erreur ou enlevé l'exception
        }
    }

    public void setDate(String date) {
        this.date = date;
    }

    //Méthode qui parse la date et la retourne en format int
    public int getDateEnInt() {
        try {
            Date parsedDate = simpleDateFormat.parse(date);
            int year = parsedDate.getYear() + 1900;
            int month = parsedDate.getMonth() + 1; // Le mois est de base 0, on ajoute 1
            int day = parsedDate.getDate();

            // Combinez l'année, le mois et le jour en un entier au format AAAAMMJJ
            return year * 10000 + month * 100 + day;
        } catch (ParseException e) {
            return -1; // Renvoie -1 ou lève une exception pour indiquer une erreur
        }
    }

    public int nombreJour(int dateFin, int dateDebut) {
        return dateFin - dateDebut;
    }
}
