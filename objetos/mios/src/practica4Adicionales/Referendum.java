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
public class Referendum extends Urna{
    private int aFavor;
    private int enContra;
    
    public Referendum(int numero, Zona zona) {
        super(numero,zona);
        aFavor = 0;
        enContra = 0;
    }
    
    public int getAFavor() {
        return aFavor;
    }
    
    public int getEnContra() {
        return enContra;
    }
    
    public void votarAFavor() {
        this.aFavor ++;
    }
    
    public void votarEnContra() {
        this.enContra ++;
    }
    
    public int calcularGanador() {
        int aux = 0;
        if (this.getEnContra() > this.getAFavor())
            aux = -1;
        else if (this.getEnContra() < this.getAFavor())
            aux = 1;
        return aux;
    }
    
    public int calcularTotalVotos() {
        return this.getAFavor() + this.getEnContra() + getVotosB();
    }
    
}
