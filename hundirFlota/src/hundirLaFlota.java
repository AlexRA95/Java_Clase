import java.sql.SQLOutput;
import java.util.Scanner;

public class hundirLaFlota {

    /*Función para ver el menu prinicpal y el tÍtulo*/
    static void menuPrincipal(){
        System.out.println("-------- HUNDIR LA FLOTA --------");
        System.out.println("Introduce [1] para ver las instrucciones.");
        System.out.println("Introduce [2] para jugar una partida.");
        System.out.println("Introduce [3] para ver tus estadisticas esta sesión.");
        System.out.println("Introduce [0] para SALIR.");
        System.out.println("Introduce tu opción: ");

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
    static void JugarHundirElegirDificultad(){

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
            }
            case 2->{
                System.out.println("PARTIDA DIFICULTAD FÁCIL");
            }
            case 3->{
                System.out.println("PARTIDA DIFICULTAD NORMAL");
            }
            case 4->{
                System.out.println("PARTIDA DIFICULTAD DIFÍCIL");
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
                    //JugarHundirElegirDificultad(matrizIA,matrizUSER);
                }
                case 3->{
                    /*ESTADISTICAS*/
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
