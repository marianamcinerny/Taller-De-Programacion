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
public class Estacion {
    private String direccion;
    private Surtidor []surtidores;
    private int dimF;
    private int dimL;
    
    public Estacion(String direccion) {
        this.direccion = direccion;
        surtidores = new Surtidor[6];
        dimF = 6;
        dimL = 0;
    }
    
    public String getDireccion() {
        return this.direccion;
    }
    
    public int getCantSurtidores() {
        return this.dimL;
    }
    
    public int getCapacidadSurtidores() {
        return this.dimF;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setCapacidadSurtidores(int dimF) {
        this.dimF = dimF;
    }
    
    public void agregarSurtidor(Surtidor surtidor) {
        if (dimL < dimF) {
            surtidores[dimL] = surtidor;
            dimL++;
            System.out.println("Surtidor agregado correctamente");
        }
        else
            System.out.println("La estacion no puede tener mas surtidores");
    }
    
    public void agregarVenta(int surtidor, int dni, double cantLitros, String formaDePago) {
        surtidores[surtidor-1].agregarVenta(dni,cantLitros,formaDePago);
    }
    
    public int mayorMonto() {
        int surtidor = -1;
        double montoMax = -1;
        for (int i=0; i<dimL; i++) {
            if (surtidores[i].recaudadoEfectivo() > montoMax) {
                montoMax = surtidores[i].recaudadoEfectivo();
                surtidor = i;
            }
        }
        return surtidor;
    }
    
    public String toString() {
        String aux = "Estacion de servicio: " + direccion + ", cantidad de surtidores: " + dimL + "\n";
        if (dimL != 0)
            for (int i=0; i<dimL; i++) {
                aux += "Surtidor " + (i+1) + ". Combustible dispensado: " + surtidores[i].getCombustible() +
                        ", precio por litro: " + surtidores[i].getPrecioxLitro() + ". Ventas: " + "\n";
                aux += surtidores[i].toString();
            }
        return aux;
    }
}
