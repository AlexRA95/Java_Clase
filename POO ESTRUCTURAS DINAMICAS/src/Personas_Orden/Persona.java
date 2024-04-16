package Personas_Orden;

import java.util.Comparator;

public class Persona implements Comparable<Persona> {
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
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAltura() {
        return altura;
    }


    @Override
    public int compareTo(Persona o) {
        if (this.getEdad()>o.getEdad()){
            return 1;
        }else {
            return -1;
        }
    }
}
