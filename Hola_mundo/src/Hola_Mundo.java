

public class Hola_Mundo {

    public static int JIRAFAS = 3;

    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String ANSI_BLUE = "\u001B[34m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_PURPLE = "\u001B[35m";

    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_RESET = "\u001B[0m";


    public static void main(String[] args) {

        /*
            Mostrar texto por pantalla con salto de línea al final
         */

        System.out.println("Hola Mundo!");

        /*
            Variables
         */

        int numerodecajas;
        int precio = 4;

        System.out.println("precio");

        System.out.println(precio);

        numerodecajas = 3;

        System.out.println(numerodecajas);

        System.out.println("El numero de cajas es:" + " " + numerodecajas);

        System.out.println("Tengo " + JIRAFAS + " jirafas");

        /*Cambiar de color*/

        System.out.println(ANSI_RED + "ROJO");

        System.out.println(ANSI_BLUE + "AZUL");

        System.out.println(ANSI_GREEN + "VERDE");

        System.out.println(ANSI_YELLOW + "AMARILLO");

        System.out.println(ANSI_PURPLE + "MORADO");

        System.out.println(ANSI_CYAN + "CIAN");

        System.out.println(ANSI_BLACK + "NEGRO");

        System.out.println(ANSI_WHITE + "BLANCO" + ANSI_RESET);

        System.out.println("Normal otra vez");
    }

}
