import java.util.Scanner;

public class piramide {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int numuser;


        System.out.println("Introduce la base de la pirámide: ");
        numuser = keyboard.nextInt();



        for (int i = 1; i <= numuser; i++) {

            for (int espace=0; espace == (numuser*2); espace++){}




        }

    }
}