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
public class Surtidor {
    private String combustible;
    private double precioxLitro;
    private Venta []ventas;
    private int dimL;
    private int dimF;
    
    public Surtidor(String combustible, double precioxLitro, int capacidadVentas) {
        this.combustible = combustible;
        this.precioxLitro = precioxLitro;
        this.dimF = capacidadVentas;
        ventas = new Venta[dimF];
        dimL = 0;
    }
    
    public String getCombustible() {
        return this.combustible;
    }
    
    public double getPrecioxLitro() {
        return this.precioxLitro;
    }
    
    public int getCapacidadDeVentas() {
        return this.dimF;
    }
    
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
    
    public void setPrecioxLitro(double precioxLitro) {
        this.precioxLitro = precioxLitro;
    }
    
    public void setCapacidadVentas(int dimF) {
        this.dimF = dimF;
    } 
    
    public void agregarVenta(int dni, double cantLitros, String formaDePago) {
        if (dimL < dimF) {
            double monto = cantLitros * precioxLitro;
            Venta venta = new Venta(dni,cantLitros,monto,formaDePago);
            ventas[dimL] = venta;
            dimL ++;
            System.out.println("Venta cargada correctamente");
        }
        else
            System.out.println("El surtidor llego a su limite de ventas");
    }
    
    public double recaudadoEfectivo() {
        double total = 0;
        for (int i=0; i<dimL; i++)
            if (ventas[i].getMedioDePago().equals("efectivo"))
                total += ventas[i].getMonto();
        return total;
    }
    
    public String toString() {
        String aux = "";
        if (dimL == 0)
            aux += "    No hay ventas" + "\n";
        else
            for (int i=0; i<dimL; i++)
                aux += "    " + ventas[i].toString() + "\n";
        return aux;
    }
}
