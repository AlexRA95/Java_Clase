package Gimnasio;

public class Afiliado extends  Persona{

    private int nAfiliado;
    private int sesionesBono;

    public Afiliado(String nombre, String dni, int edad, int nAfiliado) {
        super(nombre, dni, edad);
        this.nAfiliado = nAfiliado;
        this.sesionesBono=0;
    }

    public void cargarBono(int precio){
        if (precio>=Bono.EURO30.getPrecio()){
            this.sesionesBono+=Bono.EURO30.getSesiones();
        }if (precio>=Bono.EURO25.getPrecio()){
            this.sesionesBono+=Bono.EURO25.getSesiones();
        }if (precio>=Bono.EURO20.getPrecio()){
            this.sesionesBono+=Bono.EURO20.getSesiones();
        }else {
            System.out.println("Con ese dinero no puedes pagar un bono");
        }
    }

    public void entrenar(){
        sesionesBono--;
    }
}
