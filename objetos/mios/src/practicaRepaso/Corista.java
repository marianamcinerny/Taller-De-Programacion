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
public class Corista extends Persona {
    private int tono;
    
    public Corista (String nombre, int DNI, int edad, int tono) {
        super(nombre,DNI,edad);
        this.tono = tono;
    }
    
    public int getTono() {
        return this.tono;
    }
    
    public void setTono(int tono) {
        this.tono = tono;
    }
    
    public String toString() {
        String aux = super.toString() + " Tono: " + tono + "\n";
        return aux;
    }
}
