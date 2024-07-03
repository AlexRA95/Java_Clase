import java.io.Serializable;

public class Seta extends Ingrediente implements Serializable {
    private String efectoNegativo;
    private int nivelToxicidad;

    public Seta(int id, String nombre, String descripcion, double precio, String efectoNegativo, int nivelToxicidad) {
        super(id, nombre, descripcion, precio);
        this.efectoNegativo = efectoNegativo;
        this.nivelToxicidad = nivelToxicidad;
    }

    @Override
    public String toString() {
        return super.toString() + ", efecto negativo: " + efectoNegativo + " ,nivel de toxicidad: " + nivelToxicidad + ". Precio: " + precio + "\n"
                + "Descripción: " + "\n" + descripcion;
    }

    public String getEfectoNegativo() {
        return efectoNegativo;
    }

    public int getNivelToxicidad() {
        return nivelToxicidad;
    }
}
