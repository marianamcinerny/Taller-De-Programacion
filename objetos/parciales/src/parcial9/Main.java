/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial9;

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
        
        Cuenta c1 = new Cuenta(1234,"aula.taller.parcial",542353,"pesos",500000);
        Cuenta c2 = new Cuenta(5678,"computadora.teclado.mouse",545345,"dolares",2000);
        Cuenta c3 = new Cuenta(9123,"a.b.c",52435,"pesos",600);
        
        Tradicional tradicional = new Tradicional("banco frances",400,3,"7 y 50","la plata");
        Digital digital = new Digital("mercado pago",200,3,"www.mercadopago.com");
        
        digital.agregarCuenta(c1);
        digital.agregarCuenta(c2);
        digital.agregarCuenta(c3);
        tradicional.agregarCuenta(c1);
        tradicional.agregarCuenta(c2);
        tradicional.agregarCuenta(c3);
        
        digital.depositarDinero(542353, 200);
        tradicional.depositarDinero(542353, 200);
        
        if (digital.puedeRecibirTarjeta(1234))
            System.out.println("La cuenta " + 1234 + " puede recibir una tarjeta");
        else
            System.out.println("La cuenta " + 1234 + " no puede recibir una tarjeta");
        
        System.out.print("\n");
        if (tradicional.puedeRecibirTarjeta(1234))
            System.out.println("La cuenta " + 1234 + " puede recibir una tarjeta");
        else
            System.out.println("La cuenta " + 1234 + " no puede recibir una tarjeta");
    }
    
}
