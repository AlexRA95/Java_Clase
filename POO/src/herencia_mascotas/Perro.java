package herencia_mascotas;

import java.time.LocalDate;

public class Perro extends Mascotas{
    private String raza;
    private boolean pulgas;

    public Perro(String nombre, Integer edad, LocalDate fechaNacimiento, String raza) {
        super(nombre, edad, fechaNacimiento);
        this.raza = raza;
        this.pulgas = false;
    }

    @Override
    public String toString() {
        return super.toString()+ ", " + raza + ", " + (pulgas?"Sin pulgas":"Con pulgas") + ")";
    }

    @Override
    public String hablar(){
        return "Guau";
    }
}
