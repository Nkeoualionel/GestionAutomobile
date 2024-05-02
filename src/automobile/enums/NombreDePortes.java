package automobile.enums;

public enum NombreDePortes {

    DEUX(2, "Epais et léger"),
    TROIS(3, "Polyvalente et compacte"),
    QUATRE(4, "Large et agreeable"),
    CINQ(5, "Familiale et efficace");

    private int nombre;
    private String description;

    NombreDePortes(int nombre, String description) {
        this.nombre = nombre;
        this.description = description;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NombreDePorte { " +
                    "nombre = " + nombre +
                    ", description = '" + description + '\'' +
                '}';
    }
}
