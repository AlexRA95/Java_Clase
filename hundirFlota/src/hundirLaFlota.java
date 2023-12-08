import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hundirLaFlota {
    public static Integer[][] estadisticasPartida={{0,0,0,0},{0,0,0,0}};

    /*Función para ver el menu prinicpal y el tÍtulo*/
    static void menuPrincipal(){
        System.out.println("-------- HUNDIR LA FLOTA --------");
        System.out.println("Introduce [1] para ver las instrucciones.");
        System.out.println("Introduce [2] para jugar una partida.");
        System.out.println("Introduce [3] para ver tus estadisticas esta sesión.");
        System.out.println("Introduce [0] para SALIR.");
        System.out.println("Introduce tu opción: ");

    }

    //Con esta función rellenamos la matriz de '-' para vaciarla cuando sea necesario
    static void vaciarTablero(Character[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    //Con esta función mostramos la matriz formateada para que se vea lo más parecido a un tablero
    static void mostrarTablero(Character[][] tablero) {
        Character m = 65;
        for (int i = 0; i < tablero.length; i++) {
            if (i == 0) {
                System.out.print(" ");
                for (int k = 1; k < tablero[i].length + 1; k++) {
                    System.out.print(" " + k + " ");
                }
                System.out.println(" ");
            }
            for (int j = 0; j < tablero[i].length; j++) {
                if (j == 0) {

                    System.out.print("" + m + "");
                    m++;
                }
                System.out.print(" " + tablero[i][j] + " ");
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
    static void copiarMatriz(Character[][] acopiar, Character[][] copia) {

        for (int i = 0; i < acopiar.length; i++) {
            copia[i] = Arrays.copyOf(acopiar[i], acopiar.length);
        }

    }

    //Esta función sirve para añadir los Portaaviones
    static void anadirPortaaviones(Character[][] tablero, Character[][] copia) {
        int a, b, sePuede = 0;
        Random ran = new Random();
        Boolean salir = false;
        while (!salir) {
            sePuede = 0;
            a = ran.nextInt(0, 10);
            b = ran.nextInt(0, 10);
            for (int i = a; i < tablero.length; i++) {
                if (tablero[i][b] == '-') {
                    sePuede++;
                    tablero[i][b] = 'P';
                }
                if (sePuede == 5) {
                    i = tablero.length;
                }
            }
            if (sePuede != 5) {
                vaciarTablero(tablero);
            } else {
                copiarMatriz(tablero, copia);
                salir = true;
            }
        }
    }

    //Esta función sirve para añadir acorazados
    static void anadirAcorazado(Character[][] tablero, Character[][] copia) {
        int a, b, sePuede = 0;
        Random ran = new Random();
        Boolean salir = false;
        while (!salir) {
            sePuede = 0;
            a = ran.nextInt(0, 10);
            b = ran.nextInt(0, 10);
            for (int i = a; i < tablero.length; i++) {
                if (tablero[b][i] == '-') {
                    sePuede++;
                    tablero[b][i] = 'Z';
                } else {
                    i = tablero.length;
                }
                if (sePuede == 4) {
                    i = tablero.length;
                }
            }
            if (sePuede != 4) {
                copiarMatriz(copia, tablero);
            } else {
                copiarMatriz(tablero, copia);
                salir = true;
            }
        }
    }

    //Esta función sirve para añadir buques
    static void anadirBuque(Character[][] tablero, Character[][] copia) {
        int a, b, sePuede = 0;
        Random ran = new Random();
        Boolean salir = false;
        while (!salir) {
            sePuede = 0;
            a = ran.nextInt(0, 10);
            b = ran.nextInt(0, 10);
            for (int i = a; i < tablero.length; i++) {
                if (tablero[b][i] == '-') {
                    sePuede++;
                    tablero[b][i] = 'B';
                } else {
                    i = tablero.length;
                }
                if (sePuede == 3) {
                    i = tablero.length;
                }
            }
            if (sePuede != 3) {
                copiarMatriz(copia, tablero);
            } else {
                copiarMatriz(tablero, copia);
                salir = true;
            }
        }
    }

    //Esta función sirve para añadir lanchas
    static void anadirLancha(Character[][] tablero, Character[][] copia) {

        int a, b;
        Random ran = new Random();
        Boolean salir = false;
        while (!salir) {
            a = ran.nextInt(0, 10);
            b = ran.nextInt(0, 10);
            if (tablero[a][b] == '-') {
                tablero[a][b] = 'L';
                copiarMatriz(tablero, copia);
                salir = true;
            } else {
                copiarMatriz(copia, tablero);
            }
        }

    }
    //Esta función añade los barcos dependiendo de la dificultad
    static void anadirPorDificultad(Character[][] tablero, Character[][] copia, Integer porta, Integer acora, Integer buque, Integer lancha) {

        for (int i = 0; i < porta; i++) {
            anadirPortaaviones(tablero, copia);
        }

        for (int i = 0; i < acora; i++) {
            anadirAcorazado(tablero, copia);

        }
        for (int i = 0; i < buque; i++) {
            anadirBuque(tablero, copia);
        }
        for (int i = 0; i < lancha; i++) {
            anadirLancha(tablero, copia);

        }
        vaciarTablero(copia);
        mostrarTablero(copia);

    }
    //Esta función pide los valores donde se va a disparar
    static int introduceDisparar(Character[][] tablero, Character[][] copia) {
        Scanner key = new Scanner(System.in);
        Boolean valor1=true, valor2=true;
        Integer bb = 1, tocado = 0;
        String aa = " ";

        do {
            try {
                System.out.println("Una fila de la A a la J: ");
                aa = key.nextLine();
                valor1=false;
            }
            catch (Exception e){
                System.out.println("ERROR: DATO NA VALIDO, VUELVA A INTRODUCIR UN DATO");
                valor1=true;
                key.nextLine();
            }
        }while (valor1);

        do {
            try {
                System.out.println("Una columna del 1 al 10: ");
                bb = key.nextInt();
                valor2=false;
            }
            catch (Exception e){
                System.out.println("ERROR: DATO NA VALIDO, VUELVA A INTRODUCIR UN DATO");
                valor2=true;
                key.nextLine();
            }
        }while (valor2);
        key.nextLine();

        tocado = disparar(aa, bb, tablero, copia);

        return tocado;

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
    //Esta función comprueba las posiciones donde se dispara
    static int disparar(String fila, Integer columna, Character[][] matrizVisible, Character[][] matrizOculta) {
        Integer tocado = -1;
        if (letraNumero(fila) > matrizOculta.length) {
            System.out.println("ERROR, la fila es incorrecta.");

        } else if (columna > matrizOculta.length) {
            System.out.println("ERROR, la columna es incorrecta.");

        } else if (letraNumero(fila)<=0){
            System.out.println("ERROR, la fila es incorrecta.");
        }else if (columna<=0){
            System.out.println("ERROR, la columna es incorrecta.");
        }
        else {

            if (matrizVisible[letraNumero(fila) - 1][columna - 1] == 'A'){
                System.out.println("YA HAS DISPARADO AHÍ");
            } else if (matrizVisible[letraNumero(fila) - 1][columna - 1] == 'X') {
                System.out.println("YA HAS DISPARADO AHÍ");
            }else if (matrizOculta[letraNumero(fila) - 1][columna - 1] == '-') {
                System.out.println("AGUA");
                matrizVisible[letraNumero(fila) - 1][columna - 1] = 'A';
                tocado = 0;
            } else if (matrizOculta[letraNumero(fila) - 1][columna - 1] != '-') {
                System.out.println("TOCADO");
                matrizVisible[letraNumero(fila) - 1][columna - 1] = 'X';
                tocado = 1;
            }
            mostrarTablero(matrizVisible);

        }
        return tocado;

    }
    //Esta función inicializa la partida
    static Integer jugarPartida(Character[][] tablero, Character[][] copia,Integer turnos, Integer porta, Integer acora, Integer buque, Integer lancha) {
        Integer jugando=0,moveValido,ganado=0;
        vaciarTablero(tablero);
        vaciarTablero(copia);
        anadirPorDificultad(tablero, copia, porta, acora, buque, lancha);
        for (int i = 1; i <= turnos; i++) {
            System.out.printf("\nTURNO %d \n",i);
            moveValido=introduceDisparar(copia, tablero);
            if (moveValido==-1){
                i--;
            }else {
                jugando+=moveValido;
            }

            if (jugando==(porta+acora+buque+lancha)){
                System.out.println("HAS GANADO!!!!!!");
                ganado=1;
                i=turnos;
            }
        }
        if (jugando!=(porta+acora+buque+lancha)){
            System.out.println("HAS PERDIDO!!!!!!");
            ganado=0;
        }

        return ganado;
    }

    /*Menú de jugar partida con las dificultades*/
    static void menuJuego(){
        System.out.println();
        System.out.println("Introduce [1] para jugar el modo MUY FÁCIL.");
        System.out.println("Introduce [2] para jugar el modo FÁCIL.");
        System.out.println("Introduce [3] para jugar el modo NORMAL.");
        System.out.println("Introduce [4] para jugar el modo DIFICIL.");
        System.out.println("Introduce [5] para ver las caracteristicas de cada modo.");
        System.out.println("Introduce [0] para volver al menú principal.");
        System.out.println("Introduce tu opción: ");
    }
    /*Menú donde elegimos la dificultad de la partida*/
    static void JugarHundirElegirDificultad(Character[][] enemigo, Character[][] usuario,Integer[][] jugadoGanado){

        Scanner key =new Scanner(System.in);
        Integer menuDificultadOpc=0;
        Boolean errores2=false;

        do {
            menuJuego();
            try {
                menuDificultadOpc= key.nextInt();
                errores2 = true;
            } catch (Exception e) {
                System.out.println("ERROR: DATO NA VALIDO, VUELVA A INTRODUCIR UN DATO");
                errores2 = false;
                key.nextLine();
            }
        } while (!errores2);
        switch (menuDificultadOpc){
            case 1->{
                System.out.println("PARTIDA DIFICULTAD MUY FÁCIL");
                if (jugarPartida(enemigo, usuario,50,0,0,0,10) == 1){
                    estadisticasPartida[1][0]++;
                }
                estadisticasPartida[0][0]++;
            }
            case 2->{
                System.out.println("PARTIDA DIFICULTAD FÁCIL");
                if (jugarPartida(enemigo, usuario,50,1,1,1,2) == 1){
                    estadisticasPartida[1][1]++;
                }
                estadisticasPartida[0][1]++;
            }
            case 3->{
                System.out.println("PARTIDA DIFICULTAD NORMAL");
                if (jugarPartida(enemigo, usuario,30,1,1,1,2) == 1){
                    estadisticasPartida[1][2]++;
                }
                estadisticasPartida[0][2]++;
            }
            case 4->{
                System.out.println("PARTIDA DIFICULTAD DIFÍCIL");
                if (jugarPartida(enemigo, usuario,10,0,0,1,1) == 1){
                    estadisticasPartida[1][3]++;
                }
                estadisticasPartida[0][3]++;
            }
            case 0->{
                System.out.println("Has vuelto al menú principal.");
            }
        }
    }
    /*Se muestra el menú de opciones de juego y se elige da una opción que se usará en el switch  del main*/
    static int opcionMenuPrincipal(){

        Scanner key =new Scanner(System.in);
        Integer menuPrincipalOpc=0;
        Boolean errores1=false;

        do {
            menuPrincipal();
            try {
                menuPrincipalOpc=key.nextInt();
                errores1 = true;
            } catch (Exception e) {
                System.out.println("ERROR: DATO NA VALIDO, VUELVA A INTRODUCIR UN DATO");
                errores1 = false;
                key.nextLine();

            }

        } while (!errores1);

        return menuPrincipalOpc;

    }
    //Esta función enseña las estadisticas de juego de la sesión
    static void estadisticas(){
        Integer totalJugado=0, totalGanado=0;
        for (int i = 0; i <estadisticasPartida.length ; i++) {
            for (int j = 0; j <estadisticasPartida[i].length ; j++) {
                if (i==0){
                    totalJugado+=estadisticasPartida[i][j];
                }else {
                    totalGanado+=estadisticasPartida[i][j];
                }
            }
        }

        System.out.println("------ESTADISTICAS------");
        System.out.printf("\nHas jugado un total de %d partidas totales.",totalJugado);
        System.out.printf("\nHas jugado un total de %d partidas en MUY FACIL.",estadisticasPartida[0][0]);
        System.out.printf("\nHas jugado un total de %d partidas en FACIL.",estadisticasPartida[0][1]);
        System.out.printf("\nHas jugado un total de %d partidas en NORMAL.",estadisticasPartida[0][2]);
        System.out.printf("\nHas jugado un total de %d partidas en DIFICIL.",estadisticasPartida[0][3]);
        System.out.println(" ");
        System.out.printf("\nHas ganado un total de %d partidas totales.",totalGanado);
        System.out.printf("\nHas ganado un total de %d partidas en MUY FACIL.",estadisticasPartida[1][0]);
        System.out.printf("\nHas ganado un total de %d partidas en FACIL.",estadisticasPartida[1][1]);
        System.out.printf("\nHas ganado un total de %d partidas en NORMAL.",estadisticasPartida[1][2]);
        System.out.printf("\nHas ganado un total de %d partidas en DIFICIL.\n",estadisticasPartida[1][3]);
        System.out.println(" ");

    }

    static void instruccionesJuego(){
        
    }


    public static void main(String[] args) {
        Boolean salida=false;
        Character[][] matrizIA, matrizUSER;
        matrizIA =new Character[10][10];
        matrizUSER= new Character[10][10];
        /* Meter aqui lo de prueba_tablero*/

        while (!salida){



            switch (opcionMenuPrincipal()){
                case 1->{
                    /*INSTRUCCIONES*/
                }
                case 2->{
                    /*MENU PARA JUGAR*/
                    JugarHundirElegirDificultad(matrizIA,matrizUSER,estadisticasPartida);
                }
                case 3->{
                    /*ESTADISTICAS*/
                    estadisticas();
                }
                case 0->{
                    /*SALIR*/
                    System.out.println();
                    System.out.println("Has salido del programa.");
                    System.out.println();
                    salida=true;
                }
                default -> {
                    System.out.println("ERROR: DATO NA VALIDO, VUELVA A INTRODUCIR UN DATO");
                }


            }

        }




    }
}
