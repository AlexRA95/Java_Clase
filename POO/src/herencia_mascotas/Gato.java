package herencia_mascotas;

import java.time.LocalDate;

public class Gato extends Mascotas{

    private String color;
    private boolean peloLargo;

    public Gato(String nombre, Integer edad, LocalDate fechaNacimiento, String color, boolean peloLargo) {
        super(nombre, edad, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + color + ", " + (peloLargo?"Pelo largo":"Pelo corto") + ")";
    }

    @Override
    public String hablar() {
        return "miau";
    }
}
