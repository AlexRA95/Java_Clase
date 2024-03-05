package alquiler_de_juegos;

public class Pelicula {
    private int idPelicula;
    int idCont=0;
    private String titulo, nombreDirector;
    private Categoria categoria;

    public Pelicula(String titulo, String nombreDirector, Categoria categoria) {
        this.idPelicula = ++idCont;
        this.titulo = titulo;
        this.nombreDirector = nombreDirector;
        this.categoria = categoria;
    }
}
