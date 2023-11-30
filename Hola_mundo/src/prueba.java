import java.util.Arrays;

public class prueba {



    public static void main(String[] args) {

        int[] prueba={4,4,4};

        prueba[0]--;

        while (prueba[0]>0) prueba[0]--;

        System.out.println(Arrays.toString(prueba));


    }

}
