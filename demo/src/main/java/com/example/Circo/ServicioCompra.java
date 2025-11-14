package com.example.Circo;

import com.example.Descuentos.DescuentoStrategy;
import com.example.Pago.MetodoPago;
public class ServicioCompra {
    private EntradaFactory factory;
    private DescuentoStrategy descuento;

    public ServicioCompra(EntradaFactory factory, DescuentoStrategy descuento) {
        this.factory = factory;
        this.descuento = descuento;
    }

    public Entrada procesarCompra(Evento evento, Localidad localidad, MetodoPago pago) {
        // 1. Verificar disponibilidad
        if (!localidad.reservar()) {
            System.out.println("No hay asientos disponibles en " + localidad.getTipo());
            return null;
        }

        // 2. Crear la entrada usando Factory
        Entrada entrada = factory.crearEntrada(evento, localidad);

        // 3. Calcular precio usando Strategy
        double monto = entrada.calcularPrecio(this.descuento);
        System.out.println("Monto a pagar: $" + monto);

        // 4. Procesar pago
        if (pago.pagar(monto)) {
            System.out.println("Compra exitosa para: " + evento.getNombre());
            return entrada;
        } else {
            System.out.println("Pago fallido.");
            return null;
        }
    }
}
