package ejerciciosMOODLE;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class matriz3 {

    public static void main(String[] args) {

        Scanner key= new Scanner(System.in);

        int[][] matriz;

        int filas,columnas;

        System.out.println("Introduce el numero de filas:");
        filas = key.nextInt();

        System.out.println("Introduce el numero de columnas:");
        columnas = key.nextInt();

        matriz =new int[filas][columnas];

        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[columnas].length ; j++) {
                System.out.println("Introduce un valor:");
                matriz[i][j]= key.nextInt();
            }

        }

        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j <matriz[columnas].length ; j++) {

                if ( matriz[i][j] < 0 ){
                    System.out.printf("\nEl número %d es menor que 0\n",matriz[i][j]);
                } else if ( matriz[i][j] == 0 ) {
                    System.out.printf("\nEl número %d es igual que 0\n",matriz[i][j]);
                } else {
                    System.out.printf("\nEl número %d es mayor que 0\n",matriz[i][j]);
                }

            }
        }

        System.out.println(Arrays.deepToString(matriz));

    }

}
