import java.util.Arrays;
import java.util.Random;

public class buscarEnVector {

    static int[] exists (int[] a, int buscar) {
        int[] esta;
        esta=new int[0];

        for (int i = 0; i <a.length ; i++) {
            if (a[i]==buscar){

                esta=Arrays.copyOf(esta,esta.length+1);
                esta[esta.length-1]=i;
            }
        }

        return esta;

    }

    public static void main(String[] args) {

        Random ran = new Random();
        int[] array;
        int num1=5,numran;
        array =new int[100];

        for (int i = 0; i < array.length ; i++) {
            numran=ran.nextInt(0,11);
            array[i]=numran;
        }

        if (exists(array,num1).length==0){

            System.out.println("El numero no está en el array");

        } else {

            System.out.println("El numero está en la posición " + Arrays.toString(exists(array, num1)) + " y se repite " + exists(array,num1).length + " veces");

        }

        System.out.println(Arrays.toString(array));
    }

}
