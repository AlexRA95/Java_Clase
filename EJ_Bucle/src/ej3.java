import java.util.Scanner;


public class ej3 {

    /*Implementar una aplicación para calcular datos estadísticos de las edades de los
alumnos de un centro educativo. Se introducirán datos hasta que uno de ellos sea
negativo, y se mostrará:
 la suma de todas las edades introducidas
 la media
 el número de alumnos
 cuántos son mayores de edad.*/

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int edad, total, cont, mayor, media;
        total = 0;
        cont = 0;
        mayor = 0;


        do {


            System.out.println("Introduce una edad");
            edad = keyboard.nextInt();


            total = total + edad;
            cont++;

            if (edad >= 18) {

                mayor++;
            }

        } while (edad >= 0);


        media = (cont / 2);
        System.out.printf("\nLa edad total es %d\n", total);
        System.out.printf("\nLa edad media es %d\n", media);
        System.out.printf("\nEl número total de alumnos es %d\n", cont);
        System.out.printf("\nEl número de alumnos mayores de edad es %d\n", mayor);


        keyboard.close();

    }


}
