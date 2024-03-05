package Gimnasio;

import java.time.LocalDate;
import java.util.Objects;

public class Incidencia {

    private String descripcion;
    private LocalDate fecha;

    public Incidencia(String descripcion) {
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Incidencia-->" +
                "Fecha:" + fecha + "\n" +
                "Descripcion: " + descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Incidencia that)) return false;
        return Objects.equals(descripcion, that.descripcion) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, fecha);
    }
}
