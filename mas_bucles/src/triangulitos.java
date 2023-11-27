import java.util.Scanner;

public class triangulitos {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int numuser;


        System.out.println("Introduce un numero: ");
        numuser = keyboard.nextInt();


        for (int i = 1; i <= numuser; i++) {

            for ( int a = 1; a <= i; a++ ) {
                System.out.print(" * ");

            }
            System.out.println(" ");
        }


    }

}




