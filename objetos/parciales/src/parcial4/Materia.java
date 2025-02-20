/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial4;

/**
 *
 * @author PJN
 */
public class Materia {
    private String nombre;
    private double nota;
    private String fecha;
    
    public Materia(String nombre, double nota, String fecha) {
        this.nombre = nombre;
        this.nota = nota;
        this.fecha = fecha;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public double getNota() {
        return this.nota;
    }
    
    public String getFecha() {
        return this.fecha;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String toString() {
        String aux = nombre + ", " + nota + ", " + fecha + "\n";
        return aux;
    }
}
