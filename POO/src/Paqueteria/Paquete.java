package Paqueteria;

import java.time.LocalDate;

public class Paquete {

    private Integer id;
    private static int idCont=0;
    private Destinatario d;
    private LocalDate fechaEntrega;
    private Modalidad prisa;

    public Paquete(String nombreDes, String ubiDes) {
        this.id = idCont++;
        this.d=new Destinatario(nombreDes,ubiDes);
    }

    public void setPrisa(Modalidad prisa) {
        switch (prisa){
            case URGENTE -> {
                this.fechaEntrega=LocalDate.now().plusDays(2);
            }
            case MUY_URGENTE -> {
                this.fechaEntrega=LocalDate.now().plusDays(1);
            }
            default -> {
                this.fechaEntrega=LocalDate.now().plusDays(3);
            }

        }
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "id=" + id + "\n" +
                "d=" + d + "\n" +
                "fechaEntrega=" + fechaEntrega + "\n" +
                "prisa=" + prisa ;
    }
}
