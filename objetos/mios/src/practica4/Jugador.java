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
public class Jugador extends Empleado{
    private int partidosJugados;
    private int golesAnotados;
    
    public Jugador (String nombre, double sueldoB, int antiguedad, int partidosJugados, int golesAnotados) {
        super(nombre,sueldoB,antiguedad);
        this.partidosJugados = partidosJugados;
        this.golesAnotados = golesAnotados;
    }
    
    public int getPartidosJugados() {
        return this.partidosJugados;
    }
    
    public int getGolesAnotados() {
        return this.golesAnotados;
    }
    
    public void setPartidosJugador(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
    
    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    
    public double calcularEfectividad() {
        if (this.getPartidosJugados() != 0)
            return this.getGolesAnotados() / this.getPartidosJugados();
        else
            return 0.0;
    }
    
    public double calcularSueldoACobrar() {
        double total = sueldo();
        if (this.calcularEfectividad() > 0.5) { 
            total += getSueldoBasico();
        }
        return total;
    }
    
    public String toString() {
        String aux = super.toString();
        return aux;
    }
}
