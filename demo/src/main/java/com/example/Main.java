package com.example;

import com.example.Circo.*;
import com.example.Descuentos.*;
import com.example.Pago.*;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE RESERVA DE CIRCO (SIMULACIÓN) ===\n");

        // 1. CONFIGURACIÓN INICIAL (Administrador)
        System.out.println("--- [Administrador] Configurando Evento ---");
        Evento circoSol = new Evento(1, "Circo del Sol - OVO", new Date());

        // Localidades: Palco y Grada
        Localidad palco = new Localidad("Palco", 100.0, 5);
        Localidad grada = new Localidad("Grada", 50.0, 50);

        circoSol.agregarLocalidad(palco);
        circoSol.agregarLocalidad(grada);
        System.out.println("Evento creado: " + circoSol.getNombre());
        System.out.println("Localidades configuradas.\n");

        // 2. ESCENARIO 1: Estudiante comprando en Palco con PayPal
        System.out.println("--- [Cliente 1] Compra con Descuento Estudiante y PayPal ---");
        EntradaFactory factory = new CircusEntradaFactory();
        DescuentoStrategy estrategiaEstudiante = new DescuentoEstudiante(); // 50% OFF
        MetodoPago pagoPaypal = new PagoPaypal();
        ServicioCompra servicioJuan = new ServicioCompra(factory, estrategiaEstudiante);

        Entrada entradaJuan = servicioJuan.procesarCompra(circoSol, palco, pagoPaypal);
        if (entradaJuan != null) {
            System.out.println("Ticket generado correctamente: " + entradaJuan);
        }
        System.out.println();

        // 3. ESCENARIO 2: Cliente normal en Grada con Tarjeta
        System.out.println("--- [Cliente 2] Compra Sin Descuento y Tarjeta ---");
        DescuentoStrategy estrategiaNormal = new SinDescuento();
        MetodoPago pagoTarjeta = new PagoTarjeta();
        ServicioCompra servicioMaria = new ServicioCompra(factory, estrategiaNormal);

        Entrada entradaMaria = servicioMaria.procesarCompra(circoSol, grada, pagoTarjeta);
        if (entradaMaria != null) {
            System.out.println("Ticket generado correctamente: " + entradaMaria);
        }

        // 4. Estado final
        System.out.println("\n--- Estado Final del Inventario ---");
        System.out.println("Palco disponibles: " + palco.getAsientosDisponibles());
        System.out.println("Grada disponibles: " + grada.getAsientosDisponibles());
    }
}
