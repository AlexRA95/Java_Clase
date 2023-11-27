import java.util.Scanner;

public class ej4 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce una letra:");
        String text1 = keyboard.next();



        if (text1.length() == 1){
            System.out.println("Has puesto una letra");

        }else {
            System.out.println("Has puesto más de una letra");
            System.exit(0);

        }

        if (text1.toUpperCase().equals(text1)) {
            System.out.println("Es mayuscula");
        } else {

            System.out.println("Es minuscula");

        }


        /*
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce una letra:");
        char text1 = keyboard.next().charAt(0);



        if (Character.isUpperCase(text1)){
            System.out.println("Has puesto una letra mayuscula");
        } else {

            System.out.println("Has puesto una letra minuscula");

        }
         */

    }

}
