package parque_de_bomberos;

public class Bombero {

    private int idBombero;
    private static int idcont=0;
    private String nombreCompleto;
    private int edad;
    private Rango rango;

    public Bombero(String nombreCompleto, int edad, Rango rango){
        this.idBombero=++idcont;
        this.nombreCompleto=nombreCompleto;
        this.edad=edad;
        this.rango=rango;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public Rango getRango() {
        return rango;
    }

    public int getIdBombero() {
        return idBombero;
    }

    @Override
    public String toString() {
        return "\nID: " + idBombero + "\nNOMBRE COMPLETO: " + nombreCompleto + "\nEDAD: " + edad + "\nRANGO: " + rango;
    }
}
