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
public class Estante {
    private int dimF = 20;
    private int dimL = 0;
    private Libro[]estante;
    
    
    public Estante () {
        estante = new Libro[dimF];
        this.inicializar();
    }
    
    private void inicializar() {
        for (int i=0; i<dimF; i++)
            estante[i] = null;
    }
    
    public String agregarLibro(String titulo, String editorial, int añoEdicion, Autor primerAutor, String ISBN, double precio) {
        String aux;
        if (dimL < dimF) {
            estante[dimL] = new Libro(titulo,editorial,añoEdicion,primerAutor,ISBN,precio);
            dimL = dimL + 1;
            aux = "Libro agregado correctamente";
        }
        else
            aux = "El estante esta lleno";
        return aux;
    }
    
    public int cantLibros() {
        return dimL;
    }
    
    public boolean lleno() {
        return dimL == dimF;
    }
    
    public Libro encontrarLibro(String titulo) {
        Libro aux = null;
        for (int i=0; i<dimL; i++)
            if (estante[i].getTitulo().equals(titulo))
                aux = estante[i];
        return aux;
    }
}

