package Ejercicios.A6;

public class GatoNombreEx extends Exception{

    private String nombre;

    public GatoNombreEx(String nombre) {
        this.nombre = nombre;
    }

    private void GatoNombreCorrecto(String nombre) throws GatoNombreEx {
        if (nombre.length()<=3){
            throw new GatoNombreEx(nombre);
        }
    }

    @Override
    public String toString() {
        return "El nombre del gato " + nombre + " es demasiado corto, tiene que tener una longitud mayor a 3.";
    }
}
