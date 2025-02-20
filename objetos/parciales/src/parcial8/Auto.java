/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial8;

/**
 *
 * @author PJN
 */
public class Auto {
    private String patente;
    private double horasEstacionado;
    private String marca;
    private String modelo;
    
    public Auto(String patente, double horasEstacionado, String marca, String modelo) {
        this.patente = patente;
        this.horasEstacionado = horasEstacionado;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getHorasEstacionado() {
        return horasEstacionado;
    }

    public void setHorasEstacionado(double horasEstacionado) {
        this.horasEstacionado = horasEstacionado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String toString() {
        String aux = patente + ", " + marca + ", " + modelo + ", horas estacionado: " + horasEstacionado;
        return aux;
    }
}
