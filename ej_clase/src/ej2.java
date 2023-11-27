import java.util.Scanner;

public class ej2 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce un numero:");
        int num1 = keyboard.nextInt();

        int resto = ((num1%2));


        if (resto == 0){

            System.out.println("Es par");

        }else {

            System.out.println("Es impar");

        }

    }

}
