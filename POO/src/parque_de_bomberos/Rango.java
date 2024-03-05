package parque_de_bomberos;

public enum Rango {
    BOMBERO(1),CABO(2),SUBOFICIAL(3),OFICIAL(4);

    private int calidad;

    Rango(int calidad) {
        this.calidad = calidad;
    }

    public int getCalidad() {
        return calidad;
    }
}
