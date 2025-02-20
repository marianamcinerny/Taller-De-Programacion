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
public class Habitacion {
    private double costo;
    private boolean estado;
    private Huesped huesped;
    
    public Habitacion () {
        
    }
    
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void setHuesped (Huesped huesped) {
        this.huesped = huesped;
    }
    
    public double getCosto() {
        return costo;
    }
    
    public boolean getEstado() {
        return estado;
    }
    
    public String getHuespedRep() {
        return huesped.toString();
    }
    
    
    public void aumentarCosto(double monto) {
        costo = costo + monto;
    }
    
}
