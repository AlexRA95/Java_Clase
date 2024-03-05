package Gimnasio;

public class Monitor extends Persona{

    private int experiencia;
    private Seccion seccion;

    public Monitor(String nombre, String dni, int edad, int experiencia) {
        super(nombre, dni, edad);
        this.experiencia = experiencia;
    }

    public void entrenar(){
        experiencia++;
    }

    public void notiIncidencia(String desc){
        seccion.addIncidencia(desc);
    }
}
