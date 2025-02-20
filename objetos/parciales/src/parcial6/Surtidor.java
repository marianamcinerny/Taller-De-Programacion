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
public class Surtidor {
    private boolean estado;
    private int dimF;
    private int dimL;
    private Venta []ventas;
    
    public Surtidor(int dimF) {
        estado = true;
        this.dimF = dimF;
        dimL = 0;
        ventas = new Venta[dimF];
    }
    
    public boolean getEstado() {
        return this.estado;
    }
    
    public int getCantVentas() {
        return this.dimL;
    }
    
    public int getCapacidadMaxDeVentas() {
        return this.dimF;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void setCapacidadMaxVentas(int dimF) {
        this.dimF = dimF;
    }
    
    public void agregarVenta(int dni, double cantm3, double monto, String formaDePago) {
        if (dimL < dimF) {
            ventas[dimL] = new Venta(dni,cantm3,monto,formaDePago);
            dimL++;
            System.out.println("Venta agregada correctamente");
        }
        else
            System.out.println("El surtidor no puede agregar mas ventas");
    }
    
    public double cantm3Vendidos() {
        double total = 0;
        for (int i=0; i<dimL; i++)
            total += ventas[i].getCantm3();
        return total;
    }
    
    public Venta maxVenta() {
        Venta venta = null;
        double maxTotal = 0;
        for (int i=0; i<dimL; i++)
            if (ventas[i].getMonto() > maxTotal) {
                maxTotal = ventas[i].getMonto();
                venta = ventas[i];
            }
        return venta;
    }
    
    public String toString() {
        String aux = "";
        if (this.getEstado())
            aux += "En servicio. Ventas: " + "\n";
        else
            aux += "Fuera de servicio. Ventas: " + "\n";
        if (dimL == 0)
            aux += "    No se realzaron ventas." + "\n";
        else
            for (int i=0; i<dimL; i++)
                aux += "    " + ventas[i].toString() + "\n";
        return aux;
    }
}
