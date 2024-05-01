package clientele.data;

import clientele.model.ClientParticulier;
import clientele.model.ClientProfessionnel;

import java.util.ArrayList;

public class Client {
    private static Client instance = null;
    private ArrayList<ClientParticulier> clientsParticuliers;
    private ArrayList<ClientProfessionnel> clientsProfessionnels;

    private Client() {
        clientsParticuliers = new ArrayList<>();
        clientsProfessionnels = new ArrayList<>();
    }

    public static Client getInstance() {
        return instance == null ?  instance = new Client() : instance;
    }

    public void ajoutClientParti(ClientParticulier client) {
        if(client == null) {
            System.out.println("Vous ne pouvez ajouter un client null");
            return;
        }

        clientsParticuliers.add(client);
    }

    public void ajoutClientPro(ClientProfessionnel client) {
        if(client == null) {
            System.out.println("Vous ne pouvez ajouter un client null");
            return;
        }
        clientsProfessionnels.add(client);
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
