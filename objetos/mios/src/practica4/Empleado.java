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
public abstract class Empleado {
    private String nombre;
    private double sueldoBasico;
    private int antiguedad;
    
    public Empleado(String nombre, double sueldoBasico, int antiguedad) {
        this.setNombre(nombre);
        this.setSueldoBasico(sueldoBasico);
        this.setAntiguedad(antiguedad);
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }
    
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public double getSueldoBasico() {
        return this.sueldoBasico;
    }
    
    public int getAntiguedad() {
        return this.antiguedad;
    }
    
    public double sueldo() {
        return this.getSueldoBasico() + ((this.getSueldoBasico() * 0.1) * this.getAntiguedad());
    }
    
    public abstract double calcularEfectividad();
    public abstract double calcularSueldoACobrar();
    
    public String toString() {
        String aux = "Nombre: " + this.getNombre() +
                    ". Sueldo a cobrar: " + this.calcularSueldoACobrar() + 
                    ". Efectividad: " + this.calcularEfectividad();
        return aux;
    }
}
