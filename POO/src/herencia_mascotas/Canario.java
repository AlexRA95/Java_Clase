package herencia_mascotas;

import java.time.LocalDate;

public class Canario extends Aves{

    private String color;
    private boolean canta;

    public Canario(String nombre, Integer edad, LocalDate fechaNacimiento, String pico, String color, boolean canta) {
        super(nombre, edad, fechaNacimiento, pico);
        this.color = color;
        this.canta = canta;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + color + ", " + (canta?"Canta":"No canta") + ")";
    }

    @Override
    public String hablar() {
        return "lalalalalalalala";
    }
}
