import java.util.Arrays;
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

    static void copiarMatriz(Character[][] acopiar, Character[][]copia){

        for (int i = 0; i < acopiar.length ; i++) {
            copia[i]= Arrays.copyOf(acopiar[i],acopiar.length);
        }

    }

    static void anadirPortaaviones(Character[][] tablero, Character[][] copia){
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
                    if (sePuede==5){
                        i= tablero.length;
                    }
                }
                if (sePuede!=5){
                    vaciarTablero(tablero);
                }else {
                    copiarMatriz(tablero,copia);
                    salir=true;
                }
            }
    }

    static void anadirAcorazado(Character[][] tablero, Character[][] copia){
        int a, b,sePuede=0;
        Random ran = new Random();
        Boolean salir=false;
        while ( !salir ){
            sePuede=0;
            a= ran.nextInt(0,10);
            b= ran.nextInt(0,10);
            for (int i = a; i < tablero.length; i++) {
                if (tablero[b][i]=='-'){
                    sePuede++;
                    tablero[b][i]='Z';
                }else {i= tablero.length;}
                if (sePuede==4){
                    i= tablero.length;
                }
            }
            if (sePuede!=4){
                copiarMatriz(copia,tablero);
            }else {
                copiarMatriz(tablero,copia);
                salir=true;
            }
        }
    }

    static void anadirBuque(Character[][] tablero, Character[][] copia){
        int a, b,sePuede=0;
        Random ran = new Random();
        Boolean salir=false;
        while ( !salir ){
            sePuede=0;
            a= ran.nextInt(0,10);
            b= ran.nextInt(0,10);
            for (int i = a; i < tablero.length; i++) {
                if (tablero[b][i]=='-'){
                    sePuede++;
                    tablero[b][i]='B';
                }else {i= tablero.length;}
                if (sePuede==3){
                    i= tablero.length;
                }
            }
            if (sePuede!=3){
                copiarMatriz(copia,tablero);
            }else {
                copiarMatriz(tablero,copia);
                salir=true;
            }
        }
    }

    static void anadirLancha(Character[][] tablero, Character[][] copia){

        int a, b;
        Random ran = new Random();
        Boolean salir=false;
        while ( !salir ){
            a= ran.nextInt(0,10);
            b= ran.nextInt(0,10);
                if (tablero[a][b]=='-'){
                    tablero[a][b]='L';
                    copiarMatriz(tablero,copia);
                    salir=true;
                }else {copiarMatriz(copia,tablero);}
        }

    }



    public static void main(String[] args) {

        Character[][] matrizIA, matrizUSER;
        matrizIA =new Character[10][10];
        matrizUSER= new Character[10][10];

        vaciarTablero(matrizIA);
        vaciarTablero(matrizUSER);

        // Lancha(L) = 1
        //Buque(B) = 3 horizontal
        //Acorazado(Z) = 4 horizontal
        //Portaaviones(P) = 5 verticales

        anadirPortaaviones(matrizIA, matrizUSER);

        for (int i = 0; i <1 ; i++) {
            anadirAcorazado(matrizIA,matrizUSER);

        }
        for (int i = 0; i <3 ; i++) {
            anadirBuque(matrizIA,matrizUSER);
        }
        for (int i = 0; i <5 ; i++) {
            anadirLancha(matrizIA,matrizUSER);

        }
        mostrarTablero(matrizIA);





    }

}
