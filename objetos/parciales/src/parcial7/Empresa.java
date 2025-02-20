/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial7;

/**
 *
 * @author PJN
 */
public class Empresa {
    private String nombre;
    private String direccion;
    private Director director;
    private Encargado []sucursales;
    private int dimF;
    
    public Empresa(String nombre, String direccion, Director director, int cantSucursales) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.director = director;
        dimF = cantSucursales;
        sucursales = new Encargado[dimF];
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getDireccion() {
        return this.direccion;
    }
    
    public Director getDirector() {
        return this.director;
    }
    
    public int getCantSucursales() {
        return this.dimF;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setDirector(Director director) {
        this.director = director;
    }
    
    public void setCantSucursales(int dimF) {
        this.dimF = dimF;
    }
    
    public void asignarEncargado(int x, Encargado encargado) {
        sucursales[x-1] = encargado;
    }
    
    public String toString() {
        String aux = nombre + ", " + direccion + "\n";
        aux += "Director " + director.toString() + "\n";
        for (int i=0; i<dimF; i++) {
            aux += "Sucursal " + (i+1) + ": ";
            if (sucursales[i] == null)
                aux += "sucursal sin encargado" + "\n";
            else
                aux += "Encargado: " + sucursales[i].toString() + "\n";
        }
        return aux;
    }
}
