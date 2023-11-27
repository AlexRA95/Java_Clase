public class Cuadrado {

    public static final int LADO = 3;


    public static void main(String[] args) {


        int lado = 5;

        int area = ((lado * lado));

        System.out.println("Con variables: ");

        System.out.println("El area de un cuadrado de lado " + lado + " es =" + " " + area);

        System.out.println(" ");

        System.out.println("Con constantes: ");

        System.out.println("El area de un cuadrado de lado " + LADO + " es =" + " " + LADO * LADO);

    }

}
