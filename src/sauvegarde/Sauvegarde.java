package sauvegarde;

import automobile.data.Vehicules;
import clientele.data.Clients;
import gestion.data.Gestion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sauvegarde {

    public static void sauvegardeDonnees(String repertoire, Gestion gestion, Clients clients, Vehicules vehicules) {
          try {
                  FileOutputStream fileOutputStream = new FileOutputStream(repertoire + "/donnees.ser");
                  ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
                  oos.writeObject(clients.getClients());
                  oos.writeObject(vehicules.getVehicules());
                  oos.writeObject(gestion.getVehiculesDispoLocation());
                  oos.writeObject(gestion.getVehiculesDispoVente());
                  oos.writeObject(gestion.getVehiculesEnLocation());
          } catch (IOException exception) {
              System.out.println(exception.getMessage());
          }
    }


    public static void chargementDonnees(String repertoire) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(repertoire + "/donnees.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}



