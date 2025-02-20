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
public class Auto {
    private String dueño, patente;
    
    public Auto (String dueño, String patente) {
        this.dueño = dueño;
        this.patente = patente;
    }
    
    public String getPatente() {
        return patente;
    }
    
    public String toString() {
        String aux = "Dueño: " + dueño + ", patente: " + patente;
        return aux;
    }
    
}
