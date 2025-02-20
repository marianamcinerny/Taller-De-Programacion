/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author PJN
 */
public class Partido {
    private String local;
    private String visitante;
    private int golesLocal;
    private int golesVisitante;
    
    public Partido() {
        
    }
    
    public Partido (String local, String visitante, int golesLocal, int golesVisitante) {
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }
    
    public String getLocal() {
        return local;
    }
    
    public String getVisitante() {
        return visitante;
    }
    
    public int getGolesLocal() {
        return golesLocal;
    }
    
    public int getGolesVisitante() {
        return golesVisitante;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }
    
    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }
    
    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }
    
    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
    
    public boolean hayGanador() {
        return golesLocal != golesVisitante;
    }
    
    public String getGanador() {
        String aux = new String();
        if (golesLocal > golesVisitante)
            aux = local;
        else
            aux = visitante;
        return aux;
    }
    
    public boolean hayEmpate() {
        return golesLocal == golesVisitante;
    }
    
    public String toString() {
        String aux;
        aux = local.toUpperCase() + " " + golesLocal + " VS " + visitante.toUpperCase() + " " + golesVisitante;
        return aux;
    }
    
}
