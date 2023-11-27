import java.util.Arrays;
import java.util.Random;

public class array3 {

    public static void main(String[] args) {

        Random ran = new Random();
        int[] numeros,cuadrado,cubo;
        int num;
        numeros = new int [20];
        cuadrado = new int [20];
        cubo = new int [20];




        for (int i=0 ; i < numeros.length  ; i++ ) {

            num = ran.nextInt(1,101);
            numeros[i]=num;



        }

        for (int i=0 ; i < cuadrado.length  ; i++ ) {


            cuadrado[i]=numeros[i]*numeros[i];



        }

        for (int i=0 ; i < cubo.length  ; i++ ) {


            cubo[i]=numeros[i]*numeros[i]*numeros[i];



        }

        System.out.println(Arrays.toString(numeros));
        System.out.println(Arrays.toString(cuadrado));
        System.out.println(Arrays.toString(cubo));









    }





}
