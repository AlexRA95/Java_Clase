import java.time.LocalDate;
import java.util.Objects;

public class Tarea {

    private static int contID=0;
    private int id;
    private String nombre;
    private Tipo tipo;
    private LocalDate fecha_vencimiento, fecha_asignacion, fecha_fin;
    private Usuario userAsignado;

    public Tarea(String nombre, Tipo tipo, LocalDate fecha_vencimiento) {
        this.id=++contID;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public void addUser(Usuario user){
        this.userAsignado=user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarea tarea)) return false;
        return Objects.equals(nombre, tarea.nombre) && tipo == tarea.tipo && Objects.equals(fecha_vencimiento, tarea.fecha_vencimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipo, fecha_vencimiento);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setFecha_asignacion(LocalDate fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha_asignacion() {
        return fecha_asignacion;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public Usuario getUserAsignado() {
        return userAsignado;
    }
}
