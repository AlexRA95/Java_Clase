package EjA2;

public class Persona {
    public int dni;
    public String nombre;
    public String apellido;
    public int edad;

    public Persona(String nombre, String apellido, int edad){
        this.dni=999;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }

    public Persona(int dni, String nombre, String apellido, int edad){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }
}
