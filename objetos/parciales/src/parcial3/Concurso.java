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
public class Concurso {
    private Pareja []concurso;
    private int dimF;
    private int dimL;
    
    public Concurso(int dimF) {
        this.dimF = dimF;
        concurso = new Pareja[dimF];
        dimL = 0;
    }
    
    public void agregarPareja(Pareja pareja) {
        concurso[dimL] = pareja;
        dimL++;
    }
}
