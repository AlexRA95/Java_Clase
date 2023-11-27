import java.util.Scanner;


public class ej8 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduce un lado:");
        double lado1 = keyboard.nextInt();

        System.out.println("Introduce un lado:");
        double lado2 = keyboard.nextInt();

        System.out.println("Introduce un lado:");
        double lado3 = keyboard.nextInt();

        if ( lado1 != Math.pow(lado2,2)+Math.pow(lado3,2) || lado2 != Math.pow(lado1,2)+Math.pow(lado3,2) || lado3 != Math.pow(lado2,2)+Math.pow(lado1,2)){

            System.out.println("No es un triangulo");
        }
        
        if ( lado1 == lado2 && lado1 ==lado3 ){

            System.out.println("Es un triangulo equilatero");
            
        } else if ( lado1 == lado2 || lado2 == lado3 || lado1 == lado3 ) {

            System.out.println("Es un triangulo isosceles");
            
        } else if ( lado1 == Math.pow(lado2,2)+Math.pow(lado3,2) || lado2 == Math.pow(lado1,2)+Math.pow(lado3,2) || lado3 == Math.pow(lado2,2)+Math.pow(lado1,2))  {

            System.out.println("Es un triangulo rectangulo");

        } else {

            System.out.println("Es un triangulo escaleno");

        }

    }

}
