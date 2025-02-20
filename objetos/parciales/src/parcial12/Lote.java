/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial12;

/**
 *
 * @author PJN
 */
public class Lote {
    private double precio;
    private Comprador comprador;
    
    public Lote() {
        precio = 50000;
        comprador = null;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public Comprador getComprador() {
        return comprador;
    }
    
    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
    
    public void aumentar(double porcentaje) {
        double aAumentar = (porcentaje * precio) / 100;
        precio += aAumentar;
    }
}
