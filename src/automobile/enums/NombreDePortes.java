package automobile.enums;

public enum NombreDePortes {

    DEUX(2, "Compacte et agile"),
    TROIS(3, "Polyvalente et compacte"),
    QUATRE(4, "Spacieuse et confortable"),
    CINQ(5, "Familiale et pratique");

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
}
