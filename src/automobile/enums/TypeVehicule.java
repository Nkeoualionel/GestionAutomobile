package automobile.enums;

public enum TypeVehicule {
    BERLINE("Berline", 50.0, "Confortable pour les déplacements en ville"),
    BREAK("Break", 60.0, "Spacieux pour les voyages en famille"),
    UTILITAIRE("Utilitaire", 70.0, "Pratique pour le transport de marchandises");

    private String type;
    private double prixJour;
    private String description;

    TypeVehicule(String type, double prixJour, String description) {
        this.type = type;
        this.prixJour = prixJour;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(double prixJour) {
        this.prixJour = prixJour;
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
                    ", prixJour = " + prixJour +
                    ", description = '" + description + '\'' +
                '}';
    }
}
