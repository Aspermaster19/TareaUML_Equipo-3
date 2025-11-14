package com.example.Circo;
public class CircusEntradaFactory implements EntradaFactory {
    @Override
    public Entrada crearEntrada(Evento evento, Localidad localidad) {
        return new Entrada(evento, localidad);
    }
}
