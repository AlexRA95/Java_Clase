package ejerciciosMOODLE;

import java.util.Arrays;
import java.util.Random;

public class vectorgrandechico {

    public static void main(String[] args) {

        Random ran =new Random();

        int[] num1, num2, num3, num4;
        int random;

        num1 = new int[5];

        for (int i = 0; i < num1.length ; i++) {
            random = ran.nextInt(0,11);
            num1[i]=random;
        }

        System.out.println(Arrays.toString(num1));

        num2 = Arrays.copyOf(num1, 10);

        System.out.println(Arrays.toString(num2));

        num3 = Arrays.copyOfRange(num2, 3, 7);

        System.out.println(Arrays.toString(num3));

        num4 =Arrays.copyOf(num1,num1.length);

        for (int i = 0; i < num4.length ; i++) {
            if ( num4[i] >=5  ){

                num4[i]=num4[num4.length-1];
                num4=Arrays.copyOf(num4,num4.length-1);

            }
        }

        System.out.println(Arrays.toString(num4));

        int[] num5 ={1,15,3,7};

        int elemento = 3;
        int indice = -1;

        for (int i = 0; i <num5.length ; i++) {

            if ( num5[i]==elemento ){

                indice =i;

            }

        }
        System.out.println(Arrays.toString(num5));
        System.out.println(indice);


    }


}
