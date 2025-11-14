package com.example.Descuentos;
public class DescuentoEstudiante implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double precioBase) {
        // 50% de descuento
        return precioBase * 0.5;
    }
}
