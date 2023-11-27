import java.util.Scanner;


public class ejClase {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce tu nota:");
        double nota = keyboard.nextDouble();

        if (nota < 0.0) {

            System.out.println("Has introducido una nota incorrecta");

        } else if ( nota <= 2.0 ){

            System.out.printf("Tu nota es %f por lo tanto tienes un muy deficiente",nota);

        } else if ( nota < 5.0 ) {

            System.out.printf("Tu nota es %f, por lo tanto tienes un insufiente",nota);

        } else if ( nota < 6.0 ) {

            System.out.printf("Tu nota es %f, por lo tanto tienes un suficiente",nota);

        } else if ( nota < 7.0 ) {

            System.out.printf("Tu nota es %f, por lo tanto tienes un bien",nota);

        } else if ( nota <= 8.0 ) {

            System.out.printf("Tu nota es %f, por lo tanto tienes un notable",nota);

        }  else if ( nota < 10.0 ) {

            System.out.printf("Tu nota es %f, por lo tanto tienes un sobresaliente",nota);

        } else if ( nota == 10.0 ) {

            System.out.printf("Tu nota es %f, por lo tanto tienes una matricula de honor",nota);

        }

    }

}
