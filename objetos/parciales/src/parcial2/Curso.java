/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author PJN
 */
public abstract class Curso {
    private int año;
    private int dimF;
    private int dimL;
    private Alumno []alumnos;
    
    public Curso(int año, int cantAlumnos) {
        this.año = año;
        this.dimF = cantAlumnos;
        dimL = 0;
        alumnos = new Alumno[dimF];
    }
    
    public int getAño() {
        return this.año;
    }
    
    public int getCantidadAlumnos() {
        return this.dimL;
    }
    
    public void setAño(int año) {
        this.año = año;
    }
    
    public void setCantidadAlumnos(int cantAlumnos) {
        dimF = cantAlumnos;
    }
    
    public boolean agregarAlumno(Alumno a) {
        boolean aux = false;
        if (dimL < dimF) {
            alumnos[dimL] = a;
            dimL++;
            aux = true;
        }
        return aux;
    }
    
    public void incrementarAsistencia(int dni) {
        boolean encontrado = false;
        int i=0;
        while (i<dimL && encontrado == false) {
            if (alumnos[i].getDNI() == dni) {
                alumnos[i].incrementarAsistencia();
                encontrado = true;
            }
            i++;
        }
    }
    
    public void aprobarAutoevaluacion(int dni) {
        boolean encontrado = false;
        int i=0;
        while (i<dimL && encontrado == false) {
            if (alumnos[i].getDNI() == dni) {
                alumnos[i].aprobarAutoevaluacion();
                encontrado = true;
            }
            i++;
        }
    }
    
    public abstract boolean puedeRendir(Alumno a);
    
    public int cantidadDeAlumnosQuePuedenRendir() {
        int aux = 0;
        for (int i=0; i<dimL; i++)
            if (this.puedeRendir(alumnos[i]))
                aux++;
        return aux;
    }
}
