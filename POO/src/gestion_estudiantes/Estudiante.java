package gestion_estudiantes;

public class Estudiante {

    private String nombre;
    private int edad;
    private static int idEstudiante=0;
    private  double[] notas= {0.0,0.0,0.0};

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        idEstudiante++;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public double[] getNotas() {
        return notas;
    }

    public void imprimir(){
        System.out.printf("\nID: %d, Nombre: %s, Edad: %d\n",idEstudiante,this.nombre,this.edad);
    }

    public void setNotas(Asignatura a,double nota){
        switch (a){
            case LLMM->{
                this.notas[0]=nota;
            }
            case BBDD->{
                this.notas[1]=nota;
            }
            case PROG->{
                this.notas[2]=nota;
            }
            default -> {
                System.err.println("Error.");
            }
        }
    }


}
