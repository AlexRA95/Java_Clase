import java.util.Arrays;
import java.util.Random;

public class buscarEnMatriz {

    static int[][] estaMatriz (int[][] a, int b) {

        int[][] nuevo = new int[2][0];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                if (a[i][j] == b) {
                    nuevo[0] = Arrays.copyOf(nuevo[0], nuevo[0].length + 1);
                    nuevo[0][nuevo[0].length-1] = i;
                    nuevo[1] = Arrays.copyOf(nuevo[1], nuevo[1].length + 1);
                    nuevo[1][nuevo[1].length-1] = j;
                }
            }
        }

        return nuevo;

    }


    public static void main(String[] args) {
        Random ran = new Random();
        int[][] array;
        int num1=5,numran;
        array =new int[5][3];

        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                numran=ran.nextInt(1,10);
                array[i][j]=numran;
            }
        }

        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.deepToString(estaMatriz(array,num1)));

    }
}
