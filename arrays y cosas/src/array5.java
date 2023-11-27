import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class array5 {

    /*Aqui sumamos todos lo valores del vector.*/

    public static void main(String[] args) {

        Random ran = new Random();


        Scanner keyboard = new Scanner(System.in);
        double [] num1;
        int userarray;
        double num2,num3=0;
        System.out.println("Introduce la longitud de tu vector:");

        userarray = keyboard.nextInt();
        num1 = new double[userarray];

        for (int i = 0; i < num1.length ; i++){
            System.out.println("Introduce un valor para el vector");

            num2 = keyboard.nextDouble();

            num1[i]=num2;

        }

        for (double i : num1) {

            num3 += i;


        }

        System.out.println(Arrays.toString(num1));
        System.out.println(num3);



    }

}
