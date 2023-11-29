import java.util.Random;
import java.util.Scanner;

public class meterBarcos {

    static void vaciarTablero(Character[][] tablero){
        for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j <tablero[i].length ; j++) {
                tablero[i][j]='-';
            }
        }
    }
    static void mostrarTablero(Character[][] tablero){
        Character m= 65;
        for (int i = 0; i < tablero.length ; i++) {
            if ( i==0 ){
                System.out.print(" ");
                for (int k = 1; k < tablero[i].length+1 ; k++) {
                    System.out.print(" " + k +" ");
                }
                System.out.println(" ");
            }
            for (int j = 0; j < tablero[i].length ; j++) {
                if (j==0){

                    System.out.print("" + m + "" );
                    m++;
                }
                System.out.print(" " + tablero[i][j] +" ");
            }
            System.out.println(" ");
        }
    }

    static void anadirPortaaviones(Character[][] tablero){
        int a, b,sePuede=0;
        Random ran = new Random();
        Boolean salir=false;
            while ( !salir ){
                sePuede=0;
                a= ran.nextInt(0,10);
                b= ran.nextInt(0,10);


                for (int i = a; i < tablero.length; i++) {
                    if (tablero[i][b]=='-'){
                        sePuede++;
                        tablero[i][b]='P';
                    }
                }

                if (sePuede!=5){
                    vaciarTablero(tablero);
                }else {
                    salir=true;
                }

            }
    }

    static void anadirAcorazado(Character[][] tablero){
        int a, b,sePuede=0;
        Random ran = new Random();
        Boolean salir=false;
        while ( !salir ){
            sePuede=0;
            a= ran.nextInt(0,10);
            b= ran.nextInt(0,10);


            for (int i = a; i < tablero.length; i++) {
                if (tablero[i][b]=='-'){
                    sePuede++;
                    tablero[i][b]='Z';
                }
            }

            if (sePuede!=4){
                vaciarTablero(tablero);
                //No se tiene que vaciar pq se pierde todo, hay que hacer una copia del array con el portaaviones hecho ya
            }else {
                salir=true;
            }

        }
    }

    public static void main(String[] args) {

        Character[][] matriz;
        matriz =new Character[10][10];

        vaciarTablero(matriz);

        // Lancha(L) = 1
        //Buque(B) = 3 horizontal
        //Acorazado(Z) = 4 horizontal
        //Portaaviones(P) = 5 verticales

        anadirPortaaviones(matriz);
        anadirAcorazado(matriz);

        mostrarTablero(matriz);



    }

}
