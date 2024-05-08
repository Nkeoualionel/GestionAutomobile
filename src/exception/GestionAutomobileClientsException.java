package exception;

public class GestionAutomobileClientsException extends GestionAutomobileException {

    public GestionAutomobileClientsException(String message) {
        super(message);
    }

    public GestionAutomobileClientsException(String clientType, String nom) {
        super("Le client " + clientType + " ayant pour nom " + nom + " existe déjà dans la classe Clients");
    }
}
