import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColaPrioridad colaPendientes = new ColaPrioridad();
        ListaEnlazadaSimple listaResueltos = new ListaEnlazadaSimple();
        int opcionPrincipal;

        do {
            System.out.println("=== SISTEMA DE GESTION DE TICKETS ===\n");
            System.out.println("1. Menu Usuario\n");
            System.out.println("2. Menu Administrador\n");
            System.out.println("0. Salir\n");
            System.out.println("Seleccione una opcion: \n");
            opcionPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (opcionPrincipal) {
                case 1:
                    int opcionUsuario;
                    do {
                        System.out.println("--- MENU USUARIO ---\n");
                        System.out.println("1. Crear ticket\n");
                        System.out.println("2. Buscar ticket resuelto por ID\n");
                        System.out.println("0. Volver al menu principal\n");
                        System.out.println("Ingrese su opcion: \n");
                        opcionUsuario = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionUsuario) {
                            case 1:
                                System.out.println("Escriba la descripcion del problema: \n");
                                String descripcion = scanner.nextLine();
                                System.out.println("Ingrese su nombre completo: \n");
                                String nombreCompleto = scanner.nextLine();
                                Ticket nuevoTicket = new Ticket(descripcion, nombreCompleto);
                                colaPendientes.insertar(nuevoTicket);
                                System.out.println("Su ticket ha sido registrado con el ID: " + nuevoTicket.getId() + "\n");
                                break;
                            case 2:
                                System.out.println("Digite el ID del ticket a buscar: \n");
                                int idBuscar = scanner.nextInt();
                                scanner.nextLine();
                                Ticket ticketEncontrado = listaResueltos.buscarNodo(idBuscar);
                                if (ticketEncontrado != null) {
                                    System.out.println("Ticket encontrado:\n");
                                    System.out.println(ticketEncontrado.toString() + "\n");
                                } else {
                                    System.out.println("El ticket aun se encuentra pendiente de resolucion.\n");
                                }
                                break;
                            case 0:
                                System.out.println("Regresando al menu principal...\n");
                                break;
                            default:
                                System.out.println("Opcion no valida, intente de nuevo.\n");
                        }
                    } while (opcionUsuario != 0);
                    break;

                case 2:
                    int opcionAdmin;
                    do {
                        System.out.println("--- MENU ADMINISTRADOR ---\n");
                        System.out.println("1. Ver ticket en frente de la cola\n");
                        System.out.println("2. Resolver ticket en frente\n");
                        System.out.println("0. Regresar al menu principal\n");
                        System.out.println("Elija una opcion: \n");
                        opcionAdmin = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionAdmin) {
                            case 1:
                                Ticket ticketFrente = colaPendientes.verFrente();
                                if (ticketFrente != null) {
                                    System.out.println("Ticket al frente de la cola:\n");
                                    System.out.println(ticketFrente.toString() + "\n");
                                } else {
                                    System.out.println("No hay tickets pendientes en la cola.\n");
                                }
                                break;
                            case 2:
                                Ticket ticketResuelto = colaPendientes.remover();
                                if (ticketResuelto != null) {
                                    ticketResuelto.setFechaResolucion(LocalDate.now().toString());
                                    listaResueltos.insertarNodoFinal(ticketResuelto);
                                    System.out.println("El ticket con ID " + ticketResuelto.getId() + " ha sido resuelto exitosamente.\n");
                                } else {
                                    System.out.println("La cola de tickets pendientes esta vacia.\n");
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al menu principal...\n");
                                break;
                            default:
                                System.out.println("Esa opcion no existe, seleccione otra.\n");
                        }
                    } while (opcionAdmin != 0);
                    break;

                case 0:
                    System.out.println("Gracias por usar el sistema. Hasta pronto.\n");
                    break;

                default:
                    System.out.println("La opcion ingresada no es valida.\n");
            }
        } while (opcionPrincipal != 0);

        scanner.close();
    }
}
