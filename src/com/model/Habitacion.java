package com.model;
public class Habitacion {
    private int id;
    private String denominacion;

    public Habitacion() {
    }

    public Habitacion(int id, String denominacion) {
        this.id = id;
        this.denominacion = denominacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return this.denominacion;
    }
}
