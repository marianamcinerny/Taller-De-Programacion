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
public abstract class Recital {
    private String nombre;
    private String []temas;
    private int dimF;
    private int dimL;
    
    public Recital(String nombre, int dimF) {
        this.nombre = nombre;
        this.dimF = dimF;
        dimL = 0;
        temas = new String[dimF];
    }
    
    public String getNombreEvento() {
        return this.nombre;
    }
    
    public int getCantidadDeTemas() {
        return this.dimF;
    }
    
    public void setNombreEvento(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCantidadDeTemas(int cantidad) {
        dimF = cantidad;
    }
    
    public void agregarTema(String cancion) {
        if (dimL<dimF) {
            temas[dimL] = cancion;
            dimL++;
            System.out.println("Cancion agregada correctamente a la lista de temas");
        }
        else
            System.out.println("Lista de temas completa");
    }
    
    public String getListaTemas() {
        int actuar = 0;
        String aux = "";
        for (int i=0; i<dimF; i++) {
            System.out.println("Y ahora tocaremos " + temas[actuar]);
            actuar++;
        }
        return aux;
    }
    
    public abstract String actuar();
    public abstract double calcularCosto();
    
    public String toString() {
        double costo = this.calcularCosto();
        String aux = "Costo del evento: " + costo + "\n";
        aux += this.actuar();
        return aux;
    }
}
