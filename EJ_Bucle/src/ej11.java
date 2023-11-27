import java.util.Scanner;
public class ej11 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int num = 0,multi;

        System.out.println("Pon un numero:");
        try {
            num = keyboard.nextInt();
        }catch (Exception e){

            System.out.println("Datos no validos");
            System.exit(0);
        }


        if ( num <= 0 ||  num >= 10 ){

            System.out.println("ERROR: número no reconocido.");
            keyboard.nextLine();

        }

        System.out.printf("\nLa tabla de multiplicar de %d\n",num);

        for ( int i = 0; i <= 10; i++ ){

            multi = ((num*i)) ;

            System.out.printf("\nEl resultado de %d * %d es %d \n",num,i,multi);

        }

    }

}
