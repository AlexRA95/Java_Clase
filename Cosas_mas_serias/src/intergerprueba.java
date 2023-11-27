import java.util.Scanner;

public class intergerprueba {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int numero;

        System.out.println("Hola, introduce un número entero: ");
        numero  = Integer.parseInt(keyboard.nextLine());

        System.out.printf("\n\n El numero introducido es %d ", numero);
        numero  = Integer.parseInt(keyboard.nextLine());
        System.out.printf("\n\n El numero introducido es %d ", numero);

    }

}
