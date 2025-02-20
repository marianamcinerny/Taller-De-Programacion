/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author PJN
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private int DNI;
    
    public Estudiante(String nombre, String apellido, int DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getApellido() {
        return this.apellido;
    }
    
    public int getDNI(){
        return this.DNI;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
    
    public String toString() {
        String aux = nombre + " " + apellido + ", DNI: " + DNI;
        return aux;
    }
}
