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
public class Persona {
    private String nombre;
    private int DNI;
    private int edad;
    
    public Persona (String nombre, int DNI, int edad) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
    }
    
    public String toString() {
        String aux = "Mi nombre es " + nombre +", mi DNI es " + DNI + " y tengo " + edad + " años";
        return aux;
    }
    
}
