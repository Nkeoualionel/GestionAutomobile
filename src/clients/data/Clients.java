package clients.data;

import clients.models.Client;
import clients.models.ClientParticulier;
import exception.GestionAutomobileClientsException;
import exception.GestionAutomobileClientsParticuliersException;

import java.util.ArrayList;

public class Clients extends ArrayList<Client>{
    private static Clients instance = null;
    private ArrayList<Client> clients;

    private Clients() {
        clients = new ArrayList<>();
    }

    /*Singleton: Cette méthode renvoie toujours la même instance de la classe Vehicules, en s'assurant
     qu'il n'y a qu'une seule instance de cette classe dans toute l'application */
    public static Clients getInstance() {
        return instance == null ?  instance = new Clients() : instance;
    }

    public static void setInstance(Clients clientsInstance) {
        instance = clientsInstance;
    }

    /*Ajout du client:
        - Si le client existe déjà genère une exception.
        - Si c'est un client particulier et son age est inférieur à 0 genère une exception.
        - Sinon tu peux ajouter le client
    */
    public void ajouterClient(Client client) throws GestionAutomobileClientsException {
        for (Client c : clients) {
            if(c.equals(client)) {
                throw new GestionAutomobileClientsException(c.typeClient.name(), c.nomClient);
            }
        }

        if(client instanceof ClientParticulier && ((ClientParticulier) client).getAge() < 0) {
            throw new GestionAutomobileClientsParticuliersException("L'âge ne peut pas être négatif");
        }

        clients.add(client);
    }

    /*
    Affiche la liste des clients via une boucle
     */
    public void afficherClients() {
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}
