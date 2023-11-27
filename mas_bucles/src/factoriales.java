import java.util.Scanner;

public class factoriales {

    public static void main(String[] args) {
        int num;
        long calc=1;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Pon el número que quieres factorizar: ");

        num = keyboard.nextInt();

        for (int i = 1; i <= num ; i++) {

            calc = i*calc;

        }


        System.out.printf("El factorizado de %d es %d",num,calc);

    }


}
