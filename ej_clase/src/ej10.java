import java.util.Scanner;

public class ej10 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Introduce el precio de tu cosecha:");
        double precio = keyboard.nextInt();


        System.out.println("Si es de tipo A introduce A");
        System.out.println("Si es de tipo B introduce B");
        System.out.println("Introduce de que tipo es tu cosecha:");
        String tipo = keyboard.next();

        if ( !tipo.equals("A") && !tipo.equals("B") ){
            System.out.println("Has introducido un tipo incorrecto");
            System.exit(0);
        }

        System.out.println("Si es de tamaño 1 introduce 1");
        System.out.println("Si es de tamaño 2 introduce 2");
        System.out.println("Introduce de que tamaño es tu cosecha:");
        int size = keyboard.nextInt();

        if (size != 1 && size != 2){
            System.out.println("Has introducido un tamaño incorrecto");
            System.exit(0);
        }

        double resultado;

        switch (tipo) {
            case "A":


                if (size == 1){

                    resultado = ((precio + 0.20));

                } else {

                    resultado = ((precio + 0.30));

                }
                System.out.printf("Si tu precio original era %f € y tu tipo es A y su tamaño es %d, tu precio final es %f €",precio,size,resultado);

                break;
            case "B":


                if (size == 1){

                    resultado = ((precio - 0.30));

                } else {

                    resultado = ((precio - 0.50));

                }
                System.out.printf("Si tu precio original era %f € y tu tipo es A y su tamaño es %d, tu precio final es %f €",precio,size,resultado);

                break;

        }

    }

}
