import java.io.Serializable;

public class Mineral extends  Ingrediente implements Serializable {
    private double nivelDeDureza;

    public Mineral(int id, String nombre, String descripcion, double precio, double nivelDeDureza) {
        super(id, nombre, descripcion, precio);
        this.nivelDeDureza = nivelDeDureza;
    }


    @Override
    public String toString() {
        return super.toString() + ", nivel de dureza: " + nivelDeDureza + ". Precio: " + precio + "\n"
                + "Descripción: " + "\n" + descripcion;
    }

    public double getNivelDeDureza() {
        return nivelDeDureza;
    }
}
