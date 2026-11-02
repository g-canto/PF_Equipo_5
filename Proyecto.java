import java.util.Scanner;
public class Proyecto {

    double subtotalPorKilo = peso * costoKilo;
    double subtotalPorDocena = numDocenas * costoDocenas;
    double subtotalPlanchadoExpress = piezasPlanchado * costoPlanchado;
    double subtotalDelicados = piezasDelicadas * costoPzDelicada;
    double subtotalEdredonCobija = numEdredonesCobijas * costoEdredonesCobijas;

     double subtotalPorKiloAdi = pesoAdi * costoKilo;
        double subtotalPorDocenaAdi = numDocenasAdi * costoDocenas;
        double subtotalPlanchadoExpressAdi = piezasPlanchadoAdi * costoPlanchado;
        double subtotalDelicadosAdi = piezasDelicadasAdi * costoPzDelicada;
        double subtotalEdredonCobijaAdi = numEdredonesCobijasAdi * costoEdredonesCobijas;

    double subtotal = subtotalPorKilo + subtotalPorDocena + subtotalPlanchadoExpress + subtotalDelicados + subtotalEdredonCobija + subtotalPorKiloAdi + subtotalPorDocenaAdi + subtotalPlanchadoExpressAdi + subtotalDelicadosAdi + subtotalEdredonCobijaAdi;

      boolean cupon = false;
        double descuento = 0;

        if (cupon) {
            descuento = subtotal * 0.10;
        }


        

        double subtotalConDescuento = subtotal - descuento;

     double iva = subtotalConDescuento * 0.16;
        double totalFinal = subtotalConDescuento + iva;
 }