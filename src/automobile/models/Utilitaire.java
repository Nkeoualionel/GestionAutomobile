package automobile.models;

import automobile.enums.Constructeur;
import automobile.enums.NombreDePortes;
import automobile.enums.TypeVehicule;

public class Utilitaire extends Vehicule {

    public Utilitaire(TypeVehicule typeVehicule, NombreDePortes nombreDePortes, Immatriculation immatriculation, Constructeur constructeur, String modele, double kilometrage, double prixAchat, double kilometrageFin, String dateFin) {
        super(typeVehicule, nombreDePortes, immatriculation, constructeur, modele, kilometrage, prixAchat, kilometrageFin, dateFin);
    }
}
