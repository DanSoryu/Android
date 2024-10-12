package com.dansoryucompany.convertidorgrados;

public class CELCIUS extends GRADOS{
    public CELCIUS(double valor) {super(valor, "°C");}

    public void parse(KELVIN kelvin) {
        this.valor = kelvin.getValor() - 273.15;
    }

    public void parse(FAHRENHEIT fahrenheit) {
        this.valor = (fahrenheit.getValor() - 32) * 5 / 9;
    }

    public void parse (CELCIUS celcius){
        this.valor= celcius.getValor();
    }
}
