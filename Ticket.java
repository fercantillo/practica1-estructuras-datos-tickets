import java.time.LocalDate;

/**
 * Clase Ticket.
 * Representa un ticket de soporte dentro del sistema de gestion.
 * Almacena los datos del problema reportado, el solicitante, la prioridad
 * de atencion y las fechas de creacion y resolucion del ticket.
 */
public class Ticket {

    //Atributos.
    private static int cantidad = 0;
    private int id;
    private String descripcion;
    private String nombreCompleto;
    private int prioridad;
    private LocalDate fechaCreacion;
    private LocalDate fechaResolucion;

    //Constructor.
    // Crea un ticket con ID automatico, fecha de creacion actual y sin resolver.
    public Ticket(String descripcion, String nombreCompleto, int prioridad) {
        this.id = ++cantidad;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.prioridad = prioridad;
        this.fechaCreacion = LocalDate.now();
        this.fechaResolucion = null;
    }

    //Getters.
    // Devuelve el ID del ticket.
    public int getId() {
        return id;
    }

    // Devuelve la descripcion del problema.
    public String getDescripcion() {
        return descripcion;
    }

    // Devuelve el nombre completo del solicitante.
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    // Devuelve la prioridad del ticket.
    public int getPrioridad() {
        return prioridad;
    }

    // Devuelve la fecha de creacion del ticket.
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    // Devuelve la fecha de resolucion del ticket.
    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    //Setters.
    // Asigna el ID del ticket.
    public void setId(int id) {
        this.id = id;
    }

    // Asigna la descripcion del problema.
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Asigna el nombre completo del solicitante.
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    // Asigna la prioridad del ticket.
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    // Asigna la fecha de creacion del ticket.
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // Asigna la fecha de resolucion del ticket.
    public void setFechaResolucion(LocalDate fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    //Métodos.
    // Devuelve una representacion en texto del ticket.
    @Override
    public String toString() {
        return "Ticket [id=" + id + ", descripcion=" + descripcion + ", nombreCompleto=" + nombreCompleto
                + ", prioridad=" + prioridad
                + ", fechaCreacion=" + fechaCreacion.toString()
                + ", fechaResolucion=" + (fechaResolucion == null ? "null" : fechaResolucion.toString()) + "]";
    }
}
