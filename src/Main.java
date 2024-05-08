import automobile.data.Vehicules;
import automobile.enums.Constructeur;
import automobile.enums.NombreDePortes;
import automobile.enums.TypeVehicule;
import automobile.models.Berline;
import automobile.models.Break;
import automobile.models.Immatriculation;
import automobile.models.Vehicule;
import clientele.data.Clients;
import clientele.enums.TypeClient;
import clientele.models.Client;
import clientele.models.ClientParticulier;
import clientele.models.ClientProfessionnel;
import clientele.utils.GestionDates;
import gestion.data.Gestion;
import gestion.models.GestionLocation;
import gestion.models.GestionVente;


public class Main {
    public static void main(String[] args) {

        Clients clients =  Clients.getInstance();
        Client client = new ClientProfessionnel("NKEOUA", TypeClient.PROFESSIONNEL, new GestionDates("01/05/2024"), 23);
        Client client1 = new ClientParticulier("NKEOUA", TypeClient.PARTICULIER, new GestionDates("01/05/2024"), "Lionel", 29, "5 Impasse de l'epi", 23);
        clients.add(client);
        clients.add(client1);


        Vehicules vehicules = Vehicules.getInstance();
        Vehicule vehicule = new Berline(TypeVehicule.BERLINE, NombreDePortes.QUATRE, new Immatriculation("344 AC 4"), Constructeur.CITROEN, "4x4", 230.0, 20000, 300, "10/05/2024");
        Vehicule vehicule1 = new Break(TypeVehicule.BREAK, NombreDePortes.DEUX, new Immatriculation("522 CG 4"), Constructeur.PEUGEOT, "4x4", 300.0, 30000, 400, "10/05/2024");

        vehicules.add(vehicule);
        vehicules.add(vehicule1);

        Gestion gestion = new Gestion();
        gestion.vehiculesDispoLocation.addAll(vehicules);
        gestion.vehiculesDispoVente.addAll(vehicules);

        GestionLocation gestionLocation = new GestionLocation(gestion);
        GestionVente gestionVente = new GestionVente(gestion, vehicules);

        //convertion de la date debut location en Int
        int datesDebutLocation = client.date.getDateEnInt();

        // Parsing et convertion de la date fin location en int
        GestionDates gestionDates = new GestionDates();
        gestionDates.setDate(vehicule.getDateFin());
        int datesFinLocation = gestionDates.getDateEnInt();

        //Calcule du nombre de jour séparant les 2 dates (debut et fin de location)
        int nombreDeJour = gestionDates.nombreJour(datesFinLocation , datesDebutLocation);

        boolean demandeDeLocation = gestionLocation.demandeDeLocation(vehicule, client);
        double locationTarif =  gestionLocation.getTarif(vehicule, client);

        double prixVehicule = gestionVente.demandeDeVente(vehicule);
        double tarif = gestionVente.getTarif(vehicule);

        double prixVente =  gestion.prixVente(vehicule);
        double prixLocation =  gestion.prixLocation(vehicule, client.nombreLocation, null, nombreDeJour);

        String test = "ee";
    }
}