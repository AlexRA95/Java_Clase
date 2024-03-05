package delorean;

public class Puerta {

    private boolean abierta;
    private Ventana ventana;

    public Puerta() {
        abierta = false;
        ventana = new Ventana();
    }

    public void abrirCerrarPuerta(){
        abierta= !abierta;
        System.out.printf("\nLa puerta se ha %S\n",(abierta)?"abierto":"cerrado");
    }

    public void subirBajarVentana(){
        if (ventana.isSubida()){
            ventana.bajar();
        }else {
            ventana.subir();
        }
    }

}
