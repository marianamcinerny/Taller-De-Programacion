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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Barrio barrio = new Barrio("Los teros",6,9);
        
        Comprador c1 = new Comprador(5423452,"maria","fernandez","la plata");
        Comprador c2 = new Comprador(3242342,"ana","rodriguez","la plata");
        Comprador c3 = new Comprador(4132412,"julio","sanchez","city bell");
        Comprador c4 = new Comprador(4534253,"jose","hernandez","ringuelet");
        Comprador c5 = new Comprador(4523423,"julia","rodriguez","berazategui");
        
        barrio.agregarComprador(c1, 1, 1);
        barrio.agregarComprador(c2, 9, 1);
        barrio.agregarComprador(c3, 4, 4);
        barrio.agregarComprador(c4, 1, 6);
        barrio.agregarComprador(c5, 9, 6);
        
        barrio.aumentarPrecio(3, 20);
        
        System.out.print("\n");
        System.out.println(barrio.toString());
    }
    
}
