import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private static int contador = 0;
    private int numeroCliente;
    private String nombre;

    public Cliente(String nombre) {
        this.numeroCliente = ++contador;
        this.nombre = nombre;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("-- Menú --");
            System.out.println("1 - Mostrar clientes");
            System.out.println("2 - Crear un cliente");
            System.out.println("3 - Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("-- Clientes --");
                    for (Cliente cliente : clientes) {
                        System.out.println("Cliente n.°" + cliente.getNumeroCliente() + " [" + cliente.getNombre() + "]");
                    }
                    break;
                case 2:
                    System.out.println("¿Nombre?");
                    String nombre = scanner.nextLine();
                    Cliente nuevoCliente = new Cliente(nombre);
                    clientes.add(nuevoCliente);
                    System.out.println("Cliente n.°" + nuevoCliente.getNumeroCliente() + " [" + nuevoCliente.getNombre() + "] añadido");
                    break;
                case 3:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);
    }
}