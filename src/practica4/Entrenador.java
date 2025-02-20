/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author PJN
 */
public class Entrenador extends Empleado{
    private int campeonatosGanados;
    
    public Entrenador(String nombre, double sueldoB, int antiguedad, int campeonatosGanados) {
        super(nombre,sueldoB,antiguedad);
        this.campeonatosGanados = campeonatosGanados;
    }
    
    public int getCampeonatosGanados() {
        return this.campeonatosGanados;
    }
    
    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    
    public double calcularEfectividad() {
        if (getAntiguedad() != 0)
            return this.getCampeonatosGanados() / getAntiguedad();
        else
            return 0.0;
    }
    
    public double calcularSueldoACobrar() {
        double total = sueldo();
        if (this.getCampeonatosGanados() >= 1 || this.getCampeonatosGanados() <= 4)
            total += 5000;
        else if (this.getCampeonatosGanados() >= 5 || this.getCampeonatosGanados() <= 10)
            total += 30000;
        else if (this.getCampeonatosGanados() > 10)
            total += 50000;
        return total;
    }
    
    public String toString() {
        String aux = super.toString();
        return aux;
    }
}



