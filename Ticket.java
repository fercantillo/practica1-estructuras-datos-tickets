import java.time.LocalDate;

public class Ticket {

    //Atributos.
    private static int cantidad = 0;
    private int id;
    private String descripcion;
    private String nombreCompleto;
    private String fechaCreacion;
    private String fechaResolucion;

    //Constructor.
    public Ticket(String descripcion, String nombreCompleto) {
        this.id = ++cantidad;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = LocalDate.now().toString();
        this.fechaResolucion = null;
    }

    //Getters.
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    //Setters.
    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    //Métodos.
    @Override
    public String toString() {
        return "Ticket [id=" + id + ", descripcion=" + descripcion + ", nombreCompleto=" + nombreCompleto + ", fechaCreacion=" + fechaCreacion + ", fechaResolucion=" + fechaResolucion + "]";
    }
}
