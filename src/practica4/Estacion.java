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
public class Estacion {
    String nombre;
    double latitud;
    double longitud;
    int cantAños;
    int añoInicial;
    private double []mensual;
    private double [][]anual;
    
    
    public String getNombere() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    
    public double getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
}
