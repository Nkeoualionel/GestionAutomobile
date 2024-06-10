package exception;

public class GestionAutomobileClientsException extends GestionAutomobileException {

    public GestionAutomobileClientsException(String message) {
        super(message);
    }
    public GestionAutomobileClientsException(String typeClient, String nomClient) {
        System.out.println("Le client " + typeClient + " ayant pour nom " + nomClient + " existe déjà dans la classe Clients");
    }
}
