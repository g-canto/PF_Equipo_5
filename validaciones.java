import java.util.Scanner;

public class validaciones {
    static Scanner sc = new Scanner(System.in);

    public static int leerOpcionValida(Scanner sc) {
        int opcion = 0;
        boolean valida = false;
        do {
            System.out.print("Ingresa tu opcion: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    valida = true;
                } else {
                    System.out.println("Opcion invalida, intenta otra vez.");
                }
            } else {
                System.out.println("Entrada invalida. Ingresa un numero.");
                sc.next();
            }
        } while (!valida);
        return opcion;
    }

    static String leerTelefono() {
        String telefono = "";
        boolean valido = false;
        do {
            System.out.print("Ingrese el numero telefonico (10 digitos exactos): ");
            telefono = sc.nextLine().trim();
            if (telefono.matches("\\d{10}")) {
                valido = true;
            } else {
                System.out.println("Error: El telefono debe contener exactamente 10 digitos numericos.");
            }
        } while (!valido);
        return telefono;
    }

    static String leerCliente() {
        System.out.println("\n--- REGISTRO DE CLIENTE ---");
        String cliente = "";
        boolean valido = false;
        do {
            System.out.print("Ingrese el nombre del cliente: ");
            cliente = sc.nextLine().trim();
            if (cliente.length() >= 2 && cliente.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                valido = true;
            } else {
                System.out.println("Error: El nombre debe tener al menos 2 letras y no contener numeros o simbolos.");
            }
        } while (!valido);
        return cliente;
    }
    
    static int leerCantidad() {
        int cantidad = 0;
        boolean valido = false;
        do {
            System.out.print("Ingrese la cantidad (kilos o piezas > 0): ");
            if (sc.hasNextInt()) {
                cantidad = sc.nextInt();
                if (cantidad > 0) {
                    valido = true;
                } else {
                    System.out.println("La cantidad debe ser mayor a 0.");
                }
            } else {
                System.out.println("Entrada invalida. Ingrese un numero entero.");
                sc.next();
            }
        } while (!valido);
        return cantidad;
    }
}
