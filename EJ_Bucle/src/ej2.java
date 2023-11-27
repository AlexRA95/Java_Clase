import java.util.Scanner;

public class ej2 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int num, cont, paridad;
        int cuadrado;
        cont = 1;

        while (cont > 0) {

            System.out.println("Introduce un número:");
            num = keyboard.nextInt();

            if (num == 0) {

                cont = 0;

            }

            paridad = num % 2;

            if (paridad == 0) {

                System.out.printf("\n%d es un número par", num);
            } else {

                System.out.printf("\n%d es un número impar", num);

            }

            if (num < 0) {

                System.out.printf("\n%d es un número negativo", num);

            } else {

                System.out.printf("\n%d es un número positivo", num);
            }

            cuadrado = (int) Math.pow(num, 2.0);

            System.out.printf("\nEl cuadrado de %d es %d\n", num, cuadrado);

        }




    }

}
