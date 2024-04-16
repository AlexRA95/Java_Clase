package Leer_Escribir_Ficheros;

public class Persona {
    private String nombre;
    private int edad;
    private double altura;

    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "[Nombre: " + nombre + " Edad: " + edad + " Altura: " + altura + "]";
    }

    public String toCSV() {
        return this.nombre+";"+this.edad+";"+this.altura + "\n";
    }
}
