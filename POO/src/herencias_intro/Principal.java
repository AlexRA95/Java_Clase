package herencias_intro;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Animal vaca=new Animal("Lucera", 5);
        Perro perro=new Perro("Sultan", 3, Razas.CHIGUAGUA);
        Gato gato= new Gato("Lucas", 6, "Blanco");

        ArrayList<Animal> lista=new ArrayList<>();
        lista.add(vaca);
        lista.add(perro);
        lista.add(gato);

        for (Animal a: lista){
            if (a instanceof Gato) {
                System.out.println(a.toString());
                a.hablar();
            }
        }
    }
}
