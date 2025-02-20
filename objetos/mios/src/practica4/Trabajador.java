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
public class Trabajador extends Persona {
    private String trabajo;
    
    public Trabajador(String nombre, int DNI, int edad, String trabajo) {
        super(nombre,DNI,edad);
        this.trabajo = trabajo;
    }
    
    public String toString(){
        String aux = super.toString() + ". Soy " + trabajo;
        return aux;
    }
}
