import java.util.Scanner;

public class descuento {

    public static void main(String[] args) {



        Scanner keyboard = new Scanner(System.in);

        System.out.println("Introduce el precio por el que lo has comprado: ");
        double precio_venta = keyboard.nextInt();

        System.out.println("Introduce el precio original de venta; ");
        double precio_original = keyboard.nextInt();

        double porcentaje = precio_venta/precio_original;
        porcentaje = porcentaje*100;

        System.out.printf("Si has pagado %f € y el precio original es de %f €, entonces has tenido un descuento de ",precio_venta,precio_original);
        System.out.print(porcentaje + "€");

    }

}
