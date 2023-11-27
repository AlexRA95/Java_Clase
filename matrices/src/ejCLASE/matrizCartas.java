package ejCLASE;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class matrizCartas {

    public static void main(String[] args) {


        Random ran = new Random();
        Scanner key =new Scanner(System.in);


        boolean[][] cartas,fin;
        cartas = new boolean[4][13];
        fin= new boolean[4][13];
        boolean salida=false;
        int num;




        for (int i = 0; i < cartas.length ; i++) {
            Arrays.fill(cartas[i], false);

        }

        for (int i = 0; i < fin.length ; i++) {
            Arrays.fill(fin[i], true);

        }

        while (!salida){





            int num1 = ran.nextInt(0, 4);
            int num2 = ran.nextInt(0, 13);

            if ( !cartas[num1][num2] ){

                System.out.println("¿Quieres sacar una carta?(-1 para salir, cualquier numero para seguir)");
                num = key.nextInt();

                if (num == -1){

                    salida=true;
                }

                String carta;
                String palo = switch (num1) {
                    case 0 -> "treboles";
                    case 1 -> "picas";
                    case 2 -> "diamantes";
                    case 3 -> "corazones";
                    default -> null;
                };

                carta = switch (num2) {
                    case 0 -> "AS";
                    case 10 -> "J";
                    case 11 -> "Q";
                    case 12 -> "K";

                    default -> String.valueOf(num2+1);
                };

                System.out.printf("\n%S de %S\n",carta,palo);
            }



            cartas[num1][num2]=true;

            if (Arrays.deepEquals(cartas,fin)){salida=true;}

        }

        System.out.println("Se ha terminado la baraja.");

    }

}
