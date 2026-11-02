

import java.util.Scanner;

public class Proyecto {

    static Scanner scanner = new Scanner(System.in);
    
    static void mostrarMenuPrincipal() {
        System.out.println("1. Registrar Nuevos Clientes");
        System.out.println("2.Nuevo Pedido");
        System.out.println("3.Cataalogo de Tarifas y Servicios");
        System.out.println("4.Consultar Estado de Pedido");
        System.out.println("5.Salir");
      }
      static void mostrarMenuClientes() {
        System.out.println("1. Datos del Cliente");
        System.out.print("2.Ingrese Nombre");
        
      }

      static void mostrarRegistroClienteTelefono() {
       System.out.println("DATOS DEL CLIENTE");
       System.out.print("Ingrese Numero Telefonico:");
      
      }
      
      static void mostrarMenuNuevoPedido(String nombre, String telefono) {
      System.out.println("Registro de Nuevo Pedido");
      System.out.println("DATOS DEL CLIENTE");
      System.out.println("Nombre: " + nombre);
      System.out.println("Telefono: " + telefono);
      mostrarCatalogoServiciosyTarifas();

      }
  
      
      static void mostrarCatalogoServiciosyTarifas() {
        System.out.println("1.Lavado por Kilo (Ropa diaria).......$18.00/kg");
        System.out.println("2.Lavado y planchado por docena .......$90.00/dz)");
        System.out.println("3.Planchado Express por pieza..........$10.00/pieza");
        System.out.println("4.Tintoreria / Ropa delicada por pieza.......$75.00/pz");
        System.out.println("5.Endredones / Cobijas Grandes por pieza.......$85.00/pz");
        
      }
     
      static void mostrarMenuConsulta() {
        System.out.println("Consultar estado de pedido");
        System.out.println("1. Por folio de consulta");
        System.out.println("2. Por Nombre del Cliente");
        System.out.println("3. Por Numero de Telefono");
        System.out.println("4. Salir");
        System.out.println("5. Seleccione una opcion del (1-4):");

      }

 







      
       









      
   


 static double costoKilo = 18.00;
    static double costoDocenas = 90.00;
    static double costoPlanchado = 10.00;
    static double costoPzDelicada = 75.00;
    static double costoEdredonesCobijas = 85.00;

    static double calcularSubtotalInicial(double peso, int numDocenas, int piezasPlanchado, int piezasDelicadas, int numEdredonesCobijas) {
        double subtotalPorKilo = peso * costoKilo;
        double subtotalPorDocena = numDocenas * costoDocenas;
        double subtotalPlanchadoExpress = piezasPlanchado * costoPlanchado;
        double subtotalDelicados = piezasDelicadas * costoPzDelicada;
        double subtotalEdredonCobija = numEdredonesCobijas * costoEdredonesCobijas;

        return subtotalPorKilo + subtotalPorDocena + subtotalPlanchadoExpress + subtotalDelicados + subtotalEdredonCobija;
    }

    static double calcularSubtotalAdicional(double pesoAdi, int numDocenasAdi, int piezasPlanchadoAdi, int piezasDelicadasAdi, int numEdredonesCobijasAdi) {
        double subtotalPorKiloAdi = pesoAdi * costoKilo;
        double subtotalPorDocenaAdi = numDocenasAdi * costoDocenas;
        double subtotalPlanchadoExpressAdi = piezasPlanchadoAdi * costoPlanchado;
        double subtotalDelicadosAdi = piezasDelicadasAdi * costoPzDelicada;
        double subtotalEdredonCobijaAdi = numEdredonesCobijasAdi * costoEdredonesCobijas;

        return subtotalPorKiloAdi + subtotalPorDocenaAdi + subtotalPlanchadoExpressAdi + subtotalDelicadosAdi + subtotalEdredonCobijaAdi;
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
    }
