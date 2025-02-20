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
public class Estacion {
    private String direccion;
    private double precioxm3;
    private Surtidor []surtidores;
    private int dimF = 6;
    private int maxVentas;
    
    public Estacion(String direccion, double precioxm3, int maxVentas) {
        this.direccion = direccion;
        this.precioxm3 = precioxm3;
        this.maxVentas = maxVentas;
        surtidores = new Surtidor[dimF];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<dimF; i++)
            surtidores[i] = new Surtidor(maxVentas);
    }
    
   public String getDireccion() {
       return this.direccion;
   }
   
   public double getPrecioxm3() {
       return this.precioxm3;
   }
   
   public int getCantidadSurtidores() {
       return this.dimF;
   }
   
   public void setDireccion(String direccion) {
       this.direccion = direccion;
   }
   
   public void setPrecioxm3(double precioxm3) {
       this.precioxm3 = precioxm3;
   }
   
   public void setCapacidadMaxSurtidores(int dimF) {
       this.dimF = dimF;
   }
   
   public void generarVenta(int surtidor, int dni, double cantm3, String formaDePago) {
       double monto = cantm3 * precioxm3;
       surtidores[surtidor-1].agregarVenta(dni,cantm3,monto,formaDePago);
   }
   
   public void cambiarServicio(double x) {
       for (int i=0; i<dimF; i++)
           if (surtidores[i].cantm3Vendidos() < x)
               surtidores[i].setEstado(false);
   }
   
   public Venta maxVenta() {
       Venta venta = null;
       double maxMonto = -1;
       for (int i=0; i<dimF; i++)
           if (surtidores[i].maxVenta() != null)
                if (surtidores[i].maxVenta().getMonto() > maxMonto) {
                    venta = surtidores[i].maxVenta();
                    maxMonto = surtidores[i].maxVenta().getMonto();
                }
       return venta;
   }
   
   public String toString() {
       String aux = "Estacion de servicio " + direccion + ", precio por m3: " + precioxm3 + "\n";
       for (int i=0; i<dimF; i++)
            aux += "Surtidor " + (i+1) + ": " + surtidores[i].toString();
       return aux;
   }
}
