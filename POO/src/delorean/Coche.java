package delorean;

import java.util.ArrayList;

public class Coche {

    private String matricula;
    private Rueda []ruedas= new Rueda[4];
    private Puerta[] puertas = new Puerta[2];
    private Motor m;


    public Coche(){
        this.matricula="";
        for (int i = 0; i < 4; i++) {
            ruedas[i]=new Rueda();
        }
        for (int i = 0; i < 2; i++) {
            puertas[i]=new Puerta();
        }
        m=new Motor();
    }

    public Coche(String matricula){
        this.matricula=matricula;
        for (int i = 0; i < 4; i++) {
            ruedas[i]=new Rueda();
        }
        for (int i = 0; i < 2; i++) {
            puertas[i]=new Puerta();
        }
        ruedas[0].desinflar();
        m=new Motor();
    }

    public void  starStop(){
        int cont=0;
        for (Rueda r: ruedas
             ) {
            if (r.isInflada()){
                cont++;
            }
        }
        if (cont==4){
            if (m.isEncendido()){
                m.apagar();
            }else {
            m.encender();
            }
        }else {
            System.out.println("Hay " +(4-cont) +" rueda/s sin inflar" );
        }
    }

    public void reparar(){

        for (Rueda r: ruedas
             ) {
            if (r.isInflada()){
                System.out.println("Esta rueda está inflada.");
            }else {
                r.inflar();
                System.out.println("Se ha inflado una rueda.");
            }
        }
    }

    public void elevalunas(){

        if (!m.isEncendido()){
            System.out.println("No se pueden subir/bajar las ventanillas con el coche apagado");
        }else{
            for (Puerta p: puertas
                 ) {
                p.subirBajarVentana();
            }
        }
    }

    public void elevalunas(int puerta){

        if (!m.isEncendido()){
            System.out.println("No se pueden subir/bajar las ventanillas con el coche apagado");
        }else{
            if (puerta> puertas.length || puerta<=0){
                System.out.println("Esa ventana no existe.");
            }else {
                puertas[puerta-1].subirBajarVentana();
            }
        }
    }

}
