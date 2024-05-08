package clientele.data;

import clientele.models.Client;
import clientele.models.ClientParticulier;
import clientele.models.ClientProfessionnel;
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
        - Si le client n'existe pas et son âge n'est pas négatif, tu ajoutes.
        - Au cas contraire, n'ajoute pas
    */
    public void ajouterClient(Client client) throws GestionAutomobileClientsException {
        for (Client c : clients) {
            if(c.equals(client)) {
                throw new GestionAutomobileClientsException("Ce client existe déjà.");
            }
        }

        if(client instanceof ClientParticulier) {
            int age = ((ClientParticulier) client).getAge();
            if(age < 0) {
                throw new GestionAutomobileClientsParticuliersException("L'âge ne peut pas être négatif");
            }
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

    public ArrayList<Client> getClients() {
        return clients;
    }
}
