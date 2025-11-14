package com.example.Circo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.Descuentos.DescuentoStrategy;
import com.example.Descuentos.SinDescuento;
import com.example.Pago.MetodoPago;
import com.example.Pago.PagoTarjeta;

public class Cliente {
    private int id;
    private String nombre;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public List<Evento> consultarEventos() {
        // En un sistema real consultaría una BD. Aquí se simula.
        List<Evento> eventos = new ArrayList<>();
        eventos.add(new Evento(1, "Circo del Sol - OVO", new Date()));
        return eventos;
    }

    public Entrada comprarEntrada(int eventoId, String tipoLocalidad) {
        // 1. Configuración de dependencias
        EntradaFactory factory = new CircusEntradaFactory();
        DescuentoStrategy estrategiaDescuento = new SinDescuento();
        MetodoPago metodoPago = new PagoTarjeta();
        ServicioCompra servicio = new ServicioCompra(factory, estrategiaDescuento);

        // 2. Simulación de obtener evento y localidad
        Evento eventoDummy = new Evento(eventoId, "Circo del Sol - OVO", new Date());
        Localidad locDummy = new Localidad(tipoLocalidad, 50.0, 100);

        // 3. Procesar compra
        return servicio.procesarCompra(eventoDummy, locDummy, metodoPago);
    }
}
