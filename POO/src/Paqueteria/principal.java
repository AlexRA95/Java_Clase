package Paqueteria;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

public class principal {

    static void menu(){
        System.out.println("      PAQUETERÍA      ");
        System.out.println("- - - - - - - - - - - -");
        System.out.println("1. Enviar Paquete");
        System.out.println("2. Entregar paquete");
        System.out.println("3. Información Oficina");
        System.out.println("4. Listar Paquetes por urgencia");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción: ");
    }
    static void enviarPaquete(Scanner key, ArrayList<Oficina> listaOfi, ArrayList<Paquete> listaPaquetes){
        key.nextLine();
        System.out.println("Indica que paquete quieres entregar(ID): ");
        Integer idPaq = key.nextInt();
        System.out.println("Indica que oficina quieres que lo entregue(ID): ");
        Integer idOfi = key.nextInt();
        System.out.println("1. NORMAL(72h)");
        System.out.println("2.URGENTE (48h)");
        System.out.println("3. MUY URGENTE (24h)");
        System.out.println("Seleccione el tipo de envio que quiere: ");
        

    }

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Boolean salir=false;
        ArrayList<Oficina> oficinas =new ArrayList<>();
        oficinas.add(new Oficina("Cáceres"));
        oficinas.add(new Oficina("Mérida"));
        oficinas.add(new Oficina("Badajoz"));
        ArrayList<Paquete> paquetes =new ArrayList<>();
        paquetes.add(new Paquete("Manuel","C/Inventada1"));
        paquetes.add(new Paquete("Antonio","C/Inventada2"));
        paquetes.add(new Paquete("Paca","C/Inventada3"));
        paquetes.add(new Paquete("Jose","C/Inventada4"));
        paquetes.add(new Paquete("Miguel","C/Inventada5"));
        paquetes.add( new Paquete("Lokete","C/Inventada6"));
        paquetes.add( new Paquete("Knekro","C/Inventada7"));
        paquetes.add( new Paquete("Reven","C/Inventada8"));
        paquetes.add( new Paquete("Skain","C/Inventada9"));

        while (!salir){
            menu();
            Integer opc= key.nextInt();
            switch (opc){
                case 1-> {

                }
                default -> {
                    System.err.println("ERROR: VALOR INCORRECTO.");
                }
            }
        }



    }
}
