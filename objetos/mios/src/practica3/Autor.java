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
public class Autor {
    private String nombre;
    private String biografia;
    private String origen;
    
    public Autor (String nombre) {
        this.nombre = nombre;
        biografia = "sin biografia";
        origen = "Argentina";
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getBiografia() {
        return biografia;
    }
    
    public String getOrigen() {
        return origen;
    }
    
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    
    public void setBiografia (String biografia) {
        this.biografia = biografia;
    }
    
    public void setOrigen (String origen) {
        this.origen = origen;
    }
    
    public String toString() {
        return "Nombre: " + nombre + ". Biografia: " + biografia + ". Origen: " + origen;
    }
}
