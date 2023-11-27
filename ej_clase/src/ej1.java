import java.util.Scanner;

public class ej1 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce un numero:");
        int num1 = keyboard.nextInt();


        System.out.println("Introduce otro numero:");
        int num2 = keyboard.nextInt();

        if ( num1 > num2 ){

            System.out.printf("%d es mayor que %d",num1,num2);

        } else if (num1 < num2) {

            System.out.printf("%d es menor que %d",num1,num2);

        } else if (num1 == num2) {

            System.out.printf("%d es igual que %d",num1,num2);

        }


    }

}
