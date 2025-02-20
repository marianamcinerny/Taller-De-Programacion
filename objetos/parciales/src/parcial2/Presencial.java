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
public class Presencial extends Curso{
    private int numAula;
    
    public Presencial(int año, int cantAlumnos, int numAula) {
        super(año,cantAlumnos);
        this.numAula = numAula;
    }
    
    public int getNumAula() {
        return this.numAula;
    }
    
    public void setNumAula(int numAula) {
        this.numAula = numAula;
    }
    
    public boolean puedeRendir(Alumno a) {
        boolean puede = false;
        if (a.getAsistencias() >= 3)
            puede = true;
        return puede;
    }
}
