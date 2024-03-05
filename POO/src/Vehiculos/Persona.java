package Vehiculos;

import java.util.Objects;

public class Persona {
    private String dni;
    private String nombre;
    private TipoConductor tipoConductor;

    public Persona(String dni) {
        this.dni = dni;
    }

    public Persona(String dni, String nombre, TipoConductor tipoConductor) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoConductor = tipoConductor;
    }

    @Override
    public String toString() {
        return "\nPersona--> \n" + "Nombre: " + getNombre() + " DNI: " + getDni() + " Tipo Conductor: " + getTipoConductor();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public TipoConductor getTipoConductor() {
        return tipoConductor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(getDni(), persona.getDni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni());
    }
}
