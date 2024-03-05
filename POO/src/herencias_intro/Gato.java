package herencias_intro;

public class Gato extends Animal{
    private String color;

    public Gato(String nombre, int edad, String color) {
        super(nombre, edad);
        this.color = color;
    }

    @Override
    public void hablar(){
        System.out.println("El gato hace miau");
    }

    @Override
    public String toString() {
        return "Gato{" +
                "color='" + color + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
