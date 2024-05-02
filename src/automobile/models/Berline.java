package automobile.models;

import automobile.enums.Constructeur;
import automobile.enums.NombreDePortes;
import automobile.enums.TypeVehicule;

public class Berline extends Voiture {

    public Berline(TypeVehicule typeVehicule, NombreDePortes nombreDePortes, Immatriculation immatriculation, Constructeur constructeur, String modele, double kilometrage, double prixAchat) {
        super(typeVehicule, nombreDePortes, immatriculation, constructeur, modele, kilometrage, prixAchat);
    }

}
