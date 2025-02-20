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
public class Director extends Persona{
    private int antiguedad;
    
    public Director (String nombre, int DNI, int edad, int antiguedad) {
        super(nombre,DNI,edad);
        this.antiguedad = antiguedad;
    }
    
    public int getAntiguedad() {
        return this.antiguedad;
    }
    
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String toString() {
        String aux = super.toString() + " Antiguedad: " + antiguedad;
        return aux;
    }
}
