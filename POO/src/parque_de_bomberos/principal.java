package parque_de_bomberos;

import java.util.ArrayList;
import java.util.Scanner;

public class principal {

    public static void menu(){

        System.out.println("---Menú---");
        System.out.println("1. Listar Parques de Bomberos.");
        System.out.println("2. Listar Personal.");
        System.out.println("3. Listar Avisos de un Parque");
        System.out.println("4. Salir.");
        System.out.println("Introduce tu opción: ");

    }



    public static void main(String[] args) {
        boolean salir=false;
        Scanner key = new Scanner(System.in);
        int opc;
        ArrayList<Parque> parques=new ArrayList<>();
        parques.add(new Parque("a"));
        parques.add(new Parque("b"));
        parques.add(new Parque("c"));

        parques.get(0).agregarBombero("Antonio Marques Carnasa", 25, Rango.OFICIAL);
        parques.get(0).agregarBombero("Paco Manuel Jones", 18, Rango.SUBOFICIAL);
        parques.get(0).agregarBombero("Marcos Miguel", 65, Rango.OFICIAL);
        parques.get(1).agregarBombero("Manolo Más", 35, Rango.BOMBERO);
        parques.get(1).agregarBombero("Pedro Menos", 22, Rango.CABO);
        parques.get(1).agregarBombero("Jesé Rodríguez", 18, Rango.CABO);
        parques.get(2).agregarBombero("Francisco Javier", 96, Rango.BOMBERO);
        parques.get(2).agregarBombero("Juan Miguel", 54, Rango.CABO);
        parques.get(2).agregarBombero("Jose María Rodríguez", 37, Rango.SUBOFICIAL);

        while (!salir){
            menu();
            opc= key.nextInt();
            switch (opc){
                case 1->{
                    for (Parque p: parques
                         ) {
                        System.out.println(p.toString());
                        System.out.println(" ");
                    }
                }
                case 2->{
                    for (Parque p: parques
                         ) {
                        System.out.println("------PARQUE " + p.getIdParque()+ " ------");
                        p.listarPersonal();
                        System.out.println(" ");
                    }
                }
                case 3->{
                    Parque.sacarAvisos();
                }
                case 4->{
                    System.out.println("SALIENDO...");
                    salir=true;
                }
                default -> {
                    System.out.println("Valor incorrecto");
                }
            }
        }


    }

}
