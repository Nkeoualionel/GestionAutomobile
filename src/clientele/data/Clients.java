package clientele.data;

import clientele.models.Client;
import clientele.models.ClientParticulier;
import clientele.models.ClientProfessionnel;

import java.util.ArrayList;

public class Clients extends ArrayList<Client>{
    private static Clients instance = null;
    private ArrayList<ClientParticulier> clientsParticuliers;
    private ArrayList<ClientProfessionnel> clientsProfessionnels;

    private Clients() {
        clientsParticuliers = new ArrayList<>();
        clientsProfessionnels = new ArrayList<>();
    }

    public static Clients getInstance() {
        return instance == null ?  instance = new Clients() : instance;
    }

    public void afficherClients() {
        for (ClientParticulier client : clientsParticuliers) {
            System.out.println(client);
        }
        for (ClientProfessionnel client : clientsProfessionnels) {
            System.out.println(client);
        }
    }
}
