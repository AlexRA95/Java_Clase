package Ejercicios.A6;

public class GatoEdadEx extends Exception{
    private int edad;

    public GatoEdadEx(int edad) {
        this.edad = edad;
    }

    private void GatoEdadCorrecto(int edad) throws GatoEdadEx {
        if (edad<0){
            throw new GatoEdadEx(edad);
        }
    }

    @Override
    public String toString() {
        return "El gato con edad " + edad + ", no puede tener edad negativa.";
    }
}
