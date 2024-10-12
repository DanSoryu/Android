package com.dansoryucompany.convertidorgrados;

public class KELVIN extends GRADOS{
    public KELVIN(double valor) {
        super(valor, "K");
    }

    public void parse(CELCIUS celsius) {
        this.valor = celsius.getValor() + 273.15;
    }

    public void parse(FAHRENHEIT fahrenheit) {
        this.valor = (fahrenheit.getValor() - 32) * 5 / 9 + 273.15;
    }

    public void parse(KELVIN kelvin){
        this.valor = kelvin.getValor();
    }
}
