import java.util.Scanner;

public class los_if {



    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce tu edad:");
        int edad = keyboard.nextInt();

        if ( edad >= 27 ){

            System.out.println("Tienes 27 años o más, por lo tanto tienes que pagar 1€");

        } else if ( edad >= 25) {

            System.out.println("Tienes más de 25 años, por lo tanto  tienes que pagar 2€");

        } else if ( edad >= 18) {
            System.out.println("Tienes menos de 25 años, por lo tanto  tienes que pagar 2€");
        }


    }


}
