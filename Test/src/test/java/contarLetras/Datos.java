package contarLetras;

public class Datos {

    private String cadena;
    private int resul;

    public Datos(String cadena, int resul) {
        this.cadena = cadena;
        this.resul = resul;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getResul() {
        return resul;
    }

    public void setResul(int resul) {
        this.resul = resul;
    }
}
