package ejCLASE;

import java.util.Scanner;

public class inventario {

    public static void main(String[] args) {

        Scanner key=new Scanner(System.in);

        String[] nombrePro;
        Double[] precioPro;
        Integer[] cantidadPro;
        nombrePro=new String[0];
        precioPro=new Double[0];
        cantidadPro=new Integer[0];
        Integer opcUser;
        Boolean salir=true;

        while (salir){

            System.out.println("1. Para añadir producto");
            System.out.println("2. Actualizar productos");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Buscar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Salir");
            System.out.println(" ");
            System.out.println("Introduce tu opción: ");
            opcUser= key.nextInt();

            switch (opcUser){

                case 1->{}

                case 0->{

                    System.out.println("Has salido");
                    salir=false;

                }

                default -> {

                    System.out.println("Valor incorrecto");

                }

            }


        }



    }

}
