import java.util.Scanner;

public class Proyecto {

    static Scanner sc = new Scanner(System.in);

    static void mostrarMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("              BUBBLESOFT                ");
        System.out.println("   Sistema de Gestion para Lavanderia   ");
        System.out.println("========================================");
        System.out.println("[1] Registrar nuevo cliente");
        System.out.println("[2] Nuevo pedido");
        System.out.println("[3] Catalogo de tarifas y servicios");
        System.out.println("[4] Consultar estado de pedido");
        System.out.println("[5] Salir");
        System.out.print("> Seleccione una opcion [1-5]: ");
    }

    static String leerCliente() {
        System.out.println("\n--- REGISTRO DE CLIENTE ---");
        System.out.print("Ingrese el nombre del cliente: ");
        sc.nextLine(); // Limpiar buffer
        String cliente = sc.nextLine().trim();
        while (cliente.length() < 2) {
            System.out.print("El nombre debe tener al menos 2 letras. Intente de nuevo: ");
            cliente = sc.nextLine().trim();
        }
        return cliente;
    }

            //Validacion Cliente 
         static String ValiEntCli() {
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









    static String leerTelefono() {
        System.out.print("Ingrese el numero telefonico (10 digitos): ");
        String telefono = sc.nextLine().trim();
        while (telefono.length() < 7) {
            System.out.print("Telefono demasiado corto. Ingrese un numero valido: ");
            telefono = sc.nextLine().trim();
        }
            //Validacion Telefono
              static String ValEntTel() {
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



    static void mostrarCatalogo() {
        System.out.println("\n--- CATALOGO DE TARIFAS Y SERVICIOS ---");
        System.out.println("[1] Lavado por kilo (Ropa diaria)    - $18.00 / kg");
        System.out.println("[2] Lavado y planchado por docena     - $90.00 / dz");
        System.out.println("[3] Planchado express (Por pieza)     - $10.00 / pz");
        System.out.println("[4] Tintoreria / Ropa delicada        - $75.00 / pz");
        System.out.println("[5] Edredones / Cobijas grandes       - $85.00 / pz");
        System.out.println("---------------------------------------");
    }

    static double precioServicio(int opcion) {
        double precio = 0.0;
        switch (opcion) {
            case 1: precio = 18.00; break;
            case 2: precio = 90.00; break;
            case 3: precio = 10.00; break;
            case 4: precio = 75.00; break;
            case 5: precio = 85.00; break;
        }
         public static int ValEntOp(Scanner sc) {
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
                sc.next(); // Limpiar entrada incorrecta
            }




        } while (!valida);
        return opcion;
    } 
        return precio;
    }

    static int leerCantidad() {
        System.out.print("Ingrese la cantidad (kilos o piezas > 0): ");
        while (!sc.hasNextInt()) {
            System.out.print("Entrada invalida. Ingrese un numero entero mayor que 0: ");
            sc.next();
        }
        int cantidad = sc.nextInt();
        while (cantidad <= 0) {
            System.out.print("La cantidad debe ser mayor a 0. Intente de nuevo: ");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            cantidad = sc.nextInt();
        } 

        //Validar Cantidad 
         
            static int ValEntCant() {
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

    static double calcularDescuento(double subtotal) {
        double descuento = 0.0;
        if (subtotal >= 500.0) {
            descuento = subtotal * 0.10; // 10% de descuento si es >= $500
        }
        return descuento;
    }

    static void mostrarComprobante(String cliente, String telefono, double subtotal, double descuento, double iva, double total) {
        System.out.println("\n========================================");
        System.out.println("              BUBBLESOFT                ");
        System.out.println("         CONFIRMACION DE PEDIDO         ");
        System.out.println("========================================");
        System.out.println("DATOS DEL CLIENTE:");
        System.out.println("Nombre: " + cliente);
        System.out.println("Telefono: " + telefono);
        System.out.println("----------------------------------------");
        System.out.println("RESUMEN DE PAGOS:");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento (10% Promocion): $" + descuento);
        System.out.println("IVA (16%): $" + (Math.round(iva * 100.0) / 100.0));
        System.out.println("TOTAL A PAGAR: $" + (Math.round(total * 100.0) / 100.0));
        System.out.println("========================================");
        System.out.println("¡GRACIAS POR SU COMPRA!");
        System.out.println("Sus prendas estaran listas en 24 hrs.");
    }

    public static void main(String[] args) {
        int opcionMenu;
        String cliente = "";
        String telefono = "";
        boolean clienteRegistrado = false;

        do {
            mostrarMenuPrincipal();
            while (!sc.hasNextInt()) {
                System.out.print("Opcion invalida. Seleccione un numero [1-5]: ");
                sc.next();
            }
            opcionMenu = sc.nextInt();

            switch (opcionMenu) {
                case 1:
                    cliente = leerCliente();
                    telefono = leerTelefono();
                    clienteRegistrado = true;
                    System.out.println("\n>> ¡Cliente registrado con exito!");
                    break;

                case 2:
                    if (!clienteRegistrado) {
                        System.out.println("\n[Error coherencia] Debe registrar un cliente antes de crear un pedido (Opcion 1).");
                        break;
                    }

                    System.out.println("\n--- NUEVO PEDIDO ---");
                    mostrarCatalogo();
                    System.out.print("Seleccione un servicio [1-5]: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Opcion invalida. Ingrese un numero del 1 al 5: ");
                        sc.next();
                    }
                    int servicio = sc.nextInt();

                    while (servicio < 1 || servicio > 5) {
                        System.out.print("Servicio inexistente. Ingrese una opcion valida [1-5]: ");
                        while (!sc.hasNextInt()) {
                            sc.next();
                        }
                        servicio = sc.nextInt();
                    }

                    double precioUnitario = precioServicio(servicio);
                    int cantidad = leerCantidad();
                    double subtotal = precioUnitario * cantidad;

                    double descuento = calcularDescuento(subtotal);
                    double subtotalConDescuento = subtotal - descuento;
                    
                    final double TASA_IVA = 0.16;
                    double iva = subtotalConDescuento * TASA_IVA;
                    double total = subtotalConDescuento + iva;

                    mostrarComprobante(cliente, telefono, subtotal, descuento, iva, total);
                    break;

                case 3:
                    mostrarCatalogo();
                    break;

                case 4:
                    System.out.println("\n--- CONSULTAR ESTADO DE PEDIDO ---");
                    System.out.println("[1] Por Folio de consulta");
                    System.out.println("[2] Por Nombre del Cliente");
                    System.out.println("[3] Por Telefono");
                    System.out.println("Modulo informativo en desarrollo.");
                    break;

                case 5:
                    System.out.println("\nSaliendo del sistema BubbleSoft. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("\n[Error] Opcion fuera de rango. Elija del 1 al 5.");
                    break;
            }

        } while (opcionMenu != 5);

        sc.close();
    }
}