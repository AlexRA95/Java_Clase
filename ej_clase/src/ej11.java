import java.util.Scanner;

public class ej11 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce el número de alumnos:");
        int alumnos = keyboard.nextInt();

        int bus;
        double precio;
        int preciocabeza;
        int preciototal;

        if ( alumnos < 30 ){
            bus = 4000;
            precio = (((double) bus /alumnos));

            System.out.printf("Al ser %d alumnos, el precio del bus es %d, por lo tanto cada alumno debe pagar %f",alumnos,bus,precio);


        } else if ( alumnos <= 49) {

            preciocabeza = 95;
            preciototal = (( preciocabeza * alumnos ));

            System.out.printf("Al ser %d alumnos, el precio del bus es %d, por lo tanto cada alumno debe pagar %d",alumnos,preciototal,preciocabeza);


        } else if (alumnos <= 99) {

            preciocabeza = 70;
            preciototal = (( preciocabeza * alumnos ));

            System.out.printf("Al ser %d alumnos, el precio del bus es %d, por lo tanto cada alumno debe pagar %d",alumnos,preciototal,preciocabeza);

        } else {

            preciocabeza = 65;
            preciototal = (( preciocabeza * alumnos ));

            System.out.printf("Al ser %d alumnos, el precio del bus es %d, por lo tanto cada alumno debe pagar %d",alumnos,preciototal,preciocabeza);

        }

    }


}
