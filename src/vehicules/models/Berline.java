package vehicules.models;

import vehicules.enums.Constructeur;
import vehicules.enums.NombreDePortes;
import vehicules.enums.TypeVehicule;

public class Berline extends Vehicule {


    public Berline(TypeVehicule typeVehicule, NombreDePortes nombreDePortes, Immatriculation immatriculation, Constructeur constructeur, String modele, double kilometrage, double prixAchat, double kilometrageFin, String dateFin) {
        super(typeVehicule, nombreDePortes, immatriculation, constructeur, modele, kilometrage, prixAchat, kilometrageFin, dateFin);
    }
}
