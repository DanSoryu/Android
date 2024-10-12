package com.dansoryucompany.convertidorgrados;

public class FAHRENHEIT extends GRADOS{
    public FAHRENHEIT(double valor) {
        super(valor, "°F");
    }

    public void parse(KELVIN kelvin) {
        this.valor = (kelvin.getValor() - 273.15) * 9 / 5 + 32;
    }

    public void parse(CELCIUS celsius) {
        this.valor = celsius.getValor() * 9 / 5 + 32;
    }

    public void parse(FAHRENHEIT fahrenheit){
        this.valor = fahrenheit.getValor();
    }
}
