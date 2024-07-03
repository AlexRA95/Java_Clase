import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    static int menu(Scanner key){
        int opc=0;
        boolean salir=false;
        while (!salir){
            try{
                System.out.println("                POTIONCRAFT                       ");
                System.out.println("- - - - - - - - - - - - - - - - - - - -");
                System.out.println("1. CREAR POCIONES");
                System.out.println("2. VENDER POCIONES");
                System.out.println("3. COMPRAR INGREDIENTES");
                System.out.println("4. REABASTECER COMERCIANTES");
                System.out.println("5. MOSTRAR ESTADÍSTICAS DEL JUEGO");
                System.out.println("6. MOSTRAR COMERCIANTES");
                System.out.println("7.  MOSTRAR POCIONES DISPONIBLES");
                System.out.println("8. SALIR");
                System.out.println("----> INTRODUCE TU OPCIÓN: ");
                opc= key.nextInt();
                salir=true;
            }catch(InputMismatchException e){
                System.out.println("Dato introducido por teclado invalido");
            } finally {
                key.nextLine();
            }
        }
        return opc;
    }


    public static void main(String[] args) {
        Juego j1 =new Juego();
        Scanner key=new Scanner(System.in);
        Boolean salir=false;
        while (!salir){
            switch (menu(key)){
                case 1-> {
                    System.out.println("1");
                }
                case 2-> {
                    System.out.println("2");
                }
                case 3-> {
                    System.out.println("3");
                }
                case 4-> {
                    System.out.println("4");
                }
                case 5-> {
                    System.out.println("5");
                }
                case 6-> {
                    System.out.println("MOSTRANDO COMERCIANTES...");
                    j1.verComerciantes();
                }
                case 7-> {
                    System.out.println("7");
                }
                case 8-> {
                    System.out.println("PARTIDA GUARDADA");
                    System.out.println("Saliendo del juego...");
                    j1.guardar();
                    salir=true;

                }

                default -> System.out.println("VALOR INCORRECTO");
            }
        }


    }

}
