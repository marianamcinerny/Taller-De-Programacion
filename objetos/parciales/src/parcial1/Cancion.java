/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author PJN
 */
public class Cancion {
    private String nombre;
    private String compositor;
    private int id;
    private Estudiante ganador;
    private double puntaje;
    
    public Cancion(String nombre, String compositor, int id) {
        this.nombre = nombre;
        this.compositor = compositor;
        this.id = id;
        ganador = null;
        puntaje = 0;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getCompositor() {
        return this.compositor;
    }
    
    public int getID() {
        return this.id;
    }
    
    public Estudiante getGanador() {
        return this.ganador;
    }
    
    public double getPuntaje() {
        return this.puntaje;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public void setGanador(Estudiante ganador) {
        this.ganador = ganador;
    }
    
    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    
    public String toString() {
        String aux = nombre + ", " + compositor;
        return aux;
    }
}
