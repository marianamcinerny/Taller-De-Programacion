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
public abstract class Alumno {
    private int dni;
    private String nombre;
    private Materia []aprobadas;
    private int dimL;
    private int dimF;
    
    public Alumno(String nombre, int dni, int dimF) {
        this.dimF = dimF;
        this.nombre = nombre;
        this.dni = dni;
        aprobadas = new Materia[dimF];
        dimL = 0;
    }
    
    public int getDNI() {
        return this.dni;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getCantidadMateriasAprobadas() {
        return this.dimL;
    }
    
    public void setDNI(int dni) {
        this.dni = dni;
    }
    
    public void serNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarMateria (Materia materia) {
        if (dimL < dimF) {
            aprobadas[dimL] = materia;
            dimL++;
        }
    }
    
    public boolean graduado(Alumno alumno) {
        boolean graduado = false;
        int i=0;
        if (dimL == dimF)
            while(i<dimF && graduado == false) {
                if (aprobadas[i].getNombre().equals("Tesis"))
                    graduado = true;
                i++;
            }
        return graduado;
    }
    
    public String toString() {
        String aux = dni + ", " + nombre + "\n";
        aux += "Materias aprobadas: " + "\n";
        if (dimL == 0)
            aux += "    No aprobo ninguna materia" + "\n";
        else
            for (int i=0; i< dimL; i++)
                aux += "    " + aprobadas[i].toString();
        aux += "Está gradudado: ";
        if (this.graduado(this))
            aux += " si.";
        else
            aux += " no.";
        aux += "\n";
        return aux;
    }
}
