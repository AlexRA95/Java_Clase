import java.util.Scanner;

public class ej12 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce los minutos que ha durado la llamada:");
        int minutos = keyboard.nextInt();



        System.out.println("Si es domingo, ponga 1");
        System.out.println("Si es cualquier otro día, ponga 2");
        System.out.println("Introduce que día de la semana has llamado:");
        int dia = keyboard.nextInt();

        if ( dia != 1 && dia != 2 ){

            System.out.println("ERROR; Ha puesto un dato erroneo.");
            System.exit(0);

        }

        double imp;
        double precio;
        double preciototal;

        switch (dia) {
            case 1:

                /*Domingo*/

                if ( minutos <= 5 ){

                    precio = 1;
                    imp = (( precio * 0.10 ));
                    preciototal = (( precio +imp ));

                    System.out.printf( "Tu llamada ha sido de %d minutos, al ser domingo se te cobra un 10 porciento extra en impuestos,por lo tanto ,el precio por tu llamada es = %f",minutos ,preciototal );

                }






                break;
            case 2:


                break;

        }

    }

}
