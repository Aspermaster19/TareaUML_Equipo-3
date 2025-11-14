package com.example.Circo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private int id;
    private String nombre;
    private Date fecha;
    private List<Localidad> localidades;

    public Evento(int id, String nombre, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.localidades = new ArrayList<>();
    }

    public void agregarLocalidad(Localidad localidad) {
        this.localidades.add(localidad);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public Localidad buscarLocalidadPorTipo(String tipo) {
        for (Localidad l : localidades) {
            if (l.getTipo().equalsIgnoreCase(tipo)) {
                return l;
            }
        }
        return null;
    }
}
