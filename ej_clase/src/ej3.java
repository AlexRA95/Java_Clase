import java.util.Scanner;

public class ej3 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce un numero:");
        int num1 = keyboard.nextInt();

        System.out.println("Introduce un numero:");
        int num2 = keyboard.nextInt();

        if ( num2 == 0){

            System.out.println("Tu segundo numero es 0, introduce otro numero");

        } else {

            int div = ((num1/num2));

            System.out.printf("El resultado de la división de %d / %d = %d",num1,num2,div);

        }

    }

}
