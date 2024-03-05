package herencia_mascotas;

import java.time.LocalDate;

public class Aves extends Mascotas{
    private String pico;
    private boolean vuela;

    public Aves(String nombre, Integer edad, LocalDate fechaNacimiento, String pico) {
        super(nombre, edad, fechaNacimiento);
        this.pico = pico;
        this.vuela = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + pico + ", " + (vuela?"Vuela":"No vuela");
    }
}
