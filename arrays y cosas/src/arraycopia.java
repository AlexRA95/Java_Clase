import java.util.Arrays;

public class arraycopia {

    public static void main(String[] args) {

        int[] t = {1, 2, 3, 4, 5, 6};
        int[] a, b;

        a = Arrays.copyOf(t, 3);
        b = Arrays.copyOfRange(t,3,10);


        System.out.println(Arrays.toString(t));
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));


    }

}
