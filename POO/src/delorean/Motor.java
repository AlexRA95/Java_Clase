package delorean;

public class Motor {

    private boolean encendido;

    public Motor(){
        encendido=false;
    }

    public void encender(){
        if (encendido){
            System.out.println("El motor ya está encendido.");
        }else {
            System.out.println("Se ha encendido el motor.");
            encendido=true;
        }
    }

    public void apagar(){
        if (encendido){
            System.out.println("Se ha apagado el motor");
            encendido=false;
        }else {
            System.out.println("El motor ya está apagado.");
        }
    }

    public boolean isEncendido() {
        return encendido;
    }
}
