package herencias_intro;

public class Perro extends Animal{

    private Razas raza;

    public Perro(String nombre, int edad, Razas raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    @Override
    public void hablar(){
        System.out.println("El perro hace guau");
    }

    @Override
    public String toString() {
        return "Perro{" +
                "raza=" + raza +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
