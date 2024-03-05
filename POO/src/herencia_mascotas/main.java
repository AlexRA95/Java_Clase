package herencia_mascotas;

import java.time.LocalDate;

public class main {

    public static void main(String[] args) {
        Inventario lista=new Inventario();
        lista.anadir(new Perro("Pepe", 5, LocalDate.now(),"Lel"));
        lista.anadir(new Gato("za",14,LocalDate.now(),"Naranja", true));
        lista.anadir(new Loro("xd",7,LocalDate.now(),"negro","Turkia"));
        lista.anadir(new Canario("lol",55,LocalDate.now(),"blanco","amarillo", true));

        lista.listaSimple();
        System.out.println(" ");

        lista.listaCompleta();
        System.out.println(" ");

        lista.listaTipo("loro");
        System.out.println(" ");


        lista.borrar("perro","Pepe");

        lista.listaSimple();
        System.out.println(" ");

        lista.vaciar();




    }

}
