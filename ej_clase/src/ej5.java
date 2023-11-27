import java.util.Scanner;

public class ej5 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce un numero:");
        double num1 = keyboard.nextInt();

        System.out.println("Introduce otro numero:");
        double num2 = keyboard.nextInt();

        double pot = Math.pow(num1, num2);





        if ( num2 > 0 ){

            System.out.printf("%f elevado a %f es igual a %f",num1,num2,pot);
            System.exit(0);

        } else if (num2 == 0) {
            pot = 1;

            System.out.printf("%f elevado a %f es igual a %f",num1,num2, pot);
        } else if (num2 < 0 ) {

            pot = ((1/(num1*num2))*-1) ;

            System.out.printf("%f elevado a %f es igual a %f",num1,num2,pot);

        }

        /*
        if ( num2 == 0 ){

            pot = 1;

            System.out.printf("%f elevado a %f es igual a %f",num1,num2, pot);
            System.exit(0);

        }


        if ( num2 < 0 ){

            pot = ((1/(num1*num2))*-1) ;

            System.out.printf("%f elevado a %f es igual a %f",num1,num2,pot);
            System.exit(0);

        }
            */


    }

}
