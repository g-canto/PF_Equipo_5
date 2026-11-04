import java.util.Scanner;

public class Proyecto {

  static Scanner sc = new Scanner(System.in);

  static double costoKilo = 18.00;
  static double costoDocenas = 90.00;
  static double costoPlanchado = 10.00;
  static double costoPzDelicada = 75.00;
  static double costoEdredonesCobijas = 85.00;

  //Funciones auxiliares

  static void limpiarConsola() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static void pausar(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  //Funciones del Menu

  static void mostrarMenuPrincipal(boolean hayCliente) {
    System.out.println(" - B U B B L E S O F T - ");
    if (hayCliente) {
      System.out.println(" *Cliente Registrado* ");
    }
    System.out.println("1. Registrar Nuevo Cliente");
    System.out.println("2. Nuevo Pedido");
    System.out.println("3. Catalogo de Tarifas y Servicios");
    System.out.println("4. Consultar Estado de Pedido");
    System.out.println("5. Salir");
    System.out.print("Seleccione una opcion (1-5): ");
  }

  static void mostrarRegistroClientesNombre() {
    System.out.println(" DATOS DEL CLIENTE ");
    System.out.print(" Ingrese Nombre (x para cancelar): ");
  }

  static void mostrarRegistroClienteTelefono() {
    System.out.print(" Ingrese Numero Telefonico (0 para cancelar): ");
  }

  static void mostrarMenuNuevoPedido(String nombre, String telefono) {
    System.out.println("   Registro de Nuevo Pedido  ");
    System.out.println(" DATOS DEL CLIENTE ");
    System.out.println("Nombre: " + nombre);
    System.out.println("Telefono: " + telefono);
    System.out.println("----------------------------------------");
    mostrarCatalogoServiciosyTarifas();
    System.out.println("6. Terminar pedido y generar ticket");
  }

  static void mostrarCatalogoServiciosyTarifas() {
    System.out.println("1. Lavado por Kilo (Ropa diaria).......$18.00/kg");
    System.out.println("2. Lavado y planchado por docena .......$90.00/dz");
    System.out.println("3. Planchado Express por pieza..........$10.00/pieza");
    System.out.println(
      "4. Tintoreria / Ropa delicada por pieza.......$75.00/pz"
    );
    System.out.println(
      "5. Endredones / Cobijas Grandes por pieza.......$85.00/pz"
    );
  }

  static void mostrarMenuConsulta() {
    System.out.println("      Consultar estado de pedido  ");
    System.out.println("1. Por folio de consulta");
    System.out.println("2. Por Nombre del Cliente");
    System.out.println("3. Por Numero de Telefono");
    System.out.println("4. Salir");
    System.out.print("Seleccione una opcion del (1-4): ");
  }

  static void mostrarTicket(
    String nombre,
    String telefono,
    double peso,
    int numDocenas,
    int piezasPlanchado,
    int piezasDelicadas,
    int numEdredonesCobijas,
    double subtotal,
    double descuento,
    double iva,
    double total
  ) {
    System.out.println("========================================");
    System.out.println("       - B U B B L E S O F T -          ");
    System.out.println("            TICKET DE COMPRA            ");
    System.out.println("========================================");
    System.out.println("Cliente: " + nombre);
    System.out.println("Telefono: " + telefono);
    System.out.println("----------------------------------------");
    System.out.println("DETALLE DEL PEDIDO:");
    if (peso > 0) {
      System.out.println(
        "- Lavado por Kilo (" + peso + " kg): $" + (peso * costoKilo)
      );
    }
    if (numDocenas > 0) {
      System.out.println(
        "- Lavado por Docena (" +
          numDocenas +
          " dz): $" +
          (numDocenas * costoDocenas)
      );
    }
    if (piezasPlanchado > 0) {
      System.out.println(
        "- Planchado Express (" +
          piezasPlanchado +
          " pz): $" +
          (piezasPlanchado * costoPlanchado)
      );
    }
    if (piezasDelicadas > 0) {
      System.out.println(
        "- Ropa Delicada (" +
          piezasDelicadas +
          " pz): $" +
          (piezasDelicadas * costoPzDelicada)
      );
    }
    if (numEdredonesCobijas > 0) {
      System.out.println(
        "- Edredones/Cobijas (" +
          numEdredonesCobijas +
          " pz): $" +
          (numEdredonesCobijas * costoEdredonesCobijas)
      );
    }
    System.out.println("----------------------------------------");
    System.out.printf("Subtotal:          $%.2f\n", subtotal);
    System.out.printf("Descuento (10%%):  -$%.2f\n", descuento);
    System.out.printf("IVA (16%%):         $%.2f\n", iva);
    System.out.printf("TOTAL A PAGAR:     $%.2f\n", total);
    System.out.println("========================================");
  }

  // funciones de validacion

  static int leerOpcionMenuPrincipal() {
    int opcion = 0;
    do {
      opcion = sc.nextInt();
      if (opcion < 1 || opcion > 5) {
        System.out.print("Opcion invalida, intenta de nuevo: ");
      }
    } while (opcion < 1 || opcion > 5);
    return opcion;
  }

  static int leerOpcionPedido() {
    int opcion;
    do {
      opcion = sc.nextInt();
      if (opcion < 1 || opcion > 6) {
        System.out.println("Opcion invalida");
      }
    } while (opcion < 1 || opcion > 6);
    return opcion;
  }

  static int leerOpcionConsulta() {
    int opcion;
    do {
      opcion = sc.nextInt();
      if (opcion < 1 || opcion > 4) {
        System.out.print("Opcion invalida, intenta de nuevo: ");
      }
    } while (opcion < 1 || opcion > 4);
    return opcion;
  }

  static String leerNombreCliente() {
    String nombre = "";
    boolean nombreValido = false;
    do {
      nombre = sc.nextLine().trim();
      if (nombre.equalsIgnoreCase("x")) {
        return "x";
      } else if (
        nombre.length() >= 2 && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")
      ) {
        nombreValido = true;
      } else {
        System.out.println(
          "Error: El nombre debe tener al menos 2 letras y no contener numeros o simbolos."
        );
        System.out.print("Intente otra vez: ");
      }
    } while (!nombreValido);
    return nombre;
  }

  static String leerTelefonoCliente() {
    String telefono = "";
    do {
      telefono = sc.nextLine().trim();
      if (telefono.equals("0")) {
        return "0";
      }
      if (telefono.length() != 10) {
        System.out.println("Numero Invalido, intente de nuevo");
      }
    } while (telefono.length() != 10);
    return telefono;
  }

  //Funciones de procesos

  static double calcularSubtotalInicial(
    double peso,
    int numDocenas,
    int piezasPlanchado,
    int piezasDelicadas,
    int numEdredonesCobijas
  ) {
    double subtotalPorKilo = peso * costoKilo;
    double subtotalPorDocena = numDocenas * costoDocenas;
    double subtotalPlanchadoExpress = piezasPlanchado * costoPlanchado;
    double subtotalDelicados = piezasDelicadas * costoPzDelicada;
    double subtotalEdredonCobija = numEdredonesCobijas * costoEdredonesCobijas;

    return (
      subtotalPorKilo +
      subtotalPorDocena +
      subtotalPlanchadoExpress +
      subtotalDelicados +
      subtotalEdredonCobija
    );
  }

  static double calcularSubtotalAdicional(
    double pesoAdi,
    int numDocenasAdi,
    int piezasPlanchadoAdi,
    int piezasDelicadasAdi,
    int numEdredonesCobijasAdi
  ) {
    double subtotalPorKiloAdi = pesoAdi * costoKilo;
    double subtotalPorDocenaAdi = numDocenasAdi * costoDocenas;
    double subtotalPlanchadoExpressAdi = piezasPlanchadoAdi * costoPlanchado;
    double subtotalDelicadosAdi = piezasDelicadasAdi * costoPzDelicada;
    double subtotalEdredonCobijaAdi =
      numEdredonesCobijasAdi * costoEdredonesCobijas;

    return (
      subtotalPorKiloAdi +
      subtotalPorDocenaAdi +
      subtotalPlanchadoExpressAdi +
      subtotalDelicadosAdi +
      subtotalEdredonCobijaAdi
    );
  }

  static double calcularDescuento(double subtotal, boolean cupon) {
    double descuento = 0;

    if (cupon) {
      descuento = subtotal * 0.10;
    }

    return descuento;
  }

  static double calcularIva(double subtotalConDescuento) {
    return subtotalConDescuento * 0.16;
  }

  public static void main(String[] args) {
    int opcionMenu, opcionPedido, opcionConsulta;
    String nombre = "",
      telefono = "";
    boolean hayCliente = false;
    boolean hayPedido = false;

    // Variables del pedido y totales
    double peso = 0;
    int numDocenas = 0;
    int piezasPlanchado = 0;
    int piezasDelicadas = 0;
    int numEdredonesCobijas = 0;
    double subtotal = 0,
      descuento = 0,
      iva = 0,
      total = 0;

    limpiarConsola();

    do {
      limpiarConsola();
      mostrarMenuPrincipal(hayCliente);
      opcionMenu = leerOpcionMenuPrincipal();
      sc.nextLine(); // Limpiar el buffer

      switch (opcionMenu) {
        case 1:
          limpiarConsola();
          mostrarRegistroClientesNombre();
          nombre = leerNombreCliente();

          if (nombre.equalsIgnoreCase("x")) {
            System.out.println("Registro cancelado.");
            pausar(1000);
            break; // Sale del switch y regresa al menú principal
          }

          mostrarRegistroClienteTelefono();
          telefono = leerTelefonoCliente();

          if (telefono.equals("0")) {
            System.out.println("Registro cancelado.");
            pausar(1000);
            break;
          }

          hayCliente = true;
          hayPedido = false; // Reiniciar estado de pedido para nuevo cliente
          break;
        case 2:
          if (hayCliente) {
            // Reiniciar contadores para el carrito actual
            peso = 0;
            numDocenas = 0;
            piezasPlanchado = 0;
            piezasDelicadas = 0;
            numEdredonesCobijas = 0;

            do {
              limpiarConsola();
              mostrarMenuNuevoPedido(nombre, telefono);
              System.out.print("Seleccione una opcion (1-6): ");
              opcionPedido = leerOpcionPedido();

              switch (opcionPedido) {
                case 1:
                  System.out.print("Ingrese los kilos de ropa: ");
                  peso += sc.nextDouble();
                  System.out.println("Agregado al carrito.");
                  pausar(800);
                  break;
                case 2:
                  System.out.print("Ingrese el numero de docenas: ");
                  numDocenas += sc.nextInt();
                  System.out.println("Agregado al carrito.");
                  pausar(800);
                  break;
                case 3:
                  System.out.print(
                    "Ingrese el numero de piezas para planchado: "
                  );
                  piezasPlanchado += sc.nextInt();
                  System.out.println("Agregado al carrito.");
                  pausar(800);
                  break;
                case 4:
                  System.out.print("Ingrese el numero de piezas delicadas: ");
                  piezasDelicadas += sc.nextInt();
                  System.out.println("Agregado al carrito.");
                  pausar(800);
                  break;
                case 5:
                  System.out.print("Ingrese el numero de edredones/cobijas: ");
                  numEdredonesCobijas += sc.nextInt();
                  System.out.println("Agregado al carrito.");
                  pausar(800);
                  break;
                case 6:
                  sc.nextLine(); // Limpiar el buffer
                  subtotal = calcularSubtotalInicial(
                    peso,
                    numDocenas,
                    piezasPlanchado,
                    piezasDelicadas,
                    numEdredonesCobijas
                  );

                  if (subtotal > 0) {
                    System.out.print("¿Cuenta con cupon de descuento? (s/n): ");
                    String respCupon = sc.nextLine().trim();
                    boolean tieneCupon = respCupon.equalsIgnoreCase("s");

                    descuento = calcularDescuento(subtotal, tieneCupon);
                    double subtotalConDescuento = subtotal - descuento;
                    iva = calcularIva(subtotalConDescuento);
                    total = subtotalConDescuento + iva;
                    hayPedido = true;

                    limpiarConsola();
                    mostrarTicket(
                      nombre,
                      telefono,
                      peso,
                      numDocenas,
                      piezasPlanchado,
                      piezasDelicadas,
                      numEdredonesCobijas,
                      subtotal,
                      descuento,
                      iva,
                      total
                    );
                    System.out.print("Presione Enter para volver al menú...");
                    sc.nextLine();
                  } else {
                    System.out.println("No se agregaron servicios al pedido.");
                    pausar(1000);
                  }
                  break;
                default:
                  break;
              }
            } while (opcionPedido != 6);
          } else {
            System.out.println("Registra un cliente primero");
            pausar(1000);
          }
          break;
        case 3:
          limpiarConsola();
          mostrarCatalogoServiciosyTarifas();
          System.out.print("Presione Enter para volver al menú...");
          sc.nextLine();
          break;
        case 4:
          do {
            limpiarConsola();
            mostrarMenuConsulta();
            opcionConsulta = leerOpcionConsulta();
            sc.nextLine(); // Limpiar el buffer

            switch (opcionConsulta) {
              case 1:
                System.out.println("Consulta por folio pendiente...");
                pausar(1000);
                break;
              case 2:
                limpiarConsola();
                System.out.println("CONSULTA POR NOMBRE");
                System.out.print(
                  "Ingrese Nombre del Cliente (x para cancelar): "
                );
                String nombreBuscar = leerNombreCliente();

                if (nombreBuscar.equalsIgnoreCase("x")) {
                  break;
                }

                if (hayCliente && nombreBuscar.equalsIgnoreCase(nombre)) {
                  System.out.println("--- CLIENTE ENCONTRADO ---");
                  System.out.println("Nombre: " + nombre);
                  System.out.println("Telefono: " + telefono);
                  if (hayPedido) {
                    System.out.println("Estado del pedido: En proceso");
                    System.out.printf("Total a pagar: $%.2f", total);
                  } else {
                    System.out.println(
                      "Estado del pedido: Sin pedidos registrados."
                    );
                  }
                } else {
                  System.out.println(
                    "No se encontro ningun cliente con ese nombre."
                  );
                }
                System.out.print("\nPresione Enter para continuar...");
                sc.nextLine();
                break;
              case 3:
                limpiarConsola();
                System.out.println("CONSULTA POR TELEFONO");
                System.out.print(
                  "Ingrese Numero Telefonico (0 para cancelar): "
                );
                String telefonoBuscar = leerTelefonoCliente();

                if (telefonoBuscar.equals("0")) {
                  break;
                }

                if (hayCliente && telefonoBuscar.equals(telefono)) {
                  System.out.println("\n--- CLIENTE ENCONTRADO ---");
                  System.out.println("Nombre: " + nombre);
                  System.out.println("Telefono: " + telefono);
                  if (hayPedido) {
                    System.out.println("Estado del pedido: En proceso");
                    System.out.printf("Total a pagar: $%.2f\n", total);
                  } else {
                    System.out.println(
                      "Estado del pedido: Sin pedidos registrados."
                    );
                  }
                } else {
                  System.out.println(
                    "No se encontro ningun cliente con ese telefono."
                  );
                }
                System.out.print("\nPresione Enter para continuar...");
                sc.nextLine();
                break;
              case 4:
                System.out.println("Regresando al menu principal...");
                pausar(800);
                break;
              default:
                break;
            }
          } while (opcionConsulta != 4);
          break;
        case 5:
          System.out.println("Saliendo del programa...");
          break;
      }
    } while (opcionMenu != 5);
  }
}
