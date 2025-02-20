/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial3;

/**
 *
 * @author PJN
 */
public class Pareja {
    private Participante []pareja;
    private String estilo;
    
    public Pareja(String estilo, Participante p1, Participante p2) {
        pareja = new Participante[2];
        pareja[0] = p1;
        pareja[1] = p2;
        this.estilo = estilo;
    }
    
    
}
