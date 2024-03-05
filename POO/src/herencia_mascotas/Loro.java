package herencia_mascotas;

import java.time.LocalDate;

public class Loro extends Aves{

    private String origen;
    private boolean habla;

    public Loro(String nombre, Integer edad, LocalDate fechaNacimiento, String pico, String origen) {
        super(nombre, edad, fechaNacimiento, pico);
        this.origen = origen;
        this.habla = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + origen + ", " + (habla?"Habla":"No habla") + ")";
    }

    @Override
    public String hablar() {
        return "hola";
    }

}
