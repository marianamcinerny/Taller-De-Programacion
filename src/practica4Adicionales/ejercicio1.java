/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4Adicionales;

/**
 *
 * @author PJN
 */
import PaqueteLectura.Lector;
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Zona zona = new Zona("La plata", "La Plata", "Buenos Aires");
        Electoral electoral = new Electoral(203,5,zona);
        Referendum referendum = new Referendum(204,zona);
        
        int dni,numE,numR;
        System.out.print("Ingrese su DNI: "); dni = Lector.leerInt();
        while (dni != 0) {
            System.out.print("Urna electoral - ingrese un numero: "); numE = Lector.leerInt();
            if (electoral.validarNumeroDeLista(numE))
                electoral.votarPorLista(numE);
            else
                electoral.votarEnBlanco();
            System.out.print("Urna referenfum - ingrese un numero: "); numR = Lector.leerInt();
            if (numR >= 0)
                referendum.votarAFavor();
            else if (numR < 0)
                referendum.votarEnContra();
            else
                referendum.votarEnBlanco();
            System.out.println("--------------------");
            System.out.print("Ingrese su DNI: "); dni = Lector.leerInt();
        }
        
        System.out.println(electoral.toString());
        System.out.println(referendum.toString());
    }
    
}
