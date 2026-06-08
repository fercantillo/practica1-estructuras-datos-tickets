/**
 * Clase NodoTicket.
 * Representa un nodo de una estructura enlazada simple. Cada nodo almacena un
 * Ticket y una referencia al siguiente nodo de la estructura. Es utilizado
 * tanto por ListaEnlazadaSimple como por ColaPrioridad.
 */
public class NodoTicket {

    //Atributos.
    private Ticket ticket;
    private NodoTicket siguiente;

    //Constructor.
    // Crea un nodo que contiene el ticket dado y sin nodo siguiente.
    public NodoTicket(Ticket ticket) {
        this.ticket = ticket;
        this.siguiente = null;
    }

    //Getters.
    // Devuelve el ticket almacenado en el nodo.
    public Ticket getTicket() {
        return ticket;
    }

    // Devuelve la referencia al siguiente nodo.
    public NodoTicket getSiguiente() {
        return siguiente;
    }

    //Setters.
    // Asigna el ticket almacenado en el nodo.
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // Asigna la referencia al siguiente nodo.
    public void setSiguiente(NodoTicket siguiente) {
        this.siguiente = siguiente;
    }
}
