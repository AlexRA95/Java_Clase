import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Proyecto {

    private String nombre;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Tarea> tareaProceso, tareaAcabada;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        tareaProceso=new ArrayList<>();
        tareaAcabada=new ArrayList<>();
        usuarios= new ArrayList<>();
    }

    public void setUsuarios(List<Usuario> lista){
        for (Usuario u: lista){
            if (this.usuarios.isEmpty()){
                this.usuarios.add(u);
            } else if (!this.usuarios.contains(u)){
                this.usuarios.add(u);
            }

        }
    }

    public boolean crearTarea(Tarea tarea){
        boolean error;
        if (this.tareaProceso.contains(tarea)){
            System.out.println("ERROR: ESTA TAREA YA ESTÁ EN PROCESO");
            return false;
        }else {
            Rol perfil=null;
            switch (tarea.getTipo()){
                case NUEVO_DESARROLLO, MANTENIMIENTO -> {
                    perfil=Rol.DESARROLLADOR;
                }
                case PRUEBAS -> {
                    perfil=Rol.TESTER;
                }
                case ANALISIS -> {
                    perfil=Rol.ARQUITECTO_SOFTWARE;
                }
                case AUDITORIA -> { perfil=Rol.PRODUCT_OWNER;}
            }
            for (Usuario u: usuarios){
                if ((u.getRol()==perfil) && u.isDisponible()){
                    u.cambiarDisponible();
                    tarea.setFecha_asignacion(LocalDate.now());
                    tarea.addUser(u);
                    tareaProceso.add(tarea);
                    System.out.println("TAREA " + tarea.getId()+ " :" + tarea.getNombre() + " de tipo " +  tarea.getTipo() + "Fecha asignacion: " + tarea.getUserAsignado() + " .Usuario " + tarea.getUserAsignado().getRol() + " " + tarea.getUserAsignado().getNombre());
                    return true;
                }else {
                    System.out.println("ERROR. No hay recursos disponibles.");

                }
            }
        }
        return false;
    }

    public void mostrarUsuarios(){
        System.out.println("LISTA DE USUARIOS: ");
        for (Usuario u: this.usuarios){
            System.out.print("USUARIO ");
            System.out.println(u.toString());
        }
    }

    public void mostrarTareasEnProceso(){
        DateTimeFormatter f= DateTimeFormatter.ofPattern("dd MM yyyy");
        for (Tarea t: tareaProceso){
            System.out.println("Tarea " + t.getId() + ": " + t.getNombre() + " de tipo " + t.getTipo() + ". Fecha de asignación: " +  f.format(t.getFecha_asignacion()) + ". Usuario " + t.getUserAsignado().getRol() + " " + t.getUserAsignado().getNombre());
        }
    }

    public void mostrarTareasFinalizadas(){
        DateTimeFormatter f= DateTimeFormatter.ofPattern("dd MM yyyy");

        for (Tarea t: tareaProceso){
            LocalDateTime venc= LocalDateTime.of(t.getFecha_vencimiento(), LocalTime.of(0,0));
            LocalDateTime fin= LocalDateTime.of(t.getFecha_fin(), LocalTime.of(0,0));
            long dias= Duration.between(venc,fin).toDays();
            System.out.println("Tarea " + t.getId() + ": " + t.getNombre() + " de tipo " + t.getTipo() + ".\n Fecha de vencimiento: " + f.format(t.getFecha_vencimiento()) + ". Fecha de finalización: " + f.format(t.getFecha_fin()) + ". Días de adelanto: " + dias + ". Usuario " + t.getUserAsignado().getRol() + " " + t.getUserAsignado().getNombre());
        }
    }

    public void finalizarTarea(int id){
            Iterator<Tarea> iter= tareaProceso.iterator();
            boolean borrada=false;
            while (iter.hasNext()){
                Tarea t =iter.next();
                if (t.getId()==id){
                    t.getUserAsignado().cambiarDisponible();
                    t.setFecha_fin(LocalDate.now());
                    tareaAcabada.add(t);
                    if (t.getFecha_fin().isBefore(t.getFecha_vencimiento())){
                        System.out.println("La tarea se ha acabado fuera de plazo.");
                    }else{
                        System.out.println("La tarea se ha acabado en plazo");
                    }
                    iter.remove();
                    borrada=true;
                }
            }
            if (!borrada){
                System.out.println("La tarea no existe.");
            }
    }



}
