import java.util.ArrayList;

public class ColaPrioridad {

    //Atributos.
    private ArrayList<Ticket> cola;

    //Constructor.
    public ColaPrioridad() {
        this.cola = new ArrayList<Ticket>();
    }

    //Métodos.
    public void insertar(Ticket ticket) {
        cola.add(ticket);
    }

    public Ticket remover() {
        if (cola.isEmpty()) {
            return null;
        }
        return cola.remove(0);
    }

    public Ticket verFrente() {
        if (cola.isEmpty()) {
            return null;
        }
        return cola.get(0);
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }
}
