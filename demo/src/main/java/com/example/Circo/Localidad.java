package com.example.Circo;
public class Localidad {
    private String tipo;
    private double precioBase;
    private int capacidadTotal;
    private int asientosDisponibles;

    public Localidad(String tipo, double precioBase, int capacidadTotal) {
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.capacidadTotal = capacidadTotal;
        this.asientosDisponibles = capacidadTotal;
    }

    public boolean reservar() {
        if (asientosDisponibles > 0) {
            asientosDisponibles--;
            return true;
        }
        return false;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }
}
