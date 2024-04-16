package Ejercicios.A5;

public class NumPositivoEx extends Exception{
    private final int n;

    public NumPositivoEx(int n) {
        this.n = n;
    }

    private void NumPositivo(int p) throws NumPositivoEx {
        if (p<0){
            throw new NumPositivoEx(p);
        }
    }

    @Override
    public String toString() {
        return "El numero " + n + " es negativo y tiene que ser positivo.";
    }
}
