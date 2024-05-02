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

    public boolean estIdentique(String imma) {
        return this.identification.equals(imma);
    }

    @Override
    public String toString() {
        return "Immatriculation { " +
                    "identification='" + identification + '\'' +
                '}';
    }
}
