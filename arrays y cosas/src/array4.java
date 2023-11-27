import java.util.Arrays;
import java.util.Random;

public class array4 {

    public static void main(String[] args) {

        Random ran = new Random();

        int [] num1;
        int num2;

        num1 = new int[10];


        for (int i = 0; i < num1.length ; i++){

            num2 = ran.nextInt(1,101);
            num1[i]=num2;

        }
        Arrays.sort(num1);

        System.out.println(Arrays.toString(num1));


    }

}
