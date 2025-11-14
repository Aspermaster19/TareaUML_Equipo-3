package com.example.Pago;
public class PagoTarjeta implements MetodoPago {
    @Override
    public boolean pagar(double monto) {
        System.out.println("Procesando pago con TARJETA por $" + monto + " ...");
        // Aquí se podría validar saldo, número de tarjeta, etc.
        System.out.println("Pago con tarjeta aprobado.");
        return true;
    }
}
