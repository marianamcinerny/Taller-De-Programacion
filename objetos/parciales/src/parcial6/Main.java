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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Estacion estacion = new Estacion("7 y 50",200.48,3);
        
        /*Surtidor s1 = new Surtidor(4);
        Surtidor s2 = new Surtidor(4);
        Surtidor s3 = new Surtidor(4);
        Surtidor s4 = new Surtidor(4);
        Surtidor s5 = new Surtidor(4);
        Surtidor s6 = new Surtidor(4);
        Surtidor s7 = new Surtidor(4);*/
        
        estacion.generarVenta(1, 435453, 65.7, "credito");
        estacion.generarVenta(1, 654645, 56.16, "credito");
        estacion.generarVenta(1, 786866, 78.1, "credito");
        estacion.generarVenta(1, 234523, 52.3, "credito");
        estacion.generarVenta(6, 556454, 30.2, "credito");
        estacion.generarVenta(3, 453452, 15.7, "credito");
        estacion.generarVenta(6, 435453, 53.1, "credito");
        
        estacion.cambiarServicio(100);
        
        if (estacion.maxVenta() != null)
            System.out.println("Venta con mayor monto abonado en la estacion: " + estacion.maxVenta().toString());
        
        System.out.print("\n");
        System.out.println(estacion.toString());
        
    }
    
}
