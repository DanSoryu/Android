package com.dansoryucompany.calculadora;

public class CALCULADORA {
    private Double operando1;
    private Double operando2;

    public CALCULADORA() {
        this.operando1 = 0.0;
        this.operando2 = 0.0;
    }

    public CALCULADORA(double operando1, double operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    public double getOperando1() {
        return operando1;
    }

    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    public double getOperando2() {
        return operando2;
    }

    public void setOperando2(double operando2) {
        this.operando2 = operando2;
    }

    public double sumar() {
        return operando1 + operando2;
    }

    public double restar() {
        return operando1 - operando2;
    }

    public double multiplicar() {
        return operando1 * operando2;
    }

    public double dividir() {
        if (operando2 != 0) {
            return operando1 / operando2;
        } else {
            System.out.println("Error: División por cero");
            return Double.NaN;
        }
    }
}
