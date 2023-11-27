import java.util.Scanner;

public class trianguloinverso {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int numuser;


        System.out.println("Introduce un numero: ");
        numuser = keyboard.nextInt();



        for (int i = 1; i <= numuser; i++) {

            for ( int j = 1; j<= numuser; j++  ){

                if ( j == numuser || i <= j  ){
                    System.out.print(" * ");
                } else {

                    System.out.print("   ");

                }





            }
            System.out.println(" ");

        }


    }

}
