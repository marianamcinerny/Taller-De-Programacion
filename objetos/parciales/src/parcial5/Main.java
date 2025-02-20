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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Estacion estacion = new Estacion("7 y 50");
        
        Surtidor s1 = new Surtidor("vpower",200.87,5);
        Surtidor s2 = new Surtidor("super",100.54,5);
        Surtidor s3 = new Surtidor("infinia",200,5);
        
        estacion.agregarSurtidor(s1);
        estacion.agregarSurtidor(s2);
        estacion.agregarSurtidor(s3);
        estacion.agregarSurtidor(s1);
        estacion.agregarSurtidor(s3);
        estacion.agregarSurtidor(s2);
        estacion.agregarSurtidor(s3);
        
        System.out.print("\n");
        estacion.agregarVenta(1, 535435, 40.5, "efectivo");
        estacion.agregarVenta(2, 5363, 58, "credito");
        estacion.agregarVenta(6, 63453, 65.3, "debito");
        estacion.agregarVenta(2, 53453, 70, "efectivo");
        
        System.out.print("\n");
        int maxSurtidor = estacion.mayorMonto();
        if (maxSurtidor != -1)
            System.out.println("El surtidor " + (maxSurtidor+1) + " es el que mas recaudo en efectivo");
        
        System.out.print("\n");
        System.out.println(estacion.toString());
    }
    
}
