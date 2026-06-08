import java.time.LocalDate;
import java.util.Scanner;

/**
 * Clase Main.
 * Punto de entrada del Sistema de Gestion de Tickets. Presenta un menu por
 * consola con dos roles: usuario (crear tickets y buscar resueltos) y
 * administrador (ver y resolver tickets pendientes). Los tickets pendientes se
 * gestionan con una cola de prioridad y los resueltos con una lista enlazada.
 */
public class Main {

    // Metodo principal: controla el flujo del menu del sistema.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColaPrioridad colaPendientes = new ColaPrioridad();
        ListaEnlazadaSimple listaResueltos = new ListaEnlazadaSimple();
        int opcionPrincipal;

        do {
            System.out.println("=== SISTEMA DE GESTION DE TICKETS ===");
            System.out.println("1. Menu Usuario");
            System.out.println("2. Menu Administrador");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opcion: ");
            opcionPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (opcionPrincipal) {
                case 1:
                    int opcionUsuario;
                    do {
                        System.out.println("--- MENU USUARIO ---");
                        System.out.println("1. Crear ticket");
                        System.out.println("2. Buscar ticket resuelto por ID");
                        System.out.println("0. Volver al menu principal");
                        System.out.println("Ingrese su opcion: ");
                        opcionUsuario = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionUsuario) {
                            case 1:
                                System.out.println("Escriba la descripcion del problema: ");
                                String descripcion = scanner.nextLine();
                                System.out.println("Ingrese su nombre completo: ");
                                String nombreCompleto = scanner.nextLine();
                                int prioridad;
                                do {
                                    System.out.println("Ingrese la prioridad del ticket (0 = maxima prioridad, 10 = minima prioridad): ");
                                    prioridad = scanner.nextInt();
                                    scanner.nextLine();
                                    if (prioridad < 0 || prioridad > 10) {
                                        System.out.println("Prioridad invalida. Debe ser un numero entre 0 y 10.");
                                    }
                                } while (prioridad < 0 || prioridad > 10);
                                Ticket nuevoTicket = new Ticket(descripcion, nombreCompleto, prioridad);
                                colaPendientes.insertar(nuevoTicket);
                                System.out.println("Su ticket ha sido registrado con el ID: " + nuevoTicket.getId());
                                break;
                            case 2:
                                System.out.println("Digite el ID del ticket a buscar: ");
                                int idBuscar = scanner.nextInt();
                                scanner.nextLine();
                                Ticket ticketEncontrado = listaResueltos.buscarNodo(idBuscar);
                                if (ticketEncontrado != null) {
                                    System.out.println("Ticket encontrado:");
                                    System.out.println(ticketEncontrado.toString());
                                } else {
                                    System.out.println("El ticket aun se encuentra pendiente de resolucion.");
                                }
                                break;
                            case 0:
                                System.out.println("Regresando al menu principal...");
                                break;
                            default:
                                System.out.println("Opcion no valida, intente de nuevo.");
                        }
                    } while (opcionUsuario != 0);
                    break;

                case 2:
                    int opcionAdmin;
                    do {
                        System.out.println("--- MENU ADMINISTRADOR ---");
                        System.out.println("1. Ver ticket en frente de la cola");
                        System.out.println("2. Resolver ticket en frente");
                        System.out.println("0. Regresar al menu principal");
                        System.out.println("Elija una opcion: ");
                        opcionAdmin = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionAdmin) {
                            case 1:
                                Ticket ticketFrente = colaPendientes.verFrente();
                                if (ticketFrente != null) {
                                    System.out.println("Ticket al frente de la cola:");
                                    System.out.println(ticketFrente.toString());
                                } else {
                                    System.out.println("No hay tickets pendientes en la cola.");
                                }
                                break;
                            case 2:
                                Ticket ticketResuelto = colaPendientes.remover();
                                if (ticketResuelto != null) {
                                    ticketResuelto.setFechaResolucion(LocalDate.now());
                                    listaResueltos.insertarNodoFinal(ticketResuelto);
                                    System.out.println("El ticket con ID " + ticketResuelto.getId() + " ha sido resuelto exitosamente.");
                                } else {
                                    System.out.println("La cola de tickets pendientes esta vacia.");
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al menu principal...");
                                break;
                            default:
                                System.out.println("Esa opcion no existe, seleccione otra.");
                        }
                    } while (opcionAdmin != 0);
                    break;

                case 0:
                    System.out.println("Gracias por usar el sistema. Hasta pronto.");
                    break;

                default:
                    System.out.println("La opcion ingresada no es valida.");
            }
        } while (opcionPrincipal != 0);

        scanner.close();
    }
}
