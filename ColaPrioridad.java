/**
 * Clase ColaPrioridad.
 * Implementa una cola de prioridad de tickets usando nodos enlazados
 * (NodoTicket) en lugar de estructuras predefinidas. Los tickets se mantienen
 * ordenados de mayor a menor prioridad, donde un numero de prioridad menor
 * indica una mayor urgencia de atencion. El frente de la cola (atributo
 * 'primero') siempre apunta al ticket mas prioritario.
 */
public class ColaPrioridad {

    //Atributos.
    private NodoTicket primero;

    //Constructor.
    // Crea una cola de prioridad vacia.
    public ColaPrioridad() {
        this.primero = null;
    }

    //Métodos.
    // Inserta un ticket manteniendo la cola ordenada por prioridad.
    public void insertar(Ticket ticket) {
        NodoTicket nuevoNodo = new NodoTicket(ticket);

        if (primero == null || ticket.getPrioridad() < primero.getTicket().getPrioridad()) {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
            return;
        }

        NodoTicket actual = primero;
        while (actual.getSiguiente() != null
                && actual.getSiguiente().getTicket().getPrioridad() <= ticket.getPrioridad()) {
            actual = actual.getSiguiente();
        }

        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
    }

    // Remueve y devuelve el ticket al frente de la cola, o null si esta vacia.
    public Ticket remover() {
        if (primero == null) {
            return null;
        }
        Ticket ticketFrente = primero.getTicket();
        primero = primero.getSiguiente();
        return ticketFrente;
    }

    // Devuelve el ticket al frente de la cola sin removerlo, o null si esta vacia.
    public Ticket verFrente() {
        if (primero == null) {
            return null;
        }
        return primero.getTicket();
    }

    // Indica si la cola no contiene tickets.
    public boolean estaVacia() {
        return primero == null;
    }
}
