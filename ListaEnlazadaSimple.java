/**
 * Clase ListaEnlazadaSimple.
 * Implementa una lista enlazada simple de tickets utilizando nodos
 * (NodoTicket). Se usa para almacenar los tickets ya resueltos, permitiendo
 * insertarlos al final, buscarlos por ID y mostrarlos en pantalla.
 */
public class ListaEnlazadaSimple {

    //Atributos.
    private NodoTicket primero;

    //Constructor.
    // Crea una lista enlazada vacia.
    public ListaEnlazadaSimple() {
        this.primero = null;
    }

    //Métodos.
    // Inserta un ticket al final de la lista.
    public void insertarNodoFinal(Ticket ticket) {
        NodoTicket nuevoNodo = new NodoTicket(ticket);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            NodoTicket actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    // Busca un ticket por su ID, o devuelve null si no existe.
    public Ticket buscarNodo(int id) {
        NodoTicket actual = primero;
        while (actual != null) {
            if (actual.getTicket().getId() == id) {
                return actual.getTicket();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Muestra en pantalla todos los tickets de la lista.
    public void mostrarLista() {
        if (primero == null) {
            System.out.println("La lista de tickets resueltos esta vacia.\n");
            return;
        }
        NodoTicket actual = primero;
        while (actual != null) {
            System.out.println(actual.getTicket().toString() + "\n");
            actual = actual.getSiguiente();
        }
    }
}
