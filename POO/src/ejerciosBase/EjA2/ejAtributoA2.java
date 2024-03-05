package ejerciosBase.EjA2;

import java.util.Scanner;

public class ejAtributoA2 {

    public static void main(String[] args) {


        Scanner key = new Scanner(System.in);
        String nombre, apellido, dni;
        Integer  edad;

        System.out.println("Introduce el nombre de la persona 1: ");
        nombre = key.nextLine();
        System.out.println("Introduce el apellido de la persona 1: ");
        apellido = key.nextLine();
        System.out.println("Introduce el DNI de la persona 1: ");
        dni = key.nextLine();
        System.out.println("Introduce la edad de la persona 1: ");
        edad = key.nextInt();
        Persona per1 = new Persona(dni, nombre, apellido, edad);

        key.nextLine();

        System.out.println("Introduce el nombre de la persona 2: ");
        nombre = key.nextLine();
        System.out.println("Introduce el apellido de la persona 2: ");
        apellido = key.nextLine();
        System.out.println("Introduce el DNI de la persona 2: ");
        dni = key.nextLine();
        System.out.println("Introduce la edad de la persona 2: ");
        edad = key.nextInt();

        Persona per2 = new Persona(dni, nombre, apellido, edad);

        if (per1.esMayorEdad()) {
            System.out.printf("\n %s %s con DNI %s es mayor de edad", per1.getNombre(), per1.getApellido(), per1.getDni());
            if (per1.esJubilado()) {
                System.out.println("Esta persona está jubilada");
            } else {
                System.out.println("Esta persona no está jubilada");
            }
        } else {
            System.out.printf("\n %s %s con DNI %s no es mayor de edad", per1.getNombre(), per1.getApellido(), per1.getDni());
        }

        if (per2.esMayorEdad()) {
            System.out.printf("\n %s %s con DNI %s es mayor de edad\n", per2.getNombre(), per2.getApellido(), per2.getDni());
            if (per1.esJubilado()) {
                System.out.println("Esta persona está jubilada");
            } else {
                System.out.println("Esta persona no está jubilada");
            }
        } else {
            System.out.printf("\n %s %s con DNI %s no es mayor de edad\n", per2.getNombre(), per2.getApellido(), per2.getDni());
        }

        System.out.printf("\nLa diferencia de edad entre Per1 y Per2 es %d\n", per1.diferenciaEdad(per2.getEdad()));

    }

}
