import java.util.Arrays;
import java.util.Scanner;

public class ej20 {
    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        int[] array;
        int numUser, cont=0;

        array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i]=(int) (Math.random()*100);
        }

        System.out.println(Arrays.toString(array));

        System.out.println("Introduce un número:");
        numUser = key.nextInt();


        for (int j: array
             ) {

            if ( j == numUser ){
                cont++;
            }

        }


        System.out.printf("Tu número %d ha aparecido un total de %d veces.",numUser,cont);
    }



}
