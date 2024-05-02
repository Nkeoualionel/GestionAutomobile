import automobile.data.Vehicules;
import automobile.enums.Constructeur;
import automobile.enums.NombreDePortes;
import automobile.enums.TypeVehicule;
import automobile.models.Berline;
import automobile.models.Break;
import automobile.models.Immatriculation;
import clientele.data.Clients;
import clientele.enums.TypeClient;
import clientele.models.ClientParticulier;
import clientele.models.ClientProfessionnel;
import clientele.utils.GestionDates;


public class Main {
    public static void main(String[] args) {

        Clients client =  Clients.getInstance();

        ClientProfessionnel en = new ClientProfessionnel("NKEOUA", TypeClient.PROFESSIONNEL, new GestionDates("01/05/2024"), 23);
        ClientParticulier cp = new ClientParticulier("NKEOUA", TypeClient.PARTICULIER, new GestionDates("20/12/2023"), "Lionel", 29, "5 Impasse de l'epi", 23);

        client.ajoutClientPro(null);
        client.ajoutClientParti(cp);

        client.afficherClients();

        Vehicules vehicules = Vehicules.getInstance();
        Berline berline = new Berline(TypeVehicule.BERLINE, NombreDePortes.QUATRE, new Immatriculation("344 AC 4"), Constructeur.CITROEN, "4x4", 230.0, 20000);
        Break breaks = new Break(TypeVehicule.BREAK, NombreDePortes.DEUX, new Immatriculation("344 AC 4"), Constructeur.PEUGEOT, "4x4", 300.0, 30000);

        vehicules.ajouterBerline(berline);
        vehicules.ajouterBreak(breaks);

        vehicules.afficherVehicules();
    }
}