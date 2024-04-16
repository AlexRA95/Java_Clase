package Ejercicios.A7;

public class Gato {
    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) throws GatoNombreEx, GatoEdadEx {
        if (nombre.length()<3){
            throw new GatoNombreEx(nombre);
        } else if (edad<0) {
            throw new GatoEdadEx(edad);
        }
        this.nombre = nombre;
        this.edad = edad;
    }

    public void imprimir(){
        System.out.println("El gato se llama " + nombre + " y tiene una edad de " + edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws GatoNombreEx {
        if (nombre.length()<3){
            throw new GatoNombreEx(nombre);
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws GatoEdadEx {
        if (edad<0) {
            throw new GatoEdadEx(edad);
        }
        this.edad = edad;
    }
}
