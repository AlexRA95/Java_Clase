package repasoAgregacion;

import java.util.Objects;

public class Jugador {

    private int LICENCIA;
    private String nombre;

    private static int contLicencia=0;

    public Jugador(String nombre) {
        this.LICENCIA = ++contLicencia;
        this.nombre = nombre;
    }

    public Jugador(int LICENCIA) {
        this.LICENCIA = LICENCIA;
    }

    public int getLICENCIA() {
        return LICENCIA;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador jugador)) return false;
        return getLICENCIA() == jugador.getLICENCIA();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLICENCIA());
    }

    @Override
    public String toString() {
        return "Jugador "+ nombre + ' ' ;
    }
}
