package com.dansoryucompany.convertidorgrados;

public class GRADOS {
    protected Double valor;
    protected String unidad;

    // Constructor
    public GRADOS(Double valor, String unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
