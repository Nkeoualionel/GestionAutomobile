package exception;

public class GestionAutomobileVehiculesLocationException extends GestionAutomobileVehiculesException {

    public GestionAutomobileVehiculesLocationException() {
        super("Ce véhicule n’est pas disponible à la location");
    }
}
