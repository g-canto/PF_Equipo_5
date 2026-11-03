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
      System.out.println(" *Cliente Registrado*");
    }
    System.out.println("1. Registrar Nuevo Cliente");
    System.out.println("2. Nuevo Pedido");
    System.out.println("3. Catalogo de Tarifas y Servicios");
    System.out.println("4. Consultar Estado de Pedido");
    System.out.println("5. Salir");
    System.out.print("Seleccione una opcion (1-5): ");
  }

  static void mostrarRegistroClientesNombre() {
    System.out.println("DATOS DEL CLIENTE");
    System.out.print("Ingrese Nombre (x para cancelar): ");
  }

  static void mostrarRegistroClienteTelefono() {
    System.out.print("Ingrese Numero Telefonico (0 para cancelar): ");
  }

  static void mostrarMenuNuevoPedido(String nombre, String telefono) {
    System.out.println("Registro de Nuevo Pedido");
    System.out.println("DATOS DEL CLIENTE");
    System.out.println("Nombre: " + nombre);
    System.out.println("Telefono: " + telefono);
    mostrarCatalogoServiciosyTarifas();
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
    System.out.println("Consultar estado de pedido");
    System.out.println("1. Por folio de consulta");
    System.out.println("2. Por Nombre del Cliente");
    System.out.println("3. Por Numero de Telefono");
    System.out.println("4. Salir");
    System.out.println("5. Seleccione una opcion del (1-4):");
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
    int opcionMenu, opcionPedido;
    String nombre = "",
      telefono = "";
    boolean hayCliente = false;

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
          break;
        case 2:
          if (hayCliente) {
            do {
              limpiarConsola();
              mostrarMenuNuevoPedido(nombre, telefono);
              System.out.print("Seleccione una opcion: ");
              opcionPedido = leerOpcionPedido();
              switch (opcionPedido) {
                case 1:
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
          System.out.println();
          mostrarMenuConsulta();
          break;
        case 5:
          System.out.println("Saliendo del programa...");
          break;
        default:
          //   System.out.println("Opción no válida.");
          pausar(1000);
      }
    } while (opcionMenu != 5);
  }
}
