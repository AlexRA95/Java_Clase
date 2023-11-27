import java.util.Scanner;

public class ej1 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int mayor, menor, edad;
        mayor = 999;
        menor = 0;


        do {
            System.out.println("Pon un numero negativo para salir.");
            System.out.println("Introduce una edad:");
            edad = keyboard.nextInt();

            if (edad >= 199) {

                System.out.println("ERROR: EDAD INVALIDA");
                System.exit(0);

            }

            if (mayor == 999) {
                mayor = edad;
                menor = mayor;
            }

            if (edad <= menor) {

                menor = edad;

            } else if (edad >= mayor) {

                mayor = edad;

            }

            System.out.printf("\nLa edad del alumno mas pequeño es %d y la edad del más mayor es %d\n", menor, mayor);


        } while (edad >= 0);


        System.out.println("Has introducido un número negativo, HAS SALIDO DEL PROGRAMA.");


    }

}
