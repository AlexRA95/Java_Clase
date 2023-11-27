import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class arraybiblioteca {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner key = new Scanner(System.in);

        int[] mesa;
        mesa = new int[10];
        int numRan,contMesa=1;


        for (int i = 0; i < mesa.length ; i++) {
            numRan =ran.nextInt(0,7);
            mesa[i] = numRan;
        }

        for (int j: mesa
             ) {
            System.out.printf("\nEn la mesa %d hay %d personas\n",contMesa,j);
            contMesa++;
        }


        System.out.println("¿Cuantos sois?:");


    }
}
