package automobile.enums;

public enum TypeVehicule {
    BERLINE("Berline", 0.28, "Confortable pour les déplacements en ville"),
    BREAK("Break", 0.18, "Spacieux pour les voyages en famille"),
    UTILITAIRE("Utilitaire", 0.15, "Pratique pour le transport de marchandises");

    private String type;
    private double prixLocationParKm;
    private String description;

    TypeVehicule(String type, double prixLocationParKm, String description) {
        this.type = type;
        this.prixLocationParKm = prixLocationParKm;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrixLocationParKm() {
        return prixLocationParKm;
    }

    public void setPrixLocationParKm(double prixJour) {
        this.prixLocationParKm = prixJour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TypeVehicule { " +
                    " type = '" + type + '\'' +
                    ", prixLocationParKm = " + prixLocationParKm +
                    ", description = '" + description + '\'' +
                '}';
    }
}
