/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial10;

/**
 *
 * @author PJN
 */
public class Concierto {
    private String nombre;
    private double precio;
    private int vendidas;
    
    public Concierto(String nombre, double precio, int vendidas) {
        this.nombre = nombre;
        this.precio = precio;
        this.vendidas = vendidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVendidas() {
        return vendidas;
    }

    public void setVendidas(int vendidas) {
        this.vendidas = vendidas;
    }
    
    
    public String toString() {
        String aux = nombre + ", precio de la entrada: " + precio + ", entradas vendidas: " + vendidas;
        return aux;
    }
    
}
