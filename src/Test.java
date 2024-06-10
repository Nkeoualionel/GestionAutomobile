import exception.GestionAutomobileVehiculesVenteException;
import vehicules.data.Vehicules;
import vehicules.enums.Constructeur;
import vehicules.enums.NombreDePortes;
import vehicules.enums.TypeVehicule;
import vehicules.models.*;
import clients.data.Clients;
import clients.enums.TypeClient;
import clients.models.Client;
import clients.models.ClientParticulier;
import clients.models.ClientProfessionnel;
import clients.utils.GestionDates;
import exception.GestionAutomobileClientsException;
import exception.GestionAutomobileVehiculesException;
import gestion.data.Gestion;
import gestion.models.GestionLocation;
import gestion.models.GestionVente;
import sauvegarde.Sauvegarde;

public class Test {
    private static final Vehicules vehicules = Vehicules.getInstance();
    private static final  Clients clients =  Clients.getInstance();
    private static final Gestion gestion = Gestion.getInstance();
    public static void main(String[] args) throws GestionAutomobileVehiculesException, GestionAutomobileClientsException {
        testLocation();
        testVente();
        testExceptions();
    }


    public static void testLocation() throws GestionAutomobileClientsException, GestionAutomobileVehiculesException {

        Vehicule berline = new Berline(TypeVehicule.BERLINE, NombreDePortes.QUATRE, new Immatriculation("344 AC 4"), Constructeur.CITROEN, "4x4", 120.0, 150000, 120, "30/05/2024");
        Vehicule aBreak = new Break(TypeVehicule.BREAK, NombreDePortes.DEUX, new Immatriculation("522 CG 4"), Constructeur.PEUGEOT, "4x4", 120000.0, 30000, 400, "30/05/2024");
        Vehicule utilitaire = new Utilitaire(TypeVehicule.UTILITAIRE, NombreDePortes.DEUX, new Immatriculation("356 CG 4"), Constructeur.TESLA, "D", 300.0, 30000, 400, "30/05/2024");

        vehicules.ajouterVehicule(berline);
        vehicules.ajouterVehicule(aBreak);
        vehicules.ajouterVehicule(utilitaire);

        Client clientPro = new ClientProfessionnel("NKEOUA", TypeClient.PROFESSIONNEL, new GestionDates("01/05/2024"), 23);
        Client clientParti = new ClientParticulier("MBEMBA", TypeClient.PARTICULIER, new GestionDates("01/05/2024"), "Lionel", 29, "5 Impasse de l'epi", 23);
        Client clientParti1 = new ClientParticulier("SORY", TypeClient.PARTICULIER, new GestionDates("01/05/2024"), "Ibrahima", 27, "2 Impasse de l'epi", 10);

        clients.ajouterClient(clientPro);
        clients.ajouterClient(clientParti);
        clients.ajouterClient(clientParti1);

        gestion.vehiculesDispoVente.add(aBreak);
        gestion.vehiculesDispoLocation.add(berline);
        gestion.vehiculesEnLocation.put(clientPro, utilitaire);

        System.out.println("---------- DEBUT TEST LOCATION ----------");

        GestionLocation gestionLocation = new GestionLocation(gestion);

        boolean estDispoLocation = gestion.estDispoLocation(berline);
        System.out.println("Vérification de la disponibilité du véhicule pour une location");

        boolean demandeLocation = false;

        if(estDispoLocation) {
            System.out.println("Le véhicule est disponible pour une location");
            demandeLocation = gestionLocation.demandeDeLocation(berline, clientParti);
            System.out.println("Demande de location du véhicule effectué");
        }

        if(!estDispoLocation) {
            System.out.println("Ce véhicule n'est pas disponible pour une location");
        }

        double tarifLocation = gestionLocation.getTarif(berline, clientParti);;

        if(demandeLocation) {
            System.out.println("Demande de location du véhicule ACCEPTER");
            System.out.println("Le tarif de location de ce vehicule est estimé à "+tarifLocation+ " euro");

            gestion.vehiculesEnLocation.put(clientParti, berline);
            System.out.println("Vehicule en cours de location.......");

            double prixLocationFinal =  gestionLocation.finDeLocation(berline, clientParti);
            System.out.println("La location de ce véhicule vous a coûter " +prixLocationFinal+ " euro");
            System.out.println("Location terminer");
            System.out.println("Vehicule disponible a nouveau pour une location");
        }

        if(!demandeLocation) {
            System.out.println("Votre demande de location a été REFUSER");
            System.out.println("Le tarif de location de ce vehicule vous aurait couté "+tarifLocation+ " euro");
        }

        System.out.println("Sauvegarde de données");
        Sauvegarde.sauvegardeDonnees("", gestion, clients, vehicules);
        System.out.println("---------- FIN TEST LOCATION ----------");
    }


    public static void testVente()  {
        System.out.println("---------- DEBUT TEST VENTE ----------");
        Sauvegarde.chargementDonnees("");


        GestionVente gestionVente = new GestionVente(gestion, vehicules);

        Vehicule vehicule = vehicules.getVehicules().get(0);
        double prixVente = gestionVente.demandeDeVente(vehicule);

        if(prixVente == 0.0) {
            System.out.println("Ce véhicule n'est pas en vente");
            System.out.println("Elle ne respecter pas toute les conditions pour être mise en vente");
        }

        if(prixVente > 0.0) {
            System.out.println("Le prix de vente de ce véhicule est de " + prixVente + " euros");
        }

        System.out.println("---------- FIN TEST VENTE ----------");
    }

    private static void testExceptions() throws GestionAutomobileClientsException, GestionAutomobileVehiculesVenteException {
        //Ajout Client Particulier age -2
        clients.ajouterClient(new ClientParticulier("DOE", TypeClient.PARTICULIER, new GestionDates("01/05/2024"), "Jhon", -2, "2 Impasse de l'epi", 23));

        //Ajout Client qui existe déjà
        clients.ajouterClient(new ClientProfessionnel("NKEOUA", TypeClient.PROFESSIONNEL, new GestionDates("01/05/2024"), 23));

        //Ajout vehicule kilometrage maximum depassé
        vehicules.ajouterVehicule(new Berline(TypeVehicule.BERLINE, NombreDePortes.QUATRE, new Immatriculation("344 AC 4"), Constructeur.CITROEN, "4x4", 5000000000000.0, 150000, 120, "30/05/2024"));
    }
}
