import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ej8 {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        double[] num1;

        double ran,num2;

        num1 = new double[100];

        for (int i = 0; i < num1.length; i++) {
            ran = Math.random();
            num1[i]=ran;

        }
        Arrays.sort(num1);
        System.out.println(Arrays.toString(num1));


        System.out.println("introduce un numero real entre 0,0 y 1,0: ");
        num2 = key.nextDouble();

        for (double a: num1) {

            if ( num2 == a ){

                System.out.printf("El numero %f es igual a tu numero %f",a,num2);

            } else if ( num2 < a ) {
                System.out.printf("\nEl numero %f es mayor que tu numero %f\n",a,num2);
            }

        }


    }

}
