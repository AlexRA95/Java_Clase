public enum TipoTaza {
    SHORT(200), TALL(300), GRANDE(450), VENTI(675), TRENTA(900);
    private int cantidad;

    TipoTaza(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
}
