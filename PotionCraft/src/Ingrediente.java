import java.io.Serializable;
import java.util.Objects;

public class Ingrediente implements Serializable {
    protected int id;
    protected String nombre;
    protected String descripcion;
    protected double precio;

    public Ingrediente(int id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Ingrediente(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "----> " + getClass().getSimpleName().toUpperCase() + ", " + nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingrediente that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }
}
