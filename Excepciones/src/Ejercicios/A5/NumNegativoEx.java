package Ejercicios.A5;

public class NumNegativoEx extends Exception{

    private final int n;

    public NumNegativoEx(int n) {
        this.n = n;
    }

    private void NumNegativo(int p) throws NumNegativoEx {
        if (p>=0){
            throw new NumNegativoEx(p);
        }
    }

    @Override
    public String toString() {
        return "El numero " + n + " es positivo y tiene que ser negativo.";
    }

}
