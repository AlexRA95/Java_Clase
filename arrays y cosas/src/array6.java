import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class array6 {

    public static void main(String[] args) {

        Random ran = new Random();
        Scanner keyboard = new Scanner(System.in);
        int [] num1;
        int num2,userarray = 0;
        System.out.println("Introduce la longitud de tu vector:");

        userarray = keyboard.nextInt();

        num1 = new int[userarray];


        for (int i = 0; i < num1.length ; i++){

            num2 = ran.nextInt(1,101);
            num1[i]=num2;

        }

        System.out.println(Arrays.toString(num1));


    }


}
