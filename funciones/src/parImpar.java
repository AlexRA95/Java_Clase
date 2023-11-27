import java.util.Scanner;

public class parImpar {

    static boolean esparimpar(int a){

        return a % 2 == 0;

    }


    public static void main(String[] args) {

        int num1;
        Scanner key =new Scanner(System.in);

        System.out.println("Introduce un número: ");
        num1= key.nextInt();

        if (esparimpar(num1)){
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }

    }

}
