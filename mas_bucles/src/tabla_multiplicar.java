import java.util.Scanner;
public class tabla_multiplicar {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int num,result;



        System.out.println("Introduce el número del que quieras su tabla de multiplicar:");
        num = keyboard.nextInt();

        for (int i = 0; i <= 10 ; i++) {
            result = i*num;

            System.out.printf("\nEl resultado de la multiplicación de %d y de %d es %d\n",num,i,result);


        }

    }


}
