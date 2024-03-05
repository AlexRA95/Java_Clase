package delorean;

public class Ventana {

    private boolean subida;

    public Ventana() {
        subida = true;
    }

    public void subir(){
        if (subida){
            System.out.println("La ventana ya está subida");
        }else {
            System.out.println("Se ha subido la ventana");
            subida=true;
        }
    }

    public void bajar(){
        if (!subida){
            System.out.println("La ventana ya está bajada");
        }else {
            System.out.println("Se ha bajado la ventana");
            subida=false;
        }
    }

    public boolean isSubida(){return subida;}

}
