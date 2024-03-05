package alquiler_de_juegos;

public class Persona {

    private final int DNI;
    private String nombre;
    private String email;

    public Persona(int DNI, String nombre, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.email = email;
    }
}
