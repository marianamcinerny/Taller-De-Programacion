/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial6;

/**
 *
 * @author PJN
 */
public class Venta {
    private int dni;
    private double cantm3;
    private double monto;
    private String medioDePago;
    
    public Venta(int dni, double cantm3, double monto, String medioDePago) {
        this.dni = dni;
        this.cantm3 = cantm3;
        this.monto = monto;
        this.medioDePago = medioDePago;
    }
    
    public int getDniCliente() {
        return this.dni;
    }
    
    public double getCantm3() {
        return this.cantm3;
    }
    
    public double getMonto() {
        return this.monto;
    }
    
    private String getMedioDePago() {
        return this.medioDePago;
    }
    
    public void setDniCliente(int dni) {
        this.dni = dni;
    }
    
    public void setCantm3(double cantm3) {
        this.cantm3 = cantm3;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public String toString() {
        String aux = "DNI del cliente " + dni + ", cantidad de m3 comprados: " + cantm3 + ", monto abonado: " +
                monto + ", medio de pago: " + medioDePago;
        return aux;
    }
}
