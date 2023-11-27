import java.util.Scanner;

public class circulo {


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Introduce el radio de un circulo:");
        int radio = keyboard.nextInt();

        int num = 0;
        double longitud = Math.PI * (radio + radio);
        double area = Math.PI * Math.pow(radio, 2.0);
        double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3.0);

        while (num != 1) {
            System.out.println("Pon 1 si quiere la longitud");
            System.out.println("Pon 2 si quiere el area");
            System.out.println("Pon 3 si quiere el volumen");
            System.out.println("Pon 0 si quiere el salir");
            System.out.println("Introduce lo que quieres hacer:");
            int opcion = keyboard.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.printf("La longitud de la circunferencia es = %f", longitud);
                    System.out.println();

                    System.out.println();
                }

                case 2 -> {
                    System.out.printf("El area de la circunferencia es = %f", area);
                    System.out.println();

                    System.out.println();
                }


                case 3 -> {
                    System.out.printf("El volumen de la circunferencia es = %f", volumen);
                    System.out.println();

                    System.out.println();
                }


                case 0 -> {
                    System.out.println("Has salido del programa");
                    num = 1;
                }


                default -> {
                    System.out.println("[[ ERROR ]]: El valor introducido es incorrecto, vuelve a intentarlo");
                    System.out.println();
                }


            }
        }


    }

}
