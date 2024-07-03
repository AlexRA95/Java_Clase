package Archivos_Binarios;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private double altura;
    private Maleta maleta;


    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        maleta=new Maleta(12,"Maleta de "+ this.nombre);
    }

    public void addMaleta(Maleta m ){
        this.maleta=m;
    }

    @Override
    public String toString() {
        return "[Nombre: " + nombre + " Edad: " + edad + " Altura: " + altura + "]";
    }

    public String toCSV() {
        return this.nombre+";"+this.edad+";"+this.altura + "\n";
    }
}
