import java.util.Arrays;

import java.util.Scanner;

public class ej9 {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in) ;


        int[] num;
        int usernum,cont1=0;


        num = new int[100] ;


        for (int i = 0; i < num.length; i++) {
            num[i]= (int) (1+Math.random()*10);
        }

        Arrays.sort(num);

        System.out.println(Arrays.toString(num));

        System.out.println("Introduce un número: ");
        usernum = key.nextInt();


        for (int j: num
             ) {

            if (usernum == j){

                System.out.printf("\nEl número %d aparece en la posición %d del vector \n",usernum,cont1);

            }

            cont1++;

        }

    }


}
