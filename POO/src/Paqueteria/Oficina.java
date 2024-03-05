package Paqueteria;

import java.util.ArrayList;
import java.util.Objects;

public class Oficina {

    private final Integer id;
    private static int idCont=0;
    private final String ubicacion;
    private ArrayList<Paquete> paquetes=new ArrayList<>();

    public Oficina(String ubicacion) {
        this.id = idCont++;
        this.ubicacion = ubicacion;
    }

    public void addPaquete(Paquete p){
        this.paquetes.add(p);
    }

    public void prio(Modalidad prio, Integer id){
        for (Paquete p: paquetes){
            if (Objects.equals(p.getId(), id)){
                p.setPrisa(prio);
            }
        }
    }

    public void prisaPaquete(Integer id){
        for (Paquete p: paquetes){
            if (Objects.equals(p.getId(), id)){
                System.out.println(p.toString());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oficina oficina)) return false;
        return Objects.equals(id, oficina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
