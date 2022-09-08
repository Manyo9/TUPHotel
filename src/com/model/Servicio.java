package com.model;
public class Servicio {
    private int id;
    private String concepto;
    private Habitacion habitacion;
    private double importe;

    public Servicio(int id, String concepto, Habitacion habitacion, double importe) {
        this.id = id;
        this.concepto = concepto;
        this.habitacion = habitacion;
        this.importe = importe;
    }

    public Servicio() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id=" + id + ", concepto=" + concepto + ", habitacion=" + habitacion + ", importe=" + importe + '}';
    }
    
}
