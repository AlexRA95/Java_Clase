package electronica;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> lista;

    public Inventario() {
        this.lista = new ArrayList<>();
    }

    public void addInven(TipoProducto tipoProducto, String marca, String modelo, double precio, int stock){
        if (lista.contains(new Producto(tipoProducto, marca, modelo, precio, stock))){
            System.out.println("Este producto ya existe, se sumará el stock al stock anterior.");
            for (Producto p: lista){
                if (p.equals(new Producto(tipoProducto, marca, modelo, precio, stock))){
                    p.setStock(stock);
                }
            }
        } else {
            lista.add(new Producto(tipoProducto, marca, modelo, precio, stock));
        }
    }
}
