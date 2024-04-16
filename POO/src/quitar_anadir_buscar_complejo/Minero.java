package quitar_anadir_buscar_complejo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Minero extends Trabajador{
    private TipoMineral tipoMineral;

    public Minero(String nombre, LocalDate fechaNacimiento, TipoMineral tipoMineral) {
        super(nombre, fechaNacimiento);
        this.tipoMineral = tipoMineral;
    }

    public Minero(String nombre){
        super(nombre,LocalDate.now());
    }

    @Override
    public void imprimir() {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd'/'MMM'/'yyyy");
        System.out.printf("%-25s %-25s %-25s %d \n",getNombre(),getFechaNacimiento().format(formatter),getTipoMineral(),getId());
    }

    public TipoMineral getTipoMineral() {
        return tipoMineral;
    }
}
