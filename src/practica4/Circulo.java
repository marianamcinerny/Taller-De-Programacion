/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author PJN
 */
public class Circulo extends Figura{
    private double radio;
    
    public Circulo(String colorR, String colorL, double radio) {
        super(colorR,colorL);
        this.radio = radio;
    }
    
    public double getRadio() {
        return radio;
    }
    
    public double calcularPerimetro() {
        return 2 * Math.PI * this.getRadio();
    }
    
    public double calcularArea() {
        return Math.PI * (this.getRadio() * this.getRadio());
    }
    
    public String toString() {
        String aux = super.toString() +
                "Radio: " + this.getRadio() + "\n";
        return aux;
    }
}
