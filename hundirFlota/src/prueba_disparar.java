import java.util.Arrays;
import java.util.Scanner;

public class prueba_disparar {

    static void vaciarTablero(Character[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    static void mostrarTablero(Character[][] tablero) {
        Character m = 65;
        for (int i = 0; i < tablero.length; i++) {
            if (i == 0) {
                System.out.print(" ");
                for (int k = 1; k < tablero[i].length + 1; k++) {
                    System.out.print(" " + k + " ");
                }
                System.out.println(" ");
            }
            for (int j = 0; j < tablero[i].length; j++) {
                if (j == 0) {

                    System.out.print("" + m + "");
                    m++;
                }
                System.out.print(" " + tablero[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static Integer letraNumero(String fila) {
        Integer resultado;

        switch (fila) {
            case "A" -> resultado = 1;
            case "B" -> resultado = 2;
            case "C" -> resultado = 3;
            case "D" -> resultado = 4;
            case "E" -> resultado = 5;
            case "F" -> resultado = 6;
            case "G" -> resultado = 7;
            case "H" -> resultado = 8;
            case "I" -> resultado = 9;
            case "J" -> resultado = 10;
            default -> resultado = -1;
        }
        return resultado;
    }

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);
        Character[][] matriz;
        Integer bb = 1;
        String aa = " ";
        matriz = new Character[10][10];
        Boolean in = true;

        vaciarTablero(matriz);


        while (in) {


            System.out.println("Una fila: ");
            aa = key.nextLine();


            System.out.println("Una columna: ");
            bb = key.nextInt();

            key.nextLine();

            if (letraNumero(aa) <= 0 || bb <= 0) {
                in = false;
            } else if (letraNumero(aa) > matriz.length) {
                System.out.println("ERROR, la fila es incorrecta.");
            } else if (bb > matriz.length) {
                System.out.println("ERROR, la columna es incorrecta.");
            } else {
                matriz[letraNumero(aa) - 1][bb - 1] = 'X';
                mostrarTablero(matriz);
            }


        }


    }

}
