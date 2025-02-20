/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaRepaso;

/**
 *
 * @author PJN
 */
public class Dia {
    private int dia;
    private int mes;
    private int año;
    
    public Dia(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    public int getDia() {
        return this.dia;
    }
    
    public int getMes() {
        return this.mes;
    }
    
    public int getAño() {
        return this.año;
    }
    
    public void setDia(int dia) {
        this.dia = dia;
    }
    
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    public void setAño(int año) {
        this.año = año;
    }
    
    public String toString() {
        String aux = this.dia + "/" + this.mes + "/" + this.año;
        return aux;
    }
}
