/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaRepaso;

/**
 *
 * @author PJN
 */
public class ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Director d1 = new Director("pepito",534534,70,30);
        Director d2 = new Director("juancito",536354,58,10);
        
        Corista c1 = new Corista("a",53534,10,1);
        Corista c2 = new Corista("b",423423,10,2);
        Corista c3 = new Corista("c",53453,10,1);
        Corista c4 = new Corista("d",656454,10,2);
        
        Semicircular semicircular = new Semicircular(d1,2);
        PorHileras porHileras = new PorHileras(d2,2);
        
        semicircular.setNombre("Coro de mierda semicircular");
        porHileras.setNombre("Coro de re mierda por hileras");
        
        semicircular.agregarCorista(c2);
        semicircular.agregarCorista(c1);
        semicircular.agregarCorista(c3);
        System.out.print("\n");
        porHileras.agregarCorista(c2);
        porHileras.agregarCorista(c4);
        porHileras.agregarCorista(c1);
        porHileras.agregarCorista(c3);
        porHileras.agregarCorista(c1);
        System.out.print("\n");
        
        System.out.print(semicircular.toString());
        System.out.print("\n");
        
        System.out.print(porHileras.toString());
        
    }
    
}
