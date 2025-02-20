/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial11;

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
        
        Torneo torneo = new Torneo("local",10,4);
        //String nombre, String equipo, int goles
        Goleador g1 = new Goleador("patricio","river",4);
        Goleador g2 = new Goleador("pedro","estudiantes",2);
        Goleador g3 = new Goleador("tomas","river",3);
        Goleador g4 = new Goleador("mateo","estudiantes",4);
        
        torneo.agregarGoleador(g1, 1);
        torneo.agregarGoleador(g2, 1);
        torneo.agregarGoleador(g1, 5);
        torneo.agregarGoleador(g3, 10);
        torneo.agregarGoleador(g4, 10);
        
        System.out.print("\n");
        if (torneo.obtenerGoleadorMenosGoles(1) == null)
            System.out.println("No hay goleadores en esa fecha");
        else
            System.out.print("Goleador que efectuo menos goles en la fecha 1: " +
                    torneo.obtenerGoleadorMenosGoles(1).toString());
        
        System.out.print("\n");
        System.out.println("Cantidad de goleadores registrados en el torneo: " + torneo.obtenerCantGoleadores());
        
        System.out.print("\n");
        System.out.println(torneo.toString());
    }
    
}
