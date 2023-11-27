package ejerciciosMOODLE;

import java.util.Arrays;

public class matriz2 {

    public static void main(String[] args) {

        int [][] num;
        int k,a=1,b=1;
        num = new int[10][10];

        System.out.println(num.length);

        for (int i = 0; i < num.length; i++) {

            for (int j = 0; j < num.length ; j++) {
                k=(a*b);
                num[i][j]=k;
                b++;

            }
            a++;
            b=1;
        }

        System.out.println(Arrays.deepToString(num));


    }

}
