package quitar_anadir_buscar_complejo;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Trabajador {
    private String nombre;
    private int id;
    private static int idCont=0;
    private LocalDate fechaNacimiento;

    public Trabajador(String nombre,LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.id = ++idCont;
        this.fechaNacimiento = fechaNacimiento;
    }

    public abstract void imprimir();

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
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
