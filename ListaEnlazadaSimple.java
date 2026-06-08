public class ListaEnlazadaSimple {

    //Atributos.
    private NodoTicket primero;

    //Constructor.
    public ListaEnlazadaSimple() {
        this.primero = null;
    }

    //Métodos.
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
