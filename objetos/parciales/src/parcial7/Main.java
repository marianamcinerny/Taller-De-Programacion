/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial7;

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
        
        Director director = new Director("juan perez",5234523,1995,20000,25203.8);
        Empresa empresa = new Empresa("Lego","7 y 50",director,10);
        
        Encargado e1 = new Encargado("luis fernandez",65436,2000,160.75,100);
        Encargado e2 = new Encargado("juan rodriguez",43333,2020,100,60);
        
        empresa.asignarEncargado(1, e1);
        empresa.asignarEncargado(10, e2);
        
        System.out.println(empresa.toString());
    }
    
}
