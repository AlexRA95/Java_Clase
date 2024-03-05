package herencias_intro;

public class Animal {

    protected String nombre;
    protected int edad;
    

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void hablar(){
        System.out.println("El animal emite un sonido");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
