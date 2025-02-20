/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial13;

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
        
        Funcion funcion = new Funcion("La cenicienta","10 de octubre",21.30,10,15);
        
        System.out.println("Precio: " + funcion.ocuparButaca(15, 1));
        System.out.println("Precio: " + funcion.ocuparButaca(1, 1));
        System.out.println("Precio: " + funcion.ocuparButaca(1, 10));
        System.out.println("Precio: " + funcion.ocuparButaca(15, 10));
        System.out.println("Precio: " + funcion.ocuparButaca(5, 5));
        System.out.println("Precio: " + funcion.ocuparButaca(6, 5));
        System.out.println("Precio: " + funcion.ocuparButaca(10, 8));
        
        funcion.desocuparButacas(5);
        
        System.out.println(funcion.descripcionButacaB(1));
        
        System.out.println(funcion.toString());
    }
    
}
