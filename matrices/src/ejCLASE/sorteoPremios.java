package ejCLASE;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class sorteoPremios {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);
        Random ran = new Random();

        String[] inicio, premios;
        inicio = new String[1];
        premios = new String[1];

        String salida1 = "a", salida2 = "b", control;
        int random1, random2, opc;
        boolean salir = true;

        do {

            System.out.println("Añade personas al sorteo: ");
            control = key.nextLine();
            if (control.equals("SALIR")) {
                inicio = Arrays.copyOf(inicio, inicio.length - 1);
                salida1 = "SALIR";
                System.out.println("Has salido");

            } else {
                inicio[inicio.length - 1] = control;
                inicio = Arrays.copyOf(inicio, inicio.length + 1);

            }


        } while (!salida1.equals("SALIR"));

        do {

            System.out.println("Añade premios al sorteo: ");
            control = key.nextLine();
            if (control.equals("SALIR")) {
                premios = Arrays.copyOf(premios, premios.length - 1);
                salida2 = "SALIR";
                System.out.println("Has salido");

            } else {
                premios[premios.length - 1] = control;
                premios = Arrays.copyOf(premios, premios.length + 1);

            }


        } while (!salida2.equals("SALIR"));

        String salida3 = "a";
        String salida4 = "b";

        while (salir) {

            System.out.println("Pon [1] si quieres meter nuevas personas al sorteo");
            System.out.println("Pon [2] si quieres meter nuevos premios al sorteo");
            System.out.println("Pon [3] si quieres hacer el sorteo");
            System.out.println("Pon [4] si quieres ver las personas en el sorteo");
            System.out.println("Pon [5] si quieres ver los premios en el sorteo");
            System.out.println("Pon [0] para salir");
            opc = key.nextInt();

            if (opc == 1) {

                do {

                    System.out.println("Añade personas al sorteo: ");
                    control = key.nextLine();
                    if (control.equals("SALIR")) {
                        inicio = Arrays.copyOf(inicio, inicio.length - 1);
                        salida3 = "SALIR";
                        System.out.println("Has salido");

                    } else {
                        inicio[inicio.length - 1] = control;
                        inicio = Arrays.copyOf(inicio, inicio.length + 1);

                    }


                } while (!salida3.equals("SALIR"));

            } else if (opc == 2) {

                do {

                    System.out.println("Añade premios al sorteo: ");
                    control = key.nextLine();
                    if (control.equals("SALIR")) {
                        premios = Arrays.copyOf(premios, premios.length - 1);
                        salida4 = "SALIR";
                        System.out.println("Has salido");

                    } else {
                        premios[premios.length - 1] = control;
                        premios = Arrays.copyOf(premios, premios.length + 1);

                    }


                } while (!salida4.equals("SALIR"));

            } else if (opc == 3) {


                random1 = ran.nextInt(0, inicio.length );
                random2 = ran.nextInt(0, premios.length);

                System.out.printf("\nLa persona %s ha ganado el premio %s\n", inicio[random1], premios[random2]);

                inicio[random1] = inicio[inicio.length - 1];
                inicio = Arrays.copyOf(inicio, inicio.length - 1);

                premios[random2] = premios[premios.length - 1];
                premios = Arrays.copyOf(premios, premios.length - 1);




            } else if (opc==4) {

                System.out.println("Las personas que partcipan en el sorteo son: ");
                System.out.println(Arrays.toString(inicio));

            } else if (opc==5) {
                System.out.println("Los premios en el sorteo son: ");
                System.out.println(Arrays.toString(premios));

            } else if (opc == 0) {
                salir = false;
            } else {

                System.out.println("Valor incorrecto");

            }


        }


    }

}
