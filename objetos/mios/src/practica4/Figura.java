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
public abstract class Figura {
    private String colorR, colorL;
    
    public Figura (String colorR, String colorL) {
        this.setColorR(colorR);
        this.setColorL(colorL);
    }
    
    public void setColorR(String colorR) {
        this.colorR = colorR;
    }
    
    public void setColorL(String colorL) {
        this.colorL = colorL;
    }
    
    public String getColorR() {
        return colorR;
    }
    
    public String getColorL() {
        return colorL;
    }
    
    public void despintar(){
        this.setColorL("negra");
        this.setColorR("blanco");
    }
    public abstract double calcularPerimetro();
    public abstract double calcularArea();
    
    public String toString() {
        String aux = "Color de relleno: " + this.getColorR() + "\n" +
                    "Color de linea: " + this.getColorL() + "\n" +
                    "Perimetro: " + this.calcularPerimetro() + "\n" +
                    "Area: " + this.calcularArea() + "\n";
        return aux;
    }
}
