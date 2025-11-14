package com.example.Pago;
public class PagoPaypal implements MetodoPago {
    @Override
    public boolean pagar(double monto) {
        System.out.println("Procesando pago con PAYPAL por $" + monto + " ...");
        // Aquí se podría simular una conexión con la API de PayPal.
        System.out.println("Pago con PayPal aprobado.");
        return true;
    }
}
