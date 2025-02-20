/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author PJN
 */
public class Circulo {
    private double radio;
    private String colorR, colorL;
    
    public Circulo(double radio, String colorR, String colorL) {
        this.radio = radio;
        this.colorR = colorR;
        this.colorL = colorL;
    }
    
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public String getColorR() {
        return colorR;
    }
    
    public void setColorR(String colorR) {
        this.colorR = colorR;
    }
    
    public String getColorL() {
        return colorL;
    }
    
    public void setColorL(String colorL) {
        this.colorL = colorL;
    }
    
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    public double calcularArea() {
        return Math.PI * (radio*radio);
    }
}
