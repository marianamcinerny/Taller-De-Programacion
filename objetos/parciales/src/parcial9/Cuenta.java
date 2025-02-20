/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial9;

/**
 *
 * @author PJN
 */
public class Cuenta {
    private int cbu;
    private String alias;
    private int dni;
    private String moneda;
    private double monto;
    
    public Cuenta(int cbu, String alias, int dni, String moneda, double monto) {
        this.cbu = cbu;
        this.alias = alias;
        this.dni = dni;
        this.moneda = moneda;
        this.monto = monto;
    }

    public int getCbu() {
        return cbu;
    }

    public void setCbu(int cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }
    
    public void incrementarMonto(double monto) {
        this.monto += monto;
    }
}
