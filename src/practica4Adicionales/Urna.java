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
public abstract class Urna {
    private int numero;
    private int cantVotosB;
    private Zona zona;
    
    public Urna(int numero, Zona zona) {
        this.numero = numero;
        cantVotosB = 0;
        this.zona = zona;
    }
    
    public int getNumero() {
        return this.numero;
    }
    
    public int getVotosB() {
        return this.cantVotosB;
    }
    
    public Zona getZona() {
        return this.zona;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setZona() {
        this.zona = zona;
    }
    
    public void votarEnBlanco() {
        this.cantVotosB ++;
    }
    
    public abstract int calcularGanador();
    public abstract int calcularTotalVotos();
    
    public String toString() {
        String aux = "Urna: " + this.getNumero() + ". Zona: " + this.getZona().toString() +
                " Total votos: " + this.calcularTotalVotos() + ". Ganador: " + this.calcularGanador();
        return aux;
    }
}
