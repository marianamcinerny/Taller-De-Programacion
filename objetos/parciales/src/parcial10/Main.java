/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial10;

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
        
        Estadio estadio = new Estadio("UNO","Avenida 1",30000);
        
        Concierto c1 = new Concierto("emilia mernes",2000,5344);
        Concierto c2 = new Concierto("tini",3424,5434);
        Concierto c3 = new Concierto("duki",3243,2333);
        Concierto c4 = new Concierto("ariana grande",5433,3423);
        Concierto c5 = new Concierto("justin bieber",5434,3423);
        
        estadio.registrarConcierto(c1, 1);
        estadio.registrarConcierto(c2, 1);
        estadio.registrarConcierto(c3, 5);
        estadio.registrarConcierto(c4, 12);
        estadio.registrarConcierto(c5, 12);
        System.out.print("\n");
        
        System.out.print(estadio.listarConciertos(12));
        System.out.print("\n");
        
        System.out.println("Ganancias del estadio es el mes 5: " + estadio.getGananciaMensual(5));
        System.out.print("\n");
        
        System.out.println(estadio.toString());
        
    }
    
}
