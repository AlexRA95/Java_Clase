
public class ej12 {

    public static void main(String[] args) {


        int num,suma,div;
        num=0;
        suma=0;

        for ( int i = 1; num < 10; i++ ){

            div = (( i%2 ));

            if ( div != 0 ){
                suma = (( suma + i ));
                num++;
            }

        }

        System.out.printf("\nLa suma de los 10 primeros numero impares es %d\n",suma);

    }

}
