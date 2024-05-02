package automobile.models;

import automobile.enums.Constructeur;
import automobile.enums.NombreDePortes;
import automobile.enums.TypeVehicule;

public class Voiture {
    private TypeVehicule typeVehicule;
    private NombreDePortes nombreDePortes;
    private Immatriculation immatriculation;
    private Constructeur constructeur;
    private String modele;
    private double kilometrage;
    private double prixAchat;

    public Voiture(TypeVehicule typeVehicule, NombreDePortes nombreDePortes, Immatriculation immatriculation, Constructeur constructeur, String modele, double kilometrage, double prixAchat) {
        this.typeVehicule = typeVehicule;
        this.nombreDePortes = nombreDePortes;
        this.immatriculation = immatriculation;
        this.constructeur = constructeur;
        this.modele = modele;
        this.kilometrage = kilometrage;
        this.prixAchat = prixAchat;
    }


    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public NombreDePortes getNombreDePortes() {
        return nombreDePortes;
    }

    public void setNombreDePortes(NombreDePortes nombreDePortes) {
        this.nombreDePortes = nombreDePortes;
    }

    public Immatriculation getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(Immatriculation immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Constructeur getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(Constructeur constructeur) {
        this.constructeur = constructeur;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    @Override
    public String toString() {
        return "Voiture { " +
                    "typeVehicule = " + typeVehicule +
                    ", nombreDePortes = " + nombreDePortes +
                    ", immatriculation = " + immatriculation +
                    ", constructeur = " + constructeur +
                    ", modele = '" + modele + '\'' +
                    ", kilometrage = " + kilometrage +
                    ", prixAchat = " + prixAchat +
                '}';
    }
}
