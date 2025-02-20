/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaRepaso;

/**
 *
 * @author PJN
 */
public abstract class Persona {
    private String nombre;
    private int DNI;
    private int edad;
    
    public Persona(String nombre, int DNI, int edad) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public int getDNI() {
        return this.DNI;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public String toString() {
        String aux = nombre + ", DNI: " + DNI + ", " + edad + " años.";
        return aux;
    }
}
