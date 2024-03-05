import java.util.Objects;

public class Usuario {

    private final String nombre;
    private String correo;
    private Rol rol;
    private boolean disponible;

    public Usuario(String nombre, String correo, Rol rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.disponible = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public Rol getRol() {
        return rol;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void cambiarDisponible(){
        if (this.disponible){
            this.disponible=false;
        }else {
            this.disponible=true;
        }
    }

    @Override
    public String toString() {
        return " Nombre= " + nombre +
                " Rol= " + rol +
                " Disponible= " + (disponible?"SI":"No") + "\n";
    }

    public String getNombre() {
        return nombre;
    }
}
