import java.util.Scanner;


public class ej9 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce un año:");
        int year = keyboard.nextInt();

        int bisi = ( year % 4 );

        if ( bisi == 0 ){

            System.out.printf("El año %d es bisiesto",year);

        } else {

            System.out.printf("El año %d no es bisiesto",year);

        }

    }

}
