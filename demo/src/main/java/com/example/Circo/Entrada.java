package com.example.Circo;
import com.example.Descuentos.DescuentoStrategy;
public class Entrada {
    private static int contador = 1;

    private int numero;
    private Evento evento;
    private Localidad localidad;
    private double precioFinal;

    public Entrada(Evento evento, Localidad localidad) {
        this.numero = contador++;
        this.evento = evento;
        this.localidad = localidad;
    }

    public double calcularPrecio(DescuentoStrategy estrategia) {
        double base = localidad.getPrecioBase();
        this.precioFinal = estrategia.aplicarDescuento(base);
        return precioFinal;
    }

    public int getNumero() {
        return numero;
    }

    public Evento getEvento() {
        return evento;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Entrada #" + numero +
                " | Evento: " + evento.getNombre() +
                " | Localidad: " + localidad.getTipo() +
                " | Precio: $" + precioFinal;
    }
}
