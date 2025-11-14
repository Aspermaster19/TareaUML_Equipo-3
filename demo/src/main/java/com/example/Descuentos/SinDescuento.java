package com.example.Descuentos;
public class SinDescuento implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double precioBase) {
        // Sin descuento
        return precioBase;
    }
}
