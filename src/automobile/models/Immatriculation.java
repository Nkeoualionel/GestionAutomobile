package automobile.models;

public class Immatriculation {
    private String identification;

    public Immatriculation(String identification) {
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public boolean estIdentique(Immatriculation immatriculation) {
        return this.identification.equals(immatriculation.identification);
    }

    @Override
    public String toString() {
        return "Immatriculation { " +
                    "identification='" + identification + '\'' +
                '}';
    }
}
