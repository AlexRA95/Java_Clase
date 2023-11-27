import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class arrayloto {


    public static void main(String[] args) {

        Random ran = new Random();
        Scanner key = new Scanner(System.in);

        int[] numloto,numuser;
        numloto = new int[6];
        numuser = new int[6];
        int num1,num2,right=0;

        for (int j = 0; j < numloto.length ; j++) {

            num2 = ran.nextInt(0,101);
            numloto[j] = num2;

        }
        Arrays.sort(numloto);
        System.out.println(Arrays.toString(numloto));

        for (int i = 0; i < numuser.length ; i++) {

            System.out.println("Introduce un número: ");
            num1 = key.nextInt();
            numuser[i] = num1;

        }


        Arrays.sort(numuser);


        for (int a: numuser
             ) {



                if ((Arrays.binarySearch(numloto,a))>0){

                    right++;

                }


        }

        System.out.printf("Has acertado %d numeros",right);

    }



}
