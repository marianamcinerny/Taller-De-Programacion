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
public class Alumno {
    private int dni;
    private String nombre;
    private int asistencias;
    private int aprobadas;
    
    public Alumno(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        asistencias = 0;
        aprobadas = 0;
    }
    
    public int getDNI() {
        return this.dni;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getAsistencias() {
        return this.asistencias;
    }
    
    public int getAprobadas() {
        return this.aprobadas;
    }
    
    public void setDNI(int dni) {
        this.dni = dni;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void incrementarAsistencia() {
        asistencias++;
    }
    
    public void aprobarAutoevaluacion() {
        aprobadas++;
    }
}
