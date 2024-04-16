package electronica;

import java.util.Objects;

public class Producto {
    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
    private static int idCont=0;
    private TipoProducto tipoProducto;

    public Producto(TipoProducto tipoProducto, String marca, String modelo, double precio, int stock) {
        this.id = ++idCont;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.tipoProducto = tipoProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(marca, producto.marca) && Objects.equals(modelo, producto.modelo) && tipoProducto == producto.tipoProducto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, tipoProducto);
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
