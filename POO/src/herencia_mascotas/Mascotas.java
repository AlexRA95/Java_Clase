package herencia_mascotas;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Mascotas {

    private String nombre;
    private Integer edad;
    private Boolean estado;
    private LocalDate fechaNacimiento;

    public Mascotas(String nombre, Integer edad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = true;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + nombre + ", " + edad +", " + (estado?"Vivo":"Muerto") + ", " + fechaNacimiento + ", " + hablar();
    }

    public String hablar(){
        return "\n El animal habla.";
    }

    public void morir(){
        estado=false;
    }

}
