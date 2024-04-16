package Nestle;

import java.time.LocalDate;

public class Chocolate extends Producto{
    private Formato formato;
    private TipoChocolate tipoChocolate;
    private LocalDate caducidad;

    public Chocolate(String nombre, double ppu, Formato formato, TipoChocolate tipoChocolate, LocalDate caducidad) {
        super(nombre, ppu);
        this.formato = formato;
        this.tipoChocolate = tipoChocolate;
        this.caducidad = caducidad;
    }
}
