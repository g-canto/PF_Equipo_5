

public class Proyecto {

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