/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author PJN
 */
public class Huesped {
    private String nombre;
    private int DNI;
    private int edad;
    
    public Huesped (String nombre, int DNI, int edad) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
    }
    
    public Huesped () {
        
    }
    
    public String toString() {
        return "Nombre: " + nombre + ". DNI: " + DNI + ". Edad: " + edad;
    }
}
