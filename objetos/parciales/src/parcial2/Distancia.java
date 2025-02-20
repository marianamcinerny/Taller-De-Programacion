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
public class Distancia extends Curso{
    private String link;
    
    public Distancia (int año, int cantAlumnos, String link) {
        super(año,cantAlumnos);
        this.link = link;
    }
    
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    
    public boolean puedeRendir(Alumno a) {
        boolean puede = false;
        if (a.getAprobadas() == 3 && a.getAsistencias() >= 1)
            puede = true;
        return puede;
    }
}
