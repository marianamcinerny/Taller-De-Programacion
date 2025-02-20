/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial7;

/**
 *
 * @author PJN
 */
public class Director extends Empleado{
    private double montoViaticos;
    
    public Director(String nombre, int dni, int añoIngreso, double sueldoBasico, double montoViaticos) {
        super(nombre,dni,añoIngreso,sueldoBasico);
        this.montoViaticos = montoViaticos;
    }

    public double getMontoViaticos() {
        return montoViaticos;
    }

    public void setMontoViaticos(double montoViaticos) {
        this.montoViaticos = montoViaticos;
    }
    
    public double aCobrar() {
        double total = getSueldoBasico() + montoViaticos;
        if (calcularAntiguedad() > 20)
            total += bono();
        return total;
    }
}
