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
public class Doctorado extends Alumno {
    private String titulo;
    private String universidadO;
    
    public Doctorado(String nombre, int dni, int dimF, String titulo, String universidadO) {
        super(nombre,dni,dimF);
        this.titulo = titulo;
        this.universidadO = universidadO;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public String getUniversidadDeOrigen(){
        return this.universidadO;
    }
    
    public void serTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setUniversidadDeOrigen(String universidadO) {
        this.universidadO = universidadO;
    }
    
    public String toString() {
        String aux = super.toString() + "Titulo: " + titulo + ". Universidad de Origen: " + universidadO;
        return aux;
    }
}
