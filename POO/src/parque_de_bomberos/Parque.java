package parque_de_bomberos;

import java.util.ArrayList;

public class Parque {
    private int idParque;
    private static int idcont=0;
    private String ubicacion;
    private ArrayList<Bombero> bomberos= new ArrayList<>();
    private Bombero jefeParque;
    private static String [] avisos= new String[] {"1. Gato subido a un arbol.", "2. Incendio en pisos al sur.", "3. Persona encerrada en baño."};


    public Parque(String ubicacion){
        this.idParque=++idcont;
        this.ubicacion=ubicacion;
    }

    public void agregarBombero(String nombreCompleto, int edad, Rango rango){
        this.bomberos.add(new Bombero(nombreCompleto,edad,rango));
        this.jefeParque=getJefeParque(this.bomberos);
    }


    public void listarPersonal(){
        for (Bombero b: bomberos
             ) {
            System.out.println(b.toString());
        }
    }

    @Override
    public String toString() {
        return "ID: " + idParque +
                "\nUbicacion: " + ubicacion +
                "\nJefe Parque: " + jefeParque.getNombreCompleto();
    }

    private Bombero getJefeParque(ArrayList<Bombero> lista){
        Bombero salida=lista.get(0);
        for (Bombero b: bomberos
             ) {
                if (salida.getRango().getCalidad()<=b.getRango().getCalidad()){
                    if (salida.getRango().getCalidad()==b.getRango().getCalidad()){
                        if (salida.getEdad()<b.getEdad()){
                            salida=b;
                        }
                    }else {
                        salida=b;
                    }
                }
        }
        return salida;
    }

    public static void sacarAvisos(){
        for (String s: avisos
             ) {
            System.out.println(s);
        }
    }

    public int getIdParque() {
        return idParque;
    }
}
