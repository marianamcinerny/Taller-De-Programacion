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
public class Encargado extends Empleado{
    private int cantEmpleados;
    
    public Encargado(String nombre, int dni, int añoIngreso, double sueldoBasico, int cantEmpleados) {
        super(nombre,dni,añoIngreso,sueldoBasico);
        this.cantEmpleados = cantEmpleados;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }
    
    public double aCobrar() {
        double total = getSueldoBasico() + (1000 * cantEmpleados);
        if (calcularAntiguedad() > 20)
            total += bono();
        return total;
    }
}
