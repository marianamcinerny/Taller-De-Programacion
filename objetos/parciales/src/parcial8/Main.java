/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial8;

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
        
        Estacionamiento estacionamiento = new Estacionamiento("7 y 50", 300.5, 4, 5);
    
        Auto a1 = new Auto("abc",5,"audi","a1");
        Auto a2 = new Auto("def",1.3,"audi","a3");
        Auto a3 = new Auto("ghi",5.4,"audi","q2");
        Auto a4 = new Auto("jkl",3.2,"audi","r8");
        Auto a5 = new Auto("mnñ",0.5,"audi","tt");
        
        estacionamiento.agregarAuto(1, 5, a1);
        estacionamiento.agregarAuto(1, 1, a2);
        estacionamiento.agregarAuto(4, 1, a3);
        estacionamiento.agregarAuto(4, 5, a4);
        estacionamiento.agregarAuto(3, 3, a5);
        
        System.out.println("Autos que ya no tienen acceso: ");
        if(estacionamiento.liberarLugares("audi", 4).equals(""))
            System.out.println("   Ningun auto no tiene acceso");
        else
            System.out.println(estacionamiento.liberarLugares("audi", 4));
        
        System.out.print("\n");
        System.out.println("El sector que mas recaudo en todo el estacionamiento fue el " + 
                (estacionamiento.sectorMasRecaudo() + 1));
        
        System.out.print("\n");
        System.out.println(estacionamiento.toString());
    }
    
}
