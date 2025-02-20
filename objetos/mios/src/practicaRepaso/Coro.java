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
public abstract class Coro {
    private String nombre;
    private Director director;
    private int cantCoristas;
    
    public Coro(Director director, int cantCoristas) {
        this.director = director;
        this.cantCoristas = cantCoristas;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Director getDirector() {
        return this.director;
    }
    
    public void setDirector(Director director) {
        this.director = director;
    }
    
    public int getCantCoristas() {
        return this.cantCoristas;
    }
    
    public void setCantCoristas(int cant) {
        cantCoristas = cant;
    }
    
    public abstract void agregarCorista(Corista corista);
    public abstract boolean estaLleno();
    public abstract boolean estaOrdenado();
    
    public String toString() {
        String aux = "Nombre del coro: " + nombre + "\n" +
                "Director: " + director.toString() + "\n";
        if (this.estaOrdenado())
            aux += "Esta ordenado" + "\n";
        else
            aux += "No esta ordenado" + "\n";
        return aux;
    }
}
