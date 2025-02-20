/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial14;

/**
 *
 * @author PJN
 */
public class Consumidor {
    private int cuil;
    private String nombre;
    
    public Consumidor(int cuil, String nombre) {
        this.cuil = cuil;
        this.nombre = nombre;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString() {
        String aux = nombre + ", " + cuil;
        return aux;
    }
}
