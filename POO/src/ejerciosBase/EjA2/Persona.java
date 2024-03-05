package ejerciosBase.EjA2;

public class Persona {
    private final String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private static final int mayoriaEdad = 18;

    public Persona(String dni, String nombre, String apellido, int edad) {
        if (validarDNI(dni)){
            this.dni = dni;
        }else {
            System.err.println("DNI NO VALIDO");
            this.dni = null;
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void imprime() {
        System.out.printf("\nDNI: %s\n", this.dni);
        System.out.printf("\nNombre: %s\n", this.nombre);
        System.out.printf("\nApellido: %s\n", this.apellido);
        System.out.printf("\nEdad: %d\n", this.edad);
    }

    public boolean esMayorEdad() {
        Boolean mayor;

        if (this.edad < mayoriaEdad) {
            mayor = false;
        } else {
            mayor = true;
        }
        return mayor;
    }

    public boolean esJubilado() {
        Boolean jubilado;

        if (this.edad < 65) {
            jubilado = false;
        } else {
            jubilado = true;
        }
        return jubilado;
    }


    public int diferenciaEdad(int edad) {


        return this.edad - edad;

    }

    public static boolean validarDNI(String dni) {
        Boolean esValido;

        if (dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            esValido = true;
        } else {
            esValido = false;
        }

        return esValido;

    }


}
