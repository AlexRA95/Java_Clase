import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class dispararBarcos {

    //Con esta función rellenamos la matriz de '-' para vaciarla cuando sea necesario
    static void vaciarTablero(Character[][] tablero){
        for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j <tablero[i].length ; j++) {
                tablero[i][j]='-';
            }
        }
    }
    //Con esta función mostramos la matriz formateada para que se vea lo más parecido a un tablero
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
    /*Con esta función hacemos una copia del contenido de una función en otra función
    * Esto nos sirve para a la hora de rellenar tener una "copia de seguridad" del estado anterior de la matriz
    * Para rellenar las matrices con barcos, lo que he hecho ha sido generar 2 numeros aleatorios que simulan ser coordenadas
    * Con esas coordenadas nos colocaremos en una posición en la matriz y desde hay la recorreremos en la dirección indicada del barco
    * Si al recorrerla encuentra un numero de posiciones vacias seguidas igual al tamaño de ese barco se rellena
    * En el proceso de recorrerlo, ya hago que las posiciones que recorra sean sustituidas por la letra del barco
    * Si al recorrerlo no se encuentra en la situacion que queremos, haremos que matriz de la IA se vuelva al estado anterior
    * El estado anterior es la matriz que verá el usuario, que será una copia del ultimo estado correcto de la matriz*/
    static void copiarMatriz(Character[][] acopiar, Character[][]copia){

        for (int i = 0; i < acopiar.length ; i++) {
            copia[i]= Arrays.copyOf(acopiar[i],acopiar.length);
        }

    }
    //Esta función sirve para añadir los Portaaviones
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
    //Esta función sirve para añadir acorazados
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
    //Esta función sirve para añadir buques
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
    //Esta función sirve para añadir lanchas
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
    //Esta función transforma la fila en forma de letra a numero para poder usarlo para indicar posición en la matriz
    static Integer letraNumero(String fila) {
        Integer resultado;
        switch (fila.toUpperCase()) {
            case "A" -> resultado = 1;
            case "B" -> resultado = 2;
            case "C" -> resultado = 3;
            case "D" -> resultado = 4;
            case "E" -> resultado = 5;
            case "F" -> resultado = 6;
            case "G" -> resultado = 7;
            case "H" -> resultado = 8;
            case "I" -> resultado = 9;
            case "J" -> resultado = 10;
            default -> resultado = -1;
        }
        return resultado;
    }

    static void disparar(String fila, Integer columna, Character[][] matrizOculta, Character[][] matrizVisible){

        if (letraNumero(fila) > matrizOculta.length) {
            System.out.println("ERROR, la fila es incorrecta.");
        } else if (columna > matrizOculta.length) {
            System.out.println("ERROR, la columna es incorrecta.");
        } else {
            if (matrizOculta[letraNumero(fila) - 1][columna - 1]!='-'){
                matrizVisible[letraNumero(fila) - 1][columna - 1]='X';
            }else {
                matrizVisible[letraNumero(fila) - 1][columna - 1]='O';
            }

            mostrarTablero(matrizVisible);
        }

    }


    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Integer bb = 1;
        String aa = " ";
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
        vaciarTablero(matrizUSER);

        for (int i = 0; i <50 ; i++) {
            System.out.print("Introduce -1 para salir\n");
            System.out.println("Una fila: ");
            aa = key.nextLine();


            System.out.print("Introduce -1 para salir\n");
            System.out.println("Una columna: ");
            bb = key.nextInt();

            key.nextLine();

            if (letraNumero(aa) <= 0 || bb <= 0) {
                i=50;
            } else {disparar(aa,bb,matrizIA,matrizUSER);}
        }

       /*Ahora hay que hacer un contador puta madre para saber que si se cumplen los cincuenta turnos has perdido
       * y si sales antes, entonces has ganado*/




    }
}
