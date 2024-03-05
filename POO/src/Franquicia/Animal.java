package Franquicia;

import java.util.Objects;

public abstract class Animal {

    private int idAnimal;
    private static int idCont=0;
    private String nombre;
    private int edad;
    private int peso;

    public Animal(String nombre, int edad, int peso) {
        this.idAnimal = ++idCont;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public abstract void revision();

    public String getNombre() {
        return nombre;
    }

    public int getPeso() {
        return peso;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Animal--> " + getClass().getSimpleName() + "\n"+
                "ID--> " + getIdAnimal() + "\n"+
                "Nombre--> '" + getNombre() + '\n' +
                "Edad--> " + getEdad() + '\n' +
                "Peso --> " + getPeso() +'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return getIdAnimal() == animal.getIdAnimal();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAnimal());
    }
}
