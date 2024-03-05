import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Proyecto proyecto = new Proyecto("PRUEBA_DAW");

        Usuario usuario1 = new Usuario("carlos01", "carlos@daw.com", Rol.DESARROLLADOR);
        Usuario usuario2 = new Usuario("laura03", "laura@daw.com", Rol.TESTER);
        Usuario usuario3 = new Usuario("javier01", "javier@daw.com", Rol.ARQUITECTO_SOFTWARE);
        Usuario usuario4 = new Usuario("maria02", "maria@daw.com", Rol.PRODUCT_OWNER);
        Usuario usuario5 = new Usuario("diego06", "diego@daw.com", Rol.DESARROLLADOR);
        Usuario usuario6 = new Usuario("elena04", "elena@daw.com", Rol.TESTER);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        usuarios.add(usuario5);
        usuarios.add(usuario6);
        proyecto.setUsuarios(usuarios);

        // Comenzamos las pruebas
        System.out.println("\n===== PRUEBA CREAR TAREA =====");
        Tarea tareaA = new Tarea("Implementar función de login", Tipo.NUEVO_DESARROLLO, LocalDate.of(2024, 1, 6));
        Tarea tareaB = new Tarea("Optimización de consultas SQL", Tipo.ANALISIS, LocalDate.of(2023, 12, 8));
        Tarea tareaC = new Tarea("Realizar auditoría de seguridad", Tipo.AUDITORIA, LocalDate.of(2024, 2, 13));
        Tarea tareaD = new Tarea("Desarrollar función de exportación de datos", Tipo.NUEVO_DESARROLLO, LocalDate.of(2023, 11, 6));
        Tarea tareaE = new Tarea("Pruebas de integración", Tipo.PRUEBAS, LocalDate.of(2024, 3, 10));
        Tarea tareaF = new Tarea("Corregir errores reportados", Tipo.MANTENIMIENTO, LocalDate.of(2024, 5, 24));

        System.out.println("Insertamos varias tareas: ");
        proyecto.crearTarea(tareaA);
        proyecto.crearTarea(tareaB);
        proyecto.crearTarea(tareaC);

        proyecto.mostrarUsuarios();

        System.out.print("\nInsertamos una tarea repetida: ");
        Tarea tareaACopia = new Tarea("Implementar función de login", Tipo.NUEVO_DESARROLLO, LocalDate.of(2024, 1, 6));
        proyecto.crearTarea(tareaA);

        System.out.println("\nInsertamos algunas tareas más:");
        proyecto.crearTarea(tareaD);
        proyecto.crearTarea(tareaE);

        System.out.print("\nInsertamos una tarea para la que no hay trabajadores suficientes: ");
        proyecto.crearTarea(tareaF);

        proyecto.mostrarUsuarios();
        //proyecto.mostrarTareasEnProceso();

        System.out.println("\n===== PRUEBA FINALIZAR TAREA =====");

        System.out.print("Finalizamos una tarea que no existe: ");
        proyecto.finalizarTarea(9);

        System.out.print("Finalizamos la tarea 4: ");
        proyecto.finalizarTarea(4);

        System.out.print("Finalizamos la tarea 1: ");
        proyecto.finalizarTarea(1);

        System.out.print("Finalizamos la tarea 5: ");
        proyecto.finalizarTarea(5);

        System.out.print("Volvemos a finalizar la tarea 5: ");
        proyecto.finalizarTarea(5);

        proyecto.mostrarUsuarios();
        proyecto.mostrarTareasEnProceso();
        proyecto.mostrarTareasFinalizadas();

    }
}