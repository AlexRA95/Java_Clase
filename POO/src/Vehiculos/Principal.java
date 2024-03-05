package Vehiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static void listarVehiculos(ArrayList<Vehiculo> list){
        for (Vehiculo v: list){
            System.out.println(v.toString());
        }
    }

    static void listarPersonas(ArrayList<Persona> list){
        for (Persona p: list){
            System.out.println(p.toString());
        }
    }

    static boolean opcionesConductor(Scanner key, ArrayList<Persona> list, ArrayList<Vehiculo> vehiculos){
        boolean done=false;
        System.out.println("Introduzca el DNI de la persona que quiere consultar: ");
        String dni=key.nextLine();
        Persona p1= new Persona(dni);
        if (list.contains(p1)){
            for (Persona p: list){
                if (p.equals(p1)){
                    TipoConductor c=p.getTipoConductor();
                    int v =switch (c){
                        case NOVEL -> v=100;
                        case INTERMEDIO -> v=160;
                        case PROFESIONAL -> v=Integer.MAX_VALUE;
                    };
                    for (Vehiculo ve: vehiculos){
                        if (ve.getvMax()<=v){
                            System.out.println(ve.toString());
                        }
                    }
                    return true;
                }
            }
        }else {
            System.out.println("Esa persona no existe.");

        }
        return false;
    }


    public static void main(String[] args) {
        Scanner key=new Scanner(System.in);
        ArrayList<Vehiculo> listaVehiculos=new ArrayList<>();
        ArrayList<Persona> listaPersonas=new ArrayList<>();

        //                PERSONAS

        listaPersonas.add(new Persona("11111111A", "Juan", TipoConductor.NOVEL));
        listaPersonas.add(new Persona("22222222B", "Ana", TipoConductor.INTERMEDIO));
        listaPersonas.add(new Persona("33333333C", "Pedro", TipoConductor.PROFESIONAL));
        listaPersonas.add(new Persona("44444444D", "María", TipoConductor.NOVEL));
        listaPersonas.add(new Persona("55555555E", "Carlos", TipoConductor.INTERMEDIO));
        listaPersonas.add(new Persona("66666666F", "Laura", TipoConductor.PROFESIONAL));
//        listaPersonas.add(new Persona("77777777G", "David", Conductor.NOVEL));
//        listaPersonas.add(new Persona("88888888H", "Elena", Conductor.INTERMEDIO));
//        listaPersonas.add(new Persona("99999999I", "Javier", Conductor.PROFESIONAL));
//        listaPersonas.add(new Persona("10101010J", "Sara", Conductor.NOVEL));
//        listaPersonas.add(new Persona("12121212K", "José", Conductor.INTERMEDIO));
//        listaPersonas.add(new Persona("13131313L", "Carmen", Conductor.PROFESIONAL));
//        listaPersonas.add(new Persona("14141414M", "Miguel", Conductor.NOVEL));
//        listaPersonas.add(new Persona("15151515N", "Isabel", Conductor.INTERMEDIO));
//        listaPersonas.add(new Persona("16161616O", "Francisco", Conductor.PROFESIONAL));
//        listaPersonas.add(new Persona("17171717P", "Luis", Conductor.NOVEL));
//        listaPersonas.add(new Persona("18181818Q", "Raquel", Conductor.INTERMEDIO));
//        listaPersonas.add(new Persona("19191919R", "Alberto", Conductor.PROFESIONAL));
//        listaPersonas.add(new Persona("20202020S", "Eva", Conductor.NOVEL));
//        listaPersonas.add(new Persona("21212121T", "Roberto", Conductor.INTERMEDIO));

//                VEHÍCULOS
        listaVehiculos.add(new Coche("ABC123", 200, 1200));
        listaVehiculos.add(new Coche("DEF456", 120, 1000));
        listaVehiculos.add(new Coche("GHI789", 250, 1500));
        listaVehiculos.add(new Coche("JKL012", 150, 1100));
        listaVehiculos.add(new Moto("MNO345", 300, true));
        listaVehiculos.add(new Moto("PQR678", 150, false));
        listaVehiculos.add(new Moto("STU901", 200, true));
        listaVehiculos.add(new Moto("VWX234", 100, false));
        listaVehiculos.add(new Camion("YZA567", 220, true));
        listaVehiculos.add(new Camion("BCD890", 180, false));
        listaVehiculos.add(new Camion("EFG123", 250, true));
        listaVehiculos.add(new Camion("HIJ456", 190, false));
//        listaVehiculos.add(new Coche("KLM789", 180, 1300));
//        listaVehiculos.add(new Coche("NOP012", 100, 900));
//        listaVehiculos.add(new Coche("QRS345", 120, 1000));
//        listaVehiculos.add(new Coche("TUV678", 250, 1600));
//        listaVehiculos.add(new Moto("WXY901", 125, false));
//        listaVehiculos.add(new Moto("ZAB234", 200, true));
//        listaVehiculos.add(new Moto("CDE567", 100, false));
//        listaVehiculos.add(new Moto("FGH890", 160, true));
//        listaVehiculos.add(new Camion("IJK123", 200, true));
//        listaVehiculos.add(new Camion("LMN456", 180, false));
//        listaVehiculos.add(new Camion("OPQ789", 250, true));
//        listaVehiculos.add(new Camion("RST012", 190, false));
//        listaVehiculos.add(new Coche("UVW345", 180, 1200));
//        listaVehiculos.add(new Coche("XYZ678", 100, 950));
//        listaVehiculos.add(new Coche("123ABC", 120, 1000));
//        listaVehiculos.add(new Coche("456DEF", 250, 1700));
//        listaVehiculos.add(new Moto("789GHI", 200, false));
//        listaVehiculos.add(new Moto("JKL012", 125, true));
//        listaVehiculos.add(new Moto("345MNO", 150, false));
//        listaVehiculos.add(new Moto("678PQR", 160, true));
//        listaVehiculos.add(new Camion("901STU", 220, true));
//        listaVehiculos.add(new Camion("234VWX", 180, false));
//        listaVehiculos.add(new Camion("567YZA", 250, true));
//        listaVehiculos.add(new Camion("890BCD", 190, false));

        listarVehiculos(listaVehiculos);

        listarPersonas(listaPersonas);

        opcionesConductor(key,listaPersonas,listaVehiculos);


    }
}
