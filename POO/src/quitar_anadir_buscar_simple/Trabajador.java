package quitar_anadir_buscar_simple;

import java.util.Objects;

public class Trabajador {
    private int id;
    private String nombre;
    private static int idCont=0;

    public Trabajador(String nombre) {
        this.id = ++idCont;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trabajador that)) return false;
        return Objects.equals(getNombre(), that.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre());
    }
}
