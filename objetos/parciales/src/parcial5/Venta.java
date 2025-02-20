/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial5;

/**
 *
 * @author PJN
 */
public class Venta {
    private int dniCliente;
    private double litrosCargados;
    private double monto;
    private String medioDePago;
    
    public Venta (int dniCliente, double litrosCargados, double monto, String medioDePago) {
        this.dniCliente = dniCliente;
        this.litrosCargados = litrosCargados;
        this.monto = monto;
        this.medioDePago = medioDePago;
    }
    
    public int getDniCliente() {
        return this.dniCliente;
    }
    
    public double getLitrosCargados() {
        return this.litrosCargados;
    }
    
    public double getMonto() {
        return this.monto;
    }
    
    public String getMedioDePago() {
        return this.medioDePago;
    }
    
    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }
    
    public void setLitrosCargados(double litrosCargados) {
        this.litrosCargados = litrosCargados;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }
    
    public String toString() {
        String aux = "DNI del cliente: " + dniCliente + ", litros cargados: " + litrosCargados +
                ", monto abonado: " + monto + ", medio de pago: " + medioDePago;
        return aux;
    }
}
