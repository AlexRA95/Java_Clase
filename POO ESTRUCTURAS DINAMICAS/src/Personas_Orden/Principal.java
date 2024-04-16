package Personas_Orden;

import java.util.*;

public class Principal {
    public static void main(String[] args) {

        Set<Persona> personas=new HashSet<>();
        //Para ordenar un TreeSet también se puede hacer esto-->
        //Comparator<Persona> ordenador=Comparator.comparing(Persona::getEdad).reversed();
        //Set<Persona> personasTree=new TreeSet<>(ordenador);
        //Set<Persona> personasTree=new TreeSet<>(new PorEdad());
        //Set<Persona> personasTree=new TreeSet<>();
        //Set<Persona> personasLinked=new LinkedHashSet<>();

        Map<String, Persona> tutores=new HashMap<>();

        Persona p1=new Persona("Ana",25,1.86);
        Persona p2=new Persona("Rosa",20,1.86);
        Persona p3=new Persona("Antonio",19,1.86);
        Persona p4=new Persona("Juan",25,1.86);
        //Persona p5=new Persona("Ana",25,1.86);

        tutores.put("DAM-B",p3);
        tutores.put("DAM-A",p2);
        tutores.put("DAW-B",p1);
        tutores.put("DAW-A",p4);
        tutores.replace("DAW-A",p1);

        //Iterar sobre claves
        System.out.println("Iterar sobre claves");
        for (String clave : tutores.keySet()){
            System.out.println(clave + " ");
            System.out.println(tutores.get(clave));

        }

        System.out.println("Iterar sobre valores");
        for (Persona p: tutores.values()){
            System.out.println(p);
        }

        System.out.println("Iterar sobre entradas");
        for (Map.Entry<String, Persona> entrada: tutores.entrySet()){
            System.out.println(entrada.getKey() + " ");
            System.out.println(entrada.getValue());
        }

/*
        personas.add(p1);personasTree.add(p1);personasLinked.add(p1);
        personas.add(p2);personasTree.add(p2);personasLinked.add(p2);
        personas.add(p3);personasTree.add(p3);personasLinked.add(p3);
        personas.add(p4);personasTree.add(p4);personasLinked.add(p4);


        //No se ordena
        System.out.println("HASSET: ");
        for (Persona i: personas){
            System.out.printf(i.toString());
            System.out.println();
        }
        System.out.println();

        //Se ordena
        System.out.println("TREE: ");
        for (Persona i: personasTree){
            System.out.printf(i.toString());System.out.println();

        }
        System.out.println();

        //Orden de inserción
        System.out.println("Linked: ");
        for (Persona i: personasLinked){
            System.out.printf(i.toString());System.out.println();
        }
        System.out.println();
        */
    }

}
