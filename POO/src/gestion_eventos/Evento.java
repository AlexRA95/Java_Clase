package gestion_eventos;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Evento {

    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private int duracion;
    public Evento(String nombre, LocalDate fecha, LocalTime hora, int duracion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }
    public Evento(LocalDate fecha) {
        this.nombre = "nombre";
        this.fecha = fecha;
        this.hora = LocalTime.now();
        this.duracion = 0;
    }
    public Evento(String nombre) {
        this.nombre = nombre;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.duracion = 0;
    }


    @Override
    public String toString() {
        return "NOMBRE: " + this.nombre +
                "\nFECHA: " + this.fecha +
                "\nHORA: " + this.hora +
                "\nDURACIÓN: " + this.duracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento evento)) return false;
        return Objects.equals(fecha, evento.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }


}
