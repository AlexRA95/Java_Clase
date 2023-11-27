package ejerciciosMOODLE;

import java.util.Arrays;

public class matriz1 {

    public static void main(String[] args) {

        int [][] num;
        int k=1;
        num = new int[5][5];

        System.out.println(num.length);

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length ; j++) {
                num[i][j]=k;
                k++;
            }

        }

        System.out.println(Arrays.deepToString(num));


    }


}
