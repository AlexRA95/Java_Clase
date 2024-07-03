import java.io.Serializable;

public class Hierba extends Ingrediente implements Serializable {
    private String efectoPositivo;

    public Hierba(int id, String nombre, String descripcion, double precio, String efectoPositivo) {
        super(id, nombre, descripcion, precio);
        this.efectoPositivo = efectoPositivo;
    }

    public Hierba(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return super.toString() + ", efecto positivo: " + efectoPositivo + ". Precio: " + precio + "\n"
                + "Descripción: " + "\n" + descripcion;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getEfectoPositivo() {
        return efectoPositivo;
    }
}
