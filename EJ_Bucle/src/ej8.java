import java.util.Scanner;

public class ej8 {

    public static void main(String[] args) {

        int num1;


        Scanner keyboard = new Scanner(System.in);
        System.out.println("Pon un numero:");
        num1 = keyboard.nextInt();

        if (num1 < 0) {

            for (int i = 1; i >= num1; i--) {

                System.out.print(i + " ");

            }

        } else {

            for (int i = 1; i <= num1; i++) {

                System.out.print(i + " ");

            }


        }


    }

}
