/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial3;

/**
 *
 * @author PJN
 */
public class Participante {
    private String nombre;
    private int edad;
    private int dni;
    
    public Participante(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getEdad() {
        return this.edad;
    }
    
    public int getDNI() {
        return this.dni;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setDNI(int dni) {
        this.dni = dni;
    }
}
