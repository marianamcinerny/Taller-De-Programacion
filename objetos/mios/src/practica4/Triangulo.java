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
public class Triangulo extends Figura{
    private double lado1, lado2, lado3;
    
    public Triangulo (String colorR, String colorL, double lado1, double lado2, double lado3) {
        super(colorR,colorL);
        this.setLado1(lado1);
        this.setLado2(lado2);
        this.setLado3(lado3);
    }
    
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }
    
    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }
    
    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    
    public double getLado1() {
        return lado1;
    }
    
    public double getLado2() {
        return lado2;
    }
    
    public double getLado3() {
        return lado3;
    }
    
    public double calcularPerimetro() {
        return this.getLado1() + this.getLado2() + this.getLado3();
    }
    
    public double calcularArea() {
        double s = (this.getLado1() + this.getLado2() + this.getLado3()) / 2;
        return Math.sqrt(s * (s - this.getLado1()) * (s - this.getLado2()) * (s - this.getLado3()));
    }
    
    public String toString() {
        String aux = super.toString() +
                "Lado 1: " + this.getLado1() + "\n" +
                "Lado 2: " + this.getLado2() + "\n" +
                "Lado 3: " + this.getLado3() +"\n";
        return aux;
    }
}
