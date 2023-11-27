import java.util.Scanner;


public class array2 {


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int[] num;
        num = new int[10];


        for (int i = 0; i < 10 ; i++) {
            System.out.println("Introduce un num:");
            num[i] = keyboard.nextInt();


        }


        System.out.println();

        for (int a = 9; a >=0 ; a--){

            System.out.print(num[a]);
            System.out.print(", ");

        }

    }


}
