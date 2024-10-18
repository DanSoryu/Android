package com.dansoryucompany.recyclerview.models;

import android.graphics.Color;

public class Tortuga {

    private String Nombre;
    private String Descripcion;
    private String Arma;
    private Color color;

    public Tortuga(String nombre, String descripcion, String arma, Color color) {
        Nombre = nombre;
        Descripcion = descripcion;
        Arma = arma;
        this.color = color;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getArma() {
        return Arma;
    }

    public void setArma(String arma) {
        Arma = arma;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
