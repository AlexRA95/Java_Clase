package quitar_anadir_buscar_complejo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Panadero extends Trabajador{
    private String ciudad;

    public Panadero(String nombre, LocalDate fechaNacimiento, String ciudad) {
        super(nombre, fechaNacimiento);
        this.ciudad = ciudad;
    }

    @Override
    public void imprimir() {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd'/'MMM'/'yyyy");
        System.out.printf("%-25s %-25s %-25s %d \n",getNombre(),getFechaNacimiento().format(formatter),getCiudad(),getId());
    }

    public String getCiudad() {
        return ciudad;
    }
}
