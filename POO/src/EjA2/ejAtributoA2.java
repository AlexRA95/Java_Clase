package EjA2;

import java.util.Scanner;

public class ejAtributoA2 {

    public static void main(String[] args) {


        Scanner key =new Scanner(System.in);
        String nombre, apellido;
        Integer dni, edad;

        System.out.println("Introduce el nombre de la persona 1: ");
        nombre=key.nextLine();
        System.out.println("Introduce el apellido de la persona 1: ");
        apellido=key.nextLine();
        System.out.println("Introduce el DNI de la persona 1: ");
            dni=key.nextInt();
        System.out.println("Introduce la edad de la persona 1: ");
        edad=key.nextInt();
        Persona per1=new Persona(dni,nombre,apellido,edad);

        key.nextLine();

        System.out.println("Introduce el nombre de la persona 2: ");
        nombre=key.nextLine();
        System.out.println("Introduce el apellido de la persona 2: ");
        apellido=key.nextLine();
        System.out.println("Introduce el DNI de la persona 2: ");
        dni=key.nextInt();
        System.out.println("Introduce la edad de la persona 2: ");
        edad=key.nextInt();

        Persona per2=new Persona(dni,nombre,apellido,edad);

        if (per1.edad>18){
            System.out.printf("\n %s %s con DNI %d es mayor de edad",per1.nombre, per1.apellido, per1.dni);
        } else {
            System.out.printf("\n %s %s con DNI %d no es mayor de edad",per1.nombre, per1.apellido, per1.dni);
        }

        if (per2.edad>18){
            System.out.printf("\n %s %s con DNI %d es mayor de edad",per2.nombre, per2.apellido, per2.dni);
        } else {
            System.out.printf("\n %s %s con DNI %d no es mayor de edad",per2.nombre, per2.apellido, per2.dni);
        }

    }

}
