package sauvegarde;

import vehicules.data.Vehicules;
import vehicules.models.Vehicule;
import clients.data.Clients;
import clients.models.Client;
import gestion.data.Gestion;

import java.io.*;
import java.util.*;

public class Sauvegarde implements Serializable {

    public static void sauvegardeDonnees(String repertoire, Gestion gestion, Clients clients, Vehicules vehicules) {
        writerFile("", "/clients.ser", clients);
        writerFile("", "/vehicules.ser", vehicules);
        writerFile("", "/vehicule_dispo_location.ser", gestion);
        writerFile("", "/vehicule_dispo_vente.ser", gestion);
        writerFile("", "/vehicule_en_location.ser", gestion);
    }

    public static void chargementDonnees(String repertoire) {
        ArrayList<Client> clientArrayList = new ArrayList<>(); //Liste des clients
        for (Object obj : readerFile("","/clients.ser")) { // Itérer sur les éléments de l'ArrayList rentourner par la méthode readerFile
            if (obj instanceof Client) { // Verifier si l'objet est une instance de client
                clientArrayList.add((Client) obj); // Convertir ce objet en client puis l'ajouter dans list des clients
            }
        }
        Clients.getInstance().setClients(clientArrayList); //Ajouter cette liste des

        //Même procedure que la précedante pour les clients
        ArrayList<Vehicule> vehiculeArrayList = new ArrayList<>();
        for (Object obj : readerFile("","/vehicules.ser")) {
            if (obj instanceof Vehicule) {
                vehiculeArrayList.add((Vehicule) obj);
            }
        }
        Vehicules.getInstance().setVehicules(vehiculeArrayList);

        readerFile("","/vehicule_dispo_location.ser");

        readerFile("","/vehicule_dispo_vente.ser");

        readerFile("","/vehicule_en_location.ser");
    }

    public static void writerFile(String repertoire, String filename, Object object)  {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(repertoire + filename);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            if(object instanceof Clients) {
                outputStream.writeObject(((Clients) object).getClients());
            }

            if(object instanceof Vehicules) {
                outputStream.writeObject(((Vehicules) object).getVehicules());
            }

            if(object instanceof Gestion) {
                if(filename.equals("/vehicule_dispo_location.ser")) {
                    outputStream.writeObject(((Gestion) object).getVehiculesDispoLocation());
                }

                if(filename.equals("/vehicule_dispo_vente.ser")) {
                    outputStream.writeObject(((Gestion) object).getVehiculesDispoVente());
                }

                if(filename.equals("/vehicule_en_location.ser")) {
                    outputStream.writeObject(((Gestion) object).getVehiculesEnLocation());
                }
            }

            outputStream.flush();
            fileOutputStream.flush();
        }catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static ArrayList<?> readerFile(String repertoire, String filename) {
        ArrayList<Object> newList = new ArrayList<>(); // Créez une nouvelle ArrayList pour contenir les objets  ArrayList (Vehicule | Client)
        Gestion gestion = Gestion.getInstance();
        try {
            FileInputStream fileInputStream1 = new FileInputStream(repertoire + filename);
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
            Object object = objectInputStream1.readObject();

            if (object instanceof ArrayList) { // Vérifiez si l'objet est une instance de ArrayList
                ArrayList<?> list = (ArrayList<?>) object;  //Convertir l'object en ArrayList
                for (Object elem : list) { // Itérer sur les éléments de l'ArrayList d'origine
                    if (elem instanceof Vehicule) { //Vérifiez si chaque élément est une instance de Vehicule
                        newList.add(elem); //Ajoutez l'objet à la nouvelle ArrayList
                    }

                    if(elem instanceof Client) { //Vérifiez si chaque élément est une instance de Client
                        newList.add(elem); //Ajoutez l'objet à la nouvelle ArrayList
                    }
                }
            }

            if(object instanceof HashSet<?> list) {
                gestion.vehiculesDispoLocation.addAll((Collection<? extends Vehicule>) list);
            }

            if(object instanceof LinkedList<?> list) {
                gestion.vehiculesDispoVente.addAll((Collection<? extends Vehicule>) list);
            }

            if(object instanceof HashMap<?,?> list) {
                gestion.vehiculesEnLocation.putAll((Map<? extends Client, ? extends Vehicule>) list);
            }

            fileInputStream1.close();
            objectInputStream1.close();

            return newList;
        }catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return newList;
    }
}



