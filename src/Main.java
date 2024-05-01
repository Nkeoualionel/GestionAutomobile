import clientele.data.Client;
import clientele.enums.TypeClient;
import clientele.model.ClientParticulier;
import clientele.model.ClientProfessionnel;
import clientele.utils.GestionDates;


public class Main {
    public static void main(String[] args) {

        Client client =  Client.getInstance();
        ClientProfessionnel en = new ClientProfessionnel("NKEOUA", TypeClient.PROFESSIONNEL, new GestionDates("01/05/2024"), 23);
        ClientParticulier cp = new ClientParticulier("NKEOUA", TypeClient.PARTICULIER, new GestionDates("20/12/2023"), "Lionel", 29, "5 Impasse de l'epi", 23);
        client.ajoutClientPro(en);
        client.ajoutClientParti(cp);

        client.afficherClients();
    }
}